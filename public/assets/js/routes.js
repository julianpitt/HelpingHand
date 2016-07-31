;(function (window, $, App) {

    'use strict';

    App.Routes = {
        // Fired in all pages
        'init': function  () {
            this.smoothscroll();
        },

        '.draggable': function() {
          $('.draggable').draggable({
              containment: 'parent'
          });
        },
        
        '.affix-scroll': function() {
            $('.affix-scroll').affix({
                offset: {
                    top: $(window).height() + $('.affix-scroll').height()
                }
            });
        },

        'smoothscroll': function() {
            // Add smooth scrolling to all links
            $("main a").on('click', function(event) {

                // Make sure this.hash has a value before overriding default behavior
                if (this.hash !== "") {
                    // Prevent default anchor click behavior
                    event.preventDefault();

                    // Store hash
                    var hash = this.hash;

                    // Using jQuery's animate() method to add smooth page scroll
                    // The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area
                    $('html, body').animate({
                        scrollTop: $(hash).offset().top
                    }, 800, function(){

                        // Add hash (#) to URL when done scrolling (default click behavior)
                        window.location.hash = hash;
                    });
                } // End if
            });
        },
        //
        // Based on component

        /*'#communityBoard': function() {
            App.NoticeBoard = new NoticeBoard($('#communityBoard'), {});
        },*/

    };

})(window, jQuery, App);