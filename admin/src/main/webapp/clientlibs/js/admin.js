$(document).ready(function() {
  var domen = window.location.protocol + '//' + window.location.host;
  initMenu();

  function menuItemClickedHandler() {
    $('.menu').find('li.active').removeClass('active');
    $(this).addClass('active');
    var mapping = $(this).data('target');
    getDataFrom(mapping);
  }

  function getDataFrom(mapping) {
    var requestedUrl = domen + mapping;
    var currentData;
    $.ajax({
      url: requestedUrl,
      type: 'GET',
      cache: false,
      contentType: false,
      processData: false,
      async: false,
      success: function(data) {
        currentData = data;
      },
      error: ajaxErrorHandler
    });
    return currentData;
  }

  function initMenu() {
    var menu = $('.menu');
    var menuItems = $(menu).find('li');
    menuItems.each(function() {
      $(this).on('click', menuItemClickedHandler);
    });
  }
});

function ajaxErrorHandler(data) {
  showErrorBlock(data.statusText);
}

function showErrorBlock(msg) {
  var $error = $('#error');
  $error.find("span").text(msg);
  $error.show().delay(5000).fadeOut();
}
