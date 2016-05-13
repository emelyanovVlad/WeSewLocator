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
        return ['ID', 'Full Name', 'Email', 'Birth date', 'Role', 'Last login', 'Created', 'Created by ', 'Updated', 'Updated by'];
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
        return ['id', 'fullName', 'email', 'birthDate', 'role', 'lastLogin', 'creationTime', 'creator', 'updateTime', 'updater'];
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

    var table = TableBuilder(data, columns);
  }

  function addOptionTo(select, value, text) {
        var option = $('<option/>');
        $(option).attr('value', value).text(text);
        select.append(option);
  }

  function initFormSelects(form, mapping) {
    switch (mapping) {
        case '/users':
            var roleSelect = $(form).find('select'),
                dataUrl = roleSelect.data('target'),
                data = getDataFrom(dataUrl);

            $(data).each(function() {
                addOptionTo(roleSelect, this.name, this.name);
            });
            return;
        default:
            return;
    }
  }

  function createButtonClickedHandler() {
    var $createForms = $('#create_forms'),
      currentEntity = $('.menu').find('li.active');
    var chosenForm = $createForms.find('#' + currentEntity.data('form'));
    chosenForm.modal('show');
    initFormSelects(chosenForm, currentEntity.data('target'));
  }

  function ajaxCreationSuccessHandler(data) {
    showSuccessBlock(data + ' was created');
  }

  function submitFormButtonClickedHandler() {
    var $createForms = $('#create_forms'),
      currentEntity = $('.menu').find('li.active'),
      form = $createForms.find('#' + currentEntity.data('form')).find('form');

    $.ajax({
      url: form.data('target'),
      type: 'POST',
      data: serializeForm(form),
      cache: false,
      contentType: 'application/json',
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
      $(this).on('click', submitFormButtonClickedHandler);
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

function TableBuilder(data, columns) {
  var table = $('<table/>').addClass('table table-striped table-hover table-bordered'),
    thead = $('<thead/>'),
    tr = $('<tr/>');
  table.append(thead);
  thead.append(tr);

  $(columns).each(function() {
    var th = $('<th/>');
    tr.append(th);
  });

  var tableDiv = $('#data');
      tableDiv.empty();
      tableDiv.append(table);
      table.dataTable({
        data: data,
        columns: columns,
        destroy: true
      });

  return table;
}

function serializeForm(form) {
    var objectGraph = {};
    function add(objectGraph, name, value) {
     if(name.length == 1) {
      objectGraph[name[0]] = value;
     }
     else {
      if(objectGraph[name[0]] == null) {
       objectGraph[name[0]] = {};
      }
      add(objectGraph[name[0]], name.slice(1), value);
     }
    };

    $(form).find('input').each(function() {
      add(objectGraph, $(this).attr('name').split('.'), $(this).val());
    });
    return JSON.stringify(objectGraph);
   };
