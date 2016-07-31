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
                $('.help-method').hide();
                $('.help-method.water').show();
            });
            $('#gas').click(function () {
                self.type = "gas";
                self.requestData();
                $("main").removeClass();
                $("main").addClass("gas");
                $('.btn-filter input[type=checkbox]').prop('checked', false);
                $(this).prop('checked', true);
                $('.help-method').hide();
                $('.help-method.gas').show();
            });
            $('#electricity').click(function () {
                self.type = "electr";
                self.requestData();
                $("main").removeClass();
                $("main").addClass("electricity");
                $('.btn-filter input[type=checkbox]').prop('checked', false);
                $(this).prop('checked', true);
                $('.help-method').hide();
                $('.help-method.electricity').show();
            });
            $('#homelessness').click(function () {
                self.type = "homele";
                self.requestData();
                $("main").removeClass();
                $("main").addClass("homelessness");
                $('.btn-filter input[type=checkbox]').prop('checked', false);
                $(this).prop('checked', true);
                $('.help-method').hide();
                $('.help-method.homelessness').show();
            });

            this.map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: -28.8263257, lng: 133.3605215},
                zoom: 5,
                scrollwheel: false,
                zoomControlOptions: {
                    position: google.maps.ControlPosition.RIGHT_CENTER
                },
                mapTypeControl: false
            });

            var styles = [{"featureType":"landscape","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"transit","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"poi","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"water","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"road","elementType":"labels.icon","stylers":[{"visibility":"off"}]},{"stylers":[{"hue":"#00aaff"},{"saturation":-100},{"gamma":2.15},{"lightness":12}]},{"featureType":"road","elementType":"labels.text.fill","stylers":[{"visibility":"on"},{"lightness":24}]},{"featureType":"road","elementType":"geometry","stylers":[{"lightness":57}]}];

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
                radius: magnitude,
                strokeColor: colour,
                strokeOpacity: 0.8,
                strokeWeight: .2,
                fillColor: colour,
                fillOpacity: .7
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

            $.ajax({
                method: "GET",
                url: url,
                dataType: 'JSON',
                crossOrigin: true,

                success: function (data, textStatus, jqXHR) {

                    self.objects = [];

                    if (data.status != "200") {
                        return true;
                    }
                    console.log("Rice review");
                    console.log(data.dataUsageItem[0].riceReview);
                    data.dataUsageItem.forEach(function (object, index, array) {

                        object.colour = self.getColour();
                        self.objects.push(object);
                    });

                    self.displayMarkers(data);
                }
            });

        },

        'getColour': function() {
            switch(this.type) {
                case 'water':
                    return '#75B9E6';
                case 'gas':
                    return '#FF8083';
                case 'electr':
                    return '#FFCE6E';
                case 'homele':
                    return '#3D84D3';
            }
        }

    };


    window.App.MapController = MapController;

})(jQuery, window);