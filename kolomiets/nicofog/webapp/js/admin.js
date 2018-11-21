/**
 * Created by mihail on 11/20/18.
 */
function userDelete(id, userName) {

    $(document).ready(function () {

        $.ajax({
            url: "/user-delete/" + id,
            type: 'DELETE',
            success: function () {
                $("#result").text("User " + userName + " deleted");
                $("#user-" + id).hide(3000)
            }
        });
    });
}

$(document).ready(function () {
    $("#confirm_edit").click(function () {

        var paramethers = 'id=' + $("#user_id").val() +
            '&userName=' + $("#user_name").val() +
            '&role=' + $("#role").val() +
            '&price=' + $("#price").val();
        $.ajax({
            url: '/user-edit?' + paramethers,
            type: 'PUT',
            success: function () {
                window.location.replace("/admin-page.jsp");
            }
        })
    });
});