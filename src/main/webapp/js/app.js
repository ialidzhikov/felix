'use strict';

var app = app || {};

(function () {
	var sammy = Sammy(function () {
		var containerSelector = '#main-container';
		
		this.get('#/', function () {
			console.log('inside')
		});
		
		this.get('#/leaderboard', function () {
			console.log('inside')
			app.Renderer.render(containerSelector, 'templates/leaderboard.html')
		});
	});
	
	sammy.run('#/');
}());
