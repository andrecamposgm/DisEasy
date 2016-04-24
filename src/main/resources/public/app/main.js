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

$(document).ready(function () {
    $.get('http://ec2-52-91-172-65.compute-1.amazonaws.com//Diseases', function (diseases) {
        var el = $('#DiseaseSelect');
        $.each(diseases, function(a, disease) {
            el.append($("<option></option>")
                .attr("value", disease.id).text(disease.name));
        });
    });
});
