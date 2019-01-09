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
    $("#logout").click(function () {
        $.ajax({
            url: '/logout',
            type: 'POST'
        })
    });

    var time = $("#time");
    var lastSmoke = new Date(time.text());
    setInterval(function () {


        var between = new Date() - lastSmoke;
        var days = Math.floor(between / (1000 * 60 * 60 * 24));
        var hours = Math.floor((between % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        var minutes = Math.floor((between % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((between % (1000 * 60)) / 1000);
        var out;

        if (days != 0) {
            out = days + " d " + hours + " h";
        } else if (hours != 0) {
            out = hours + " h " + minutes + " m"
        } else {
            out = minutes + " m " + seconds + " s"
        }

        time.text("Last time for smoke: " + out)
    }, 1000);

});
