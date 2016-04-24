var Helpers = {}
    , Maps  = {};

Helpers.getLocation = function (callback) {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(location){
            callback(location.coords);
        });
    } else {
        console.error("Your browser doen't support getLocation!");
    }
};

Maps.MainMap = L.map('MainMap').setView([51.505, -0.09], 13); 

Maps.GoogleLayer = new L.Google('ROADMAP');

Maps.MainMap.addLayer(Maps.GoogleLayer);

Maps.Markers = [];

Helpers.addDiseaseMarker = function (register) {
    var icon = L.icon({
        iconUrl: '/images/marker-' + register.color + '.png',
        iconSize:     [32, 48],
        iconAnchor:   [0, 0],
        popupAnchor:  [0, 0]
    });
    var marker = L.marker([register.latitude, register.longitude], {icon: icon});
    marker.bindPopup("<strong>Disease: </strong>" + register.disease.name + "<br>" +
    "<strong>Infected Total: </strong>100<br>");
    Maps.Markers.push(marker);
};

$(document).ready(function () {
    $.get('http://ec2-52-91-172-65.compute-1.amazonaws.com/Diseases', function (diseases) {
        var el = $('#DiseaseSelect');
        $.each(diseases, function(a, disease) {
            el.append($("<option></option>")
                .attr("value", disease.id).text(disease.name));
        });
    });

    $.get('http://ec2-52-91-172-65.compute-1.amazonaws.com/DiseaseRegisters', function (registers) {
        $.each(registers, function(a, register) {
            Helpers.addDiseaseMarker(register);
        });

        var group = L.featureGroup(Maps.Markers).addTo(Maps.MainMap);
        Maps.MainMap.fitBounds(group.getBounds());
    });

});
