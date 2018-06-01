/**
 * Created by Damian on 12/03/2018.
 */

var map;
function myMap() {
    var mapOptions = {
        center: new google.maps.LatLng(-36.22833542388291, -61.1224014842727),
        zoom: 14,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    map = new google.maps.Map(document.getElementById("map"), mapOptions);

    google.maps.event.addListener(map, 'click', function(event) {
        placeMarker(event.latLng);
    });
}

function myMapCreate() {
    var mapOptions = {
        center: new google.maps.LatLng(-36.22833542388291, -61.1224014842727),
        zoom: 14,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    map = new google.maps.Map(document.getElementById("map"), mapOptions);

    google.maps.event.addListener(map, 'click', function(event) {
        placeMarker(event.latLng);

    });
}

var marker;
function placeMarker(location) {
    if ( marker ) {
        marker.setPosition(location);
    } else {
        marker = new google.maps.Marker({
            position: location,
            draggable: true,
            animation: google.maps.Animation.DROP,
            map: map
        });
    }
    $("#latitud").val(marker.getPosition().lat());
    $("#longitud").val(marker.getPosition().lng());
}

