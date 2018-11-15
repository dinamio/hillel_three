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
        $("#document-update").removeClass("invisible");
        $("#document-update").addClass("visible");

        $("#submit").click(function() {

            $.ajax({
                url: $("#form-update").attr("action"),
                type: "PUT",
                data: {'title': + $('#title').val().trim()},
                success: function() {
                $(location).attr('href', $("#form-update").attr("action"));
                }
            });
        });

        <%--var form = $("#form-update");
        form.submit(function(e) {
            e.preventDefault();
            e.returnValue = false;
            $.ajax({
                url: form.attr("action"),
                type: "PUT",
                data: {title : "$('#title').val().trim()"},
                success: function() {
                $(location).attr('href', form.attr("action"));
                }
            });--%>





        <%--var url = $("#form-update").attr( "action");
        $("#form-update").on('submit',(function(e){
            e.preventDefault();
            $.ajax({
                url: url,
                type: "PUT",
                data:  $("#form-update").serialize(),
                success: function() {
                    $(location).attr('href', url);
                }
            });
        }));--%>
    });

});