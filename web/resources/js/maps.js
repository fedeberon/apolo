/**
 * Created by Damian on 12/03/2018.
 */
function myMap() {
    var mapOptions = {
        center: new google.maps.LatLng(-36.22833542388291, -61.1224014842727),
        zoom: 14,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    var map = new google.maps.Map(document.getElementById("map"), mapOptions);
}