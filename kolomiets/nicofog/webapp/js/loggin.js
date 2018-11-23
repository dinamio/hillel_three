/**
 * Created by mihail on 11/15/18.
 */
$(document).ready(function () {
    $(".enter").click(function () {
        var username = $(".user").val();
        $(".view").text(username);
        $.post("/login",
            {
                username: username
            },
            function (data) {
                if (data == 'null')
                    $(".view").text('Sorry ' + username + ' not found');
                else
                    window.location.replace("/user-page.jsp");
            });
    })
});
