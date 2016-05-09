$(document).ready(function () {
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
            success: function (data) {
                currentData = data;
            },
            error: ajaxErrorHandler
        });
        return currentData;
    }

    function getTableColumnsFor(mapping) {
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

    function renewTableFor(mapping) {
        var data = getDataFrom(mapping);
        var columns = getTableColumnsFor(mapping);

        var table = TableBuilder(columns);

        var tableDiv = $('#data');
        tableDiv.empty();
        tableDiv.append(table);
        table.dataTable({
            data: data,
            destroy: true
        });
    }

    function createButtonClickedHandler() {
        var $createForms = $('#create_forms'),
            currentEntity = $('.menu').find('li.active');
        $createForms.find('#' + currentEntity.data('form')).modal('show');
    }

    function initMenu() {
        var menu = $('.menu');
        var menuItems = $(menu).find('li');
        menuItems.each(function () {
            $(this).on('click', menuItemClickedHandler);
        });
    }

    function initForms() {
        $('#create_button').on('click', createButtonClickedHandler);
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
