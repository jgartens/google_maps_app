let map;
let coords = {lat: 39.9612, lng: -82.9988};
let marker;



function initMap() {

    let contentString = '<h2>Columbus, OH</h2> <p>Where your dreams come true.</p>';

    let infowindow = new google.maps.InfoWindow({
        content: contentString
      });
    
    let image = {url: '/sword.png', 
      scaledSize: new google.maps.Size(50, 50)};

    map = new google.maps.Map(document.getElementById('map'), {
        center:coords,
        zoom: 10,
        scrollwheel:true
        
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