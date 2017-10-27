'use strict';

var app = app || {};

app.Renderer = (function () {
	
	function render(selector, path, data) {
		return $.get(path, function (template) {
			var html = Mustache.render(template, data);
			
            $(selector).html(html);
        });
	} 
	
	return {
		render: render
	};
}());
