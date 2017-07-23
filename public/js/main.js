$(document).ready(function () {

  $('#search').bind("click", function (e) {
    e.preventDefault();

    $.ajax({
      url: '/download',
      type: 'POST',
      cache: false,
      data: {
        appName: $('#app-name').val(),
        packageName: $('#package-name').val(),
        templateName: $('#template-name').val(),
      },
      success: function (data) {
        $("#rules").text(data[0].rules);
      },
      error: function (jqXHR, textStatus, err) {
        console.log('text status ' + textStatus + ', err ' + err)
      }
    });
  });

});