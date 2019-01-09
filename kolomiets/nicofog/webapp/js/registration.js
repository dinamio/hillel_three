/**
 * Created by mihail on 11/22/18.
 */
$(document).ready(function () {
    $("#confirm").click(function () {
        var name = $("#userName").val();
        var password = $("#pass").val();
        var confirmPass = $("#cpass").val();
        var price = $("#price").val();

        var validation;

        if (name == '') {
            validation = 'What is you name?'
        } else if (password.length < 6) {
            validation = 'Password may be most of 6 symbols'
        }
        else if (password != confirmPass) {
            validation = 'You need conform correct password'
        } else if (price.match(/^[0-9]+$/) == null) {
            validation = 'Price may be digit, like 30 or 23'
        } else {
            //all ok
            var param = "?name=" + name +
                "&password=" + CryptoJS.MD5(password) +
                "&cigarettePrice=" + price;

            $.ajax({
                name: 'registration',
                url: "/user-add" + param,
                type: 'POST',
                success: function (data) {
                    if (data != 'ok') {
                        $("#regResult").text(data)
                    } else {
                        window.location.replace("/user-page.jsp");
                    }
                }
            });
        }

        $("#regResult").text(validation);

    })
});