$(document).ready(function () {

    $('button.delete').on("click", function(){
        var id = $(this).parents(".doc").attr("data-id");
        $.ajax({
            type: "DELETE",
            url: "/documents?id=" + id,
            success: function () {
            },
            failure: function () {
            }
        })
    })

    $('button.edit').on("click", function(){
        var parent = $(this).parents(".doc");
        var id = parent.attr("data-id");
        var name =  parent.find(".name span").text();
        parent.find(".name").html("<input class='mb-2 new_name' type='text' value='" + name + "'><br><input class='save' type='submit' class='button' value='save'>")

        $(".save").on("click", function(){
            var new_name = $(this).siblings(".new_name").val();
            $.ajax({
                type: "PUT",
                url: "/documents?id=" + id + "&name=" + new_name,
                success: function () {
                },
                failure: function () {
                }
            })
            parent.find(".name").html("<span>"+ new_name +"</span>");
        });
    })
});