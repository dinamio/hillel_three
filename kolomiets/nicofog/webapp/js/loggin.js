/**
 * Created by mihail on 11/15/18.
 */
$(document).ready(function () {
    $("#enter").click(function () {
        var username = $("#user").val();
        var password = $("#password").val();
        password = CryptoJS.MD5(password);
        $("#view").text('Need start server side');

        var param = '?name=' + username +
            '&password=' + password;
        $.ajax({
            name: 'login',
            url: '/login' + param,
            type: 'POST',
            success: function (data) {
                if (data == 'ok') {
                    window.location.replace("/user-page.jsp");
                } else {
                    $("#view").text(data)
                }
            }
        });
    })
});
