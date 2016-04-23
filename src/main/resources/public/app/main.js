var Helpers = {};

Helpers.getLocation = function (callback) {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(location){
            callback(location.coords);
        });
    } else {
        console.error("Your browser doen't support getLocation!");
    }
};


$(document).ready(function () {

});