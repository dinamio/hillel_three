/**
 * Created by mihail on 12/9/18.
 */
$(document).ready(function () {
    $("#smoke").click(function () {
        $.get("/smoke", function (data, status) {

            $("#trow").text(data);

            window.location.replace("/user-page.jsp");

        });
    });
});
