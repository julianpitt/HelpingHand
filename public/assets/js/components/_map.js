;(function () {

    var MapController = {

        markers: [],
        map: null,
        type: 'water',

        init: function () {

            var self = this;

            $('#water').click(function() {
                self.type = "water";
                self.requestData();
                $("main").removeClass();
                $("main").addClass("water");
            });
            $('#gas').click(function() {
                self.type = "gas";
                self.requestData();
                $("main").removeClass();
                $("main").addClass("gas");
            });
            $('#electricity').click(function() {
                self.type = "electricity";
                self.requestData();
                $("main").removeClass();
                $("main").addClass("electricity");
            });
            $('#homelessness').click(function() {
                self.type = "homelessness";
                self.requestData();
                $("main").removeClass();
                $("main").addClass("homelessness");
            });

            this.map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: -28.7065578, lng: 125.5366166},
                zoom: 5,
                scrollwheel: false,
                mapTypeControl: false,
            });

            var styles =
                    [{
                        "featureType": "all",
                        "elementType": "labels.text.fill",
                        "stylers": [{"color": "#ffffff"}]
                    }, {
                        "featureType": "all",
                        "elementType": "labels.text.stroke",
                        "stylers": [{"color": "#000000"}, {"lightness": 13}]
                    }, {
                        "featureType": "administrative",
                        "elementType": "geometry.fill",
                        "stylers": [{"color": "#000000"}]
                    }, {
                        "featureType": "administrative",
                        "elementType": "geometry.stroke",
                        "stylers": [{"color": "#144b53"}, {"lightness": 14}, {"weight": 1.4}]
                    }, {
                        "featureType": "landscape",
                        "elementType": "all",
                        "stylers": [{"color": "#176645"}]
                    }, {
                        "featureType": "poi",
                        "elementType": "geometry",
                        "stylers": [{"color": "#0c4152"}, {"lightness": 5}]
                    }, {
                        "featureType": "road.highway",
                        "elementType": "geometry.fill",
                        "stylers": [{"color": "#176645"}]
                    }, {
                        "featureType": "road.highway",
                        "elementType": "geometry.stroke",
                        "stylers": [{"color": "#176645"}, {"lightness": 25}]
                    }, {
                        "featureType": "road.arterial",
                        "elementType": "geometry.fill",
                        "stylers": [{ "visibility": "off" }]
                    }, {
                        "featureType": "road.arterial",
                        "elementType": "geometry.stroke",
                        "stylers": [{ "visibility": "off" }, {"lightness": 16}]
                    }, {
                        "featureType": "road.local",
                        "elementType": "geometry",
                        "stylers": [{ "visibility": "off" }]
                    }, {
                        "featureType": "transit",
                        "elementType": "all",
                        "stylers": [{"color": "#146474"}]
                    }, {"featureType": "water", "elementType": "all", "stylers": [{"color": "#021019"}]}]
                ;

            this.map.setOptions({styles: styles});
            $('#water').click();
        },

        displayMarkers: function() {
            this.markers = [];

        },
        removeMarkers: function() {
            this.markers.forEach(function(value, index, array) {
                value.map = null;
            });
        },
        requestData: function() {

            var baseUrl = "http://helpinghandapi.ddns.net:11000/";
            var zoom = this.map.getZoom();
            var center = this.map.getCenter();
            var lat = center.lat();
            var lng = center.lng();
            var url = baseUrl + 'usage/get/'+lat+'/'+lng+"/"+zoom+"/"+this.type;

            console.log(url);

            $.ajax({
                method: "GET",
                url: url,
                dataType: 'JSON',
                crossOrigin: true,

                success: function(data, textStatus, jqXHR) {
                    console.log(data);
                    if(data.status != "200") {
                        return true;
                    }

                    data.dataUsageItem.forEach(function(object, index, array){
                        console.log(object.lng, onject.lat);
                    });
                    // this.removeMarkers();
                    // this.displayMarkers(data);
                }
            });

        }

    };

    window.App.MapController = MapController;

})(jQuery, window);