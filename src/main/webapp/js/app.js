'use strict';

var app = app || {};

(function () {
  var sammy = Sammy(function () {
    var containerSelector = '#main-container';

    this.get('#/', function () {
    });

    this.get('#/leaderboard', function () {
      app.TopicModel.getAll()
         .done(function (topics) {
           app.LeaderboardModel.getAll()
             .done(function (leaderboards) {
               var data = { 
                 topics: topics,
                 leaderboards: leaderboards,
               };
               
               app.Renderer.render(containerSelector, 'templates/leaderboard.html', data)
             });
         });
    });
  });

  sammy.run('#/');
}());
