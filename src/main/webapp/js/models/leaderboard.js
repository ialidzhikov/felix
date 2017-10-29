'use strict';

var app = app || {};

app.LeaderboardModel = (function () {

  function getAll() {
    return $.ajax({
      method: 'GET',
      url: 'api/leaderboard',
      dataType: 'json'
    });
  }
  
  return {
    getAll: getAll
  }
}());
