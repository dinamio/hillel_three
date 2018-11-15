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

    $(".btn-update").click(function() {
        $("#document").hide();
        $("#back").hide();
        $("#document-update").removeClass("invisible");
        $("#document-update").addClass("visible");

        $("#submit").click(function() {
            $.ajax({
                url: $("#form-update").attr("action") + "/?title=" + $('#title').val().trim(),
                type: "PUT",
                success: function() {
                $(location).attr('href', $("#form-update").attr("action"));
                }
            });
        });
    });

});