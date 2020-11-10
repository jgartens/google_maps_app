let map;
let marker;



function initMap() {

    let contentString = '<h2>' + city + ', ' + state + '</h2>';

    let infowindow = new google.maps.InfoWindow({
        content: contentString
      });
    
    let image = {url: '/sword.png', 
      scaledSize: new google.maps.Size(50, 50)};

    map = new google.maps.Map(document.getElementById('map'), {
        center:coords,
        zoom: 10,
        scrollwheel:false,
        // mapTypeControlOptions: {
        //     mapTypeIds: ['roadmap', 'satellite']
        //  }
    });

    var marker = new google.maps.Marker({
        position: coords,
        map: map,
        icon: image,
        animation: google.maps.Animation.BOUNCE
    });

    google.maps.event.addListener(marker, 'click', function() {
        infowindow.open(map,marker);
     });
}

// function changeMapToSatellite(map) {
//     map.setMapTypeId('satellite');
// }