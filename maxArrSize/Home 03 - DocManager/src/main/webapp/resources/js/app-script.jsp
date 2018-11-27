$(document).ready(function() {

    $(".btn-delete").click(function() {
        var url = $(this).attr( "href");
        $.ajax({
            url: url,
            type: 'DELETE',
            success: function() {
            $(location).attr('href','/documents');
            }
        });
    });
});
