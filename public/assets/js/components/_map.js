;(function () {

    var MapController = {

        markers: [],
        map: null,
        type: 'water',
        openMarker: null

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

            this.removeMarkers();
            var ibOptions = {
                disableAutoPan: false,
                maxWidth: 0,
                pixelOffset: new google.maps.Size(-130, -175),
                zIndex: null,
                boxStyle: {
                    padding: "0px 0px 0px 0px",
                    width: "252px",
                    height: "120px"
                },
                closeBoxURL : "",
                infoBoxClearance: new google.maps.Size(1, 1),
                isHidden: false,
                pane: "floatPane",
                enableEventPropagation: false
            };

            // Origins, anchor positions and coordinates of the marker increase in the X
            // direction to the right and in the Y direction down.
            var image = {
                url: '/assets/img/mapmarker.png',
                // This marker is 20 pixels wide by 32 pixels high.
                size: new google.maps.Size(62, 41),
                // The origin for this image is (0, 0).
                origin: new google.maps.Point(0, 0),
                // The anchor for this image is the base of the flagpole at (0, 32).
                anchor: new google.maps.Point(31, 41)
            };

            // Shapes define the clickable region of the icon. The type defines an HTML
            // <area> element 'poly' which traces out a polygon as a series of X,Y points.
            // The final coordinate closes the poly by connecting to the first coordinate.
            var shape = {
                coords: [0, 0, 62, 41],
                type: 'rect'
            };

            for (var i = 0; i < customers.length; i++) {

                var customer = customers[i];
                if(customer.type.toUpperCase() == "<?= \App\Models\Customer::TYPE_MAR ?>" ) {
                    customer.is_mar = true;
                    customer.is_edlyn = false;
                    customer.mapicon = marimage;
                }
                if(customer.type.toUpperCase() == "<?= \App\Models\Customer::TYPE_EDLYN ?>" ) {
                    customer.is_mar = false;
                    customer.is_edlyn = true;
                    customer.mapicon = edlynimage;
                }

                var source   = $("#entry-template").html();
                var template = Handlebars.compile(source);
                var contentString    = template(customer);
                var ib = new InfoBox(ibOptions);
                var options = {
                    position: {lat: customer.lat, lng: customer.lng},
                    map: map,
                    icon: customer.mapicon,
                    shape: shape,
                    title: customer.name,
                    padding: 0,
                    zIndex: i
                };

                if(filter !== null) {
                    if(filter != customers[i].type) {
                        options = {visible: false};
                    }
                }

                var marker = new google.maps.Marker(options);

                google.maps.event.addListener(marker,'click', (function(marker,contentString, customer, ib){
                    return function() {
                        if(openMarker == customer.ID) {
                            openInfoBox.close();
                            openInfoBox = null;
                            openMarker = null;
                        } else {
                            if (openInfoBox!==null) {
                                openInfoBox.close();
                            }
                            openMarker = customer.ID;
                            openInfoBox = ib;
                            ib.setContent(contentString);
                            ib.open(map,marker);
                            mapTitle.html(customer.businessname);
                        }
                    };
                })(marker,contentString, customer, ib));

                markers.push(marker);
            }

            for (var i = 0; i < markers.length; i++) {
                bounds.extend(markers[i].getPosition());
            }

            map.fitBounds(bounds);

            zoomChangeBoundsListener = google.maps.event.addListenerOnce(map, 'bounds_changed', function(event) {
                if (this.getZoom() && this.getZoom() > 16){
                    this.setZoom(16);
                }
            });
            setTimeout(function(){google.maps.event.removeListener(zoomChangeBoundsListener)}, 2000);

        },
        removeMarkers: function() {
            //Loop through all the markers and remove
            for (var i = 0; i < this.markers.length; i++) {
                this.markers[i].setMap(null);
            }
            this.markers = [];
        },

        mapClick: function(index) {

            var index = index-1;

            if(this.openInfoBox !== null) {
                this.openInfoBox.close();
                this.openInfoBox = null;
            }

            if(this.openMarker !== null) {
                this.openMarker = null;
            }

            google.maps.event.trigger(markers[index], 'click');

            this.map.setZoom(14);
            this.map.setCenter(this.markers[index].getPosition());
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