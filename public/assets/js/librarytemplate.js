/*
 * __JsLibrary__ plugin
 *
 * Data attributes:
 * - data-control="__js-library__" - enables the plugin on an element
 *
 * JavaScript API:
 * $('input#someElement').__jsLibrary__()
 *
 * Dependencies:
 * - ....
 */

+function ($) { "use strict";

    // __JsLibrary__ CLASS DEFINITION
    // ============================

    var __JsLibrary__ = function(element, options) {
        var self       = this;
        this.options   = options;

        this.init()
    };

    __JsLibrary__.DEFAULTS = {
    };

    __JsLibrary__.prototype.init = function() {
        var self = this

    };

    // __JsLibrary__ PLUGIN DEFINITION
    // ============================

    var old = $.fn.__jsLibrary__;

    $.fn.__jsLibrary__ = function (option) {
        var args = Array.prototype.slice.call(arguments, 1);
        return this.each(function () {
            var $this   = $(this);
            var data    = $this.data('trueper.__js-library__');
            var options = $.extend({}, __JsLibrary__.DEFAULTS, $this.data(), typeof option == 'object' && option);
            if (!data) $this.data('trueper.__js-library__', (data = new __JsLibrary__(this, options)));
            else if (typeof option == 'string') data[option].apply(data, args)
        })
    };

    $.fn.__jsLibrary__.Constructor = __JsLibrary__;

    // __JsLibrary__ NO CONFLICT
    // =================

    $.fn.__jsLibrary__.noConflict = function () {
        $.fn.__jsLibrary__ = old;
        return this
    };

    // __JsLibrary__ DATA-API
    // ===============

    $(document).on('ready', function () {
        $('[data-control="__js-library__"]').__jsLibrary__()
    })

}(window.jQuery);