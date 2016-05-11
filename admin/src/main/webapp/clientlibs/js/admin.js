$(document).ready(function() {
  const domain = window.location.protocol + '//' + window.location.host;
  initMenu();
  initForms();

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

  function getTableColumnsHeadersFor(mapping) {
    switch (mapping) {
      case '/categories':
        return ['ID', 'Name', 'Created', 'Created by ', 'Updated', 'Updated by'];
      case '/branches':
        return ['ID', 'Name', 'Category', 'Created', 'Created by ', 'Updated', 'Updated by'];
      case '/questions':
        return ['ID', 'Header', 'Body', 'Category', 'Created', 'Created by ', 'Updated', 'Updated by'];
      case '/answers':
        return ['ID', 'Body', 'Created', 'Created by ', 'Updated', 'Updated by'];
      case '/organizations':
        return ['ID', 'Name', 'Description', 'Foundation date', 'Category', 'Created', 'Created by ', 'Updated', 'Updated by'];
      case '/locations':
        return ['ID', 'Name', 'Lat', 'Long', 'Created', 'Created by ', 'Updated', 'Updated by'];
      case '/services':
        return ['ID', 'Name', 'Category', 'Created', 'Created by ', 'Updated', 'Updated by'];
      case '/users':
        return ['ID', 'Full Name', 'Email', 'Birth date', 'Last login', 'Created', 'Created by ', 'Updated', 'Updated by'];
      case '/roles':
        return ['ID', 'Name', 'Created', 'Created by ', 'Updated', 'Updated by'];
      default:
        return '';
    }
  }

  function getTableColumnDefsFor(mapping) {
    switch (mapping) {
      case '/categories':
        return ['id', 'name', 'creationTime', 'creator', 'updateTime', 'updater'];
      case '/branches':
        return ['id', 'name', 'category', 'creationTime', 'creator', 'updateTime', 'updater'];
      case '/questions':
        return ['id', 'header', 'body', 'category', 'creationTime', 'creator', 'updateTime', 'updater'];
      case '/answers':
        return ['id', 'body', 'creationTime', 'creator', 'updateTime', 'updater'];
      case '/organizations':
        return ['id', 'name', 'description', 'foundationDate', 'category', 'creationTime', 'creator', 'updateTime', 'updater'];
      case '/locations':
        return ['id', 'name', 'latitude', 'longitude', 'creationTime', 'creator', 'updateTime', 'updater'];
      case '/services':
        return ['id', 'name', 'category', 'creationTime', 'creator', 'updateTime', 'updater'];
      case '/users':
        return ['id', 'fullName', 'email', 'birthDate', 'lastLogin', 'creationTime', 'creator', 'updateTime', 'updater'];
      case '/roles':
        return ['id', 'name', 'creationTime', 'creator', 'updateTime', 'updater'];
      default:
        return '';
    }
  }

  function getTableColumnsAsJSON(headers, columns) {
    var jsonObj = [];

    for (var i = 0; i < headers.length; i++) {
      var item = {};
      item['title'] = headers[i];
      item['data'] = columns[i];
      jsonObj.push(item);
    }

    return jsonObj;
  }

  function renewTableFor(mapping) {
    var data = getDataFrom(mapping);
    var columnHeaders = getTableColumnsHeadersFor(mapping);
    var columnDefs = getTableColumnDefsFor(mapping);
    var columns = getTableColumnsAsJSON(columnHeaders, columnDefs);

    var table = TableBuilder(columns);

    var tableDiv = $('#data');
    tableDiv.empty();
    tableDiv.append(table);
    table.dataTable({
      data: data,
      columns: columns,
      destroy: true
    });
  }

  function createButtonClickedHandler() {
    var $createForms = $('#create_forms'),
      currentEntity = $('.menu').find('li.active');
    $createForms.find('#' + currentEntity.data('form')).modal('show');
  }

  function ajaxCreationSuccessHandler(data) {
    showSuccessBlack(data + ' was created');
  }

  function submitFormButtonClicked() {
    var $createForms = $('#create_forms'),
      currentEntity = $('.menu').find('li.active'),
      form = $createForms.find('#' + currentEntity.data('form')).find('form');

    $.ajax({
      url: form.attr('action'),
      type: 'POST',
      data: form.serializeArray(),
      cache: false,
      contentType: false,
      processData: false,
      success: ajaxCreationSuccessHandler,
      error: ajaxErrorHandler
    });
  }

  function initMenu() {
    var menu = $('.menu');
    var menuItems = $(menu).find('li');
    menuItems.each(function() {
      $(this).on('click', menuItemClickedHandler);
    });
  }

  function initForms() {
    $('#create_button').on('click', createButtonClickedHandler);
    $('#create_forms').find('button[type=submit]').each(function() {
      $(this).on('click', submitFormButtonClicked);
    })
  }
});

function ajaxErrorHandler(data) {
  showErrorBlock(data.statusText);
}

function showSuccessBlock(msg) {
  var $success = $('#success');
  $success.find("span").text(msg);
  $success.show().delay(5000).fadeOut();
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

  $(headers).each(function() {
    var th = $('<th/>');
    tr.append(th);
  });

  return table;
}
