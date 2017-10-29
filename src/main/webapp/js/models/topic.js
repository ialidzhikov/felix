'use strict';

var app = app || {};

app.TopicModel = (function () {

  function getAll() {
    return $.ajax({
      method: 'GET',
      url: 'api/topics',
      dataType: 'json'
    });
  }

  return {
    getAll: getAll
  }
}());
