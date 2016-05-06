$(document).ready(function() {
  var domain = window.location.protocol + '//' + window.location.host;
  var currentTable;
  initMenu();

  function menuItemClickedHandler() {
    var mapping = $(this).data('target');
    $('.menu').find('li.active').removeClass('active');
    $(this).addClass('active');
    renewTableFor(mapping);
  }

  function getDataFrom(mapping) {
    var requestedUrl = domain + mapping;
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

  function getTableColumnsFor(mapping) {
    switch (mapping) {
      case '/categories':
        return ['ID', 'Name'];
      case '/questions':
        return ['ID', 'Header', 'Body', 'Category'];
    default:
    return '';
  }
}

function renewTableFor(mapping) {
  var data = getDataFrom(mapping);
  var columns = getTableColumnsFor(mapping);

  var table = TableBuilder(columns);

  $('#data').empty();
  $('#data').append(table);
  $('#data').dataTable({
    data: data,
    destroy: true
  });
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

function TableBuilder(headers) {
    var table = $('<table/>').addClass('table table-striped table-hover table-bordered'),
        thead = $('<thead/>'),
        tr = $('<tr/>');
    table.append(thead);
    thead.append(tr);

    $(headers).each(function () {
        var th = $('<th/>').text(this);
        tr.append(th);
    });

    return table;
}
