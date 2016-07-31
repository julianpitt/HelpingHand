;(function () {

    var MapController = {

        markers: [],
        map: null,
        type: 'water',
        openMarker: null,
        objects: [],

        init: function () {

            var self = this;

            $('#water').click(function () {
                self.type = "water";
                self.requestData();
                $("main").removeClass();
                $("main").addClass("water");
                $('.btn-filter input[type=checkbox]').prop('checked', false);
                $(this).prop('checked', true);
            });
            $('#gas').click(function () {
                self.type = "gas";
                self.requestData();
                $("main").removeClass();
                $("main").addClass("gas");
                $('.btn-filter input[type=checkbox]').prop('checked', false);
                $(this).prop('checked', true);
            });
            $('#electricity').click(function () {
                self.type = "electricity";
                self.requestData();
                $("main").removeClass();
                $("main").addClass("electricity");
                $('.btn-filter input[type=checkbox]').prop('checked', false);
                $(this).prop('checked', true);
            });
            $('#homelessness').click(function () {
                self.type = "homelessness";
                self.requestData();
                $("main").removeClass();
                $("main").addClass("homelessness");
                $('.btn-filter input[type=checkbox]').prop('checked', false);
                $(this).prop('checked', true);
            });

            this.map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: -28.8263257, lng: 133.3605215},
                zoom: 5,
                scrollwheel: false,
                mapTypeControl: false
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
                        "stylers": [{"visibility": "off"}]
                    }, {
                        "featureType": "road.arterial",
                        "elementType": "geometry.stroke",
                        "stylers": [{"visibility": "off"}, {"lightness": 16}]
                    }, {
                        "featureType": "road.local",
                        "elementType": "geometry",
                        "stylers": [{"visibility": "off"}]
                    }, {
                        "featureType": "transit",
                        "elementType": "all",
                        "stylers": [{"color": "#146474"}]
                    }, {"featureType": "water", "elementType": "all", "stylers": [{"color": "#021019"}]}]
                ;

            this.map.setOptions({styles: styles});
            $('#water').click();
        },

        displayMarkers: function () {

            var self = this;
            this.removeMarkers();

            for (var i = 0; i < self.objects.length; i++) {

                var obj = self.objects[i];

                var latLng = new google.maps.LatLng(obj.lat, obj.lng);
                var circle = self.getCircle(latLng, obj.value, obj.colour);

                circle.setMap(self.map);

                self.markers.push(circle);

            }

        },

        getCircle: function (latLng, magnitude, colour) {
            return new google.maps.Circle({
                center: latLng,
                radius: 80000,
                strokeColor: colour,
                strokeOpacity: 0.8,
                strokeWeight: .2,
                fillColor: colour,
                fillOpacity: .4,
            });
        },

        removeMarkers: function () {

            //Loop through all the markers and remove
            for (var i = 0; i < this.markers.length; i++) {
                this.markers[i].setMap(null);
            }
            this.markers = [];

        },

        mapClick: function (index) {

            var index = index - 1;

            if (this.openInfoBox !== null) {
                this.openInfoBox.close();
                this.openInfoBox = null;
            }

            if (this.openMarker !== null) {
                this.openMarker = null;
            }

            google.maps.event.trigger(markers[index], 'click');

            this.map.setZoom(14);
            this.map.setCenter(this.markers[index].getPosition());
        },

        requestData: function () {

            var baseUrl = "http://helpinghandapi.ddns.net:11000/";
            var zoom = this.map.getZoom();
            var center = this.map.getCenter();
            var lat = center.lat();
            var lng = center.lng();
            var url = baseUrl + 'usage/get/' + lat + '/' + lng + "/" + zoom + "/" + this.type;
            var self = this;
            console.log(url);

            $.ajax({
                method: "GET",
                url: url,
                dataType: 'JSON',
                crossOrigin: true,

                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    self.objects = [];
                    if (data.status != "200") {
                        return true;
                    }

                    data.dataUsageItem.forEach(function (object, index, array) {
                        object.colour = 'red';
                        self.objects.push(object);
                    });

                    self.displayMarkers(data);
                }
            });

        }

    };

    window.App.MapController = MapController;

})(jQuery, window);