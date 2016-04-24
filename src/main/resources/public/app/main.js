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

});
