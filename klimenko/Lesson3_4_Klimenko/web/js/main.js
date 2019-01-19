$(document).ready(function () {
    $(".edit-btn").click(function () {
        debugger;
        // if ($("#edit-div").is(':visible')) {
        //     $("#edit-div").hide();
        // }
        // else {
        $("#edit-div").show();
        $("#id-for-edit").val($(this).attr("id-apart"));
        var adress = "adress"+$("#id-for-edit").val();
        $("#address").val($("#" + adress).text().trim());
        var typeEstate = "typeEstate"+$("#id-for-edit").val();
        $("#typeEstate").val($("#" + typeEstate).text().trim());
        var floor = "floor"+$("#id-for-edit").val();
        $("#floor").val($("#" + floor).text().trim());
        var countOfRoom = "countOfRoom"+$("#id-for-edit").val();
        $("#countOfRoom").val($("#" + countOfRoom).text().trim());
        var size = "size"+$("#id-for-edit").val();
        $("#size").val($("#" + size).text().trim());
        var additionalDescription = "additionalDescription"+$("#id-for-edit").val();
        $("#additionalDescription").val($("#" + additionalDescription).text().trim());
        // }
    })
});
$(document).ready(function () {
    $("#cancel-button").click(function () {
        $("#edit-div").hide();
    })
});
$(document).ready(function () {
    $("#edit-button").click(function () {
        var idApart = $("#id-for-edit").val();
        var address = $("#address").val();
        var typeEstate = $("#typeEstate").val();
        var floor = $("#floor").val();
        var countOfRoom = $("#countOfRoom").val();
        var size = $("#size").val();
        var additionalDescription = $("#additionalDescription").val();
        alert("put");
        url = "Appartments?idApart="+idApart+"&address="+address+"&typeEstate="+typeEstate+"&floor="+floor+"&countOfRoom="+countOfRoom+"&size="+size+"&additionalDescription="+additionalDescription;
        $.ajax({
            type: "PUT",
            url: url,
            success: function () {
                if ($("#edit-div").is(':visible')) {
                    $("#edit-div").hide();
                    $(location).attr('href', "Appartments");
                }
            },
            failure: function () {
            }
        })
    })
});

$(document).ready(function () {
    $(".del-btn ").click(function () {
        var idApart = $(this).attr("id-apart");
        $.ajax({
            url: 'Appartments?idApart=' + idApart,
            type: 'delete',
            success: function () {
                $(location).attr('href', "Appartments");

            }
        });
    })
});
//
// $(document).ready(function () {
//     $("#Login").click(function () {
//         var name = $("#name").val();
//         var password = $("#password").val();
//
//         $.ajax({
//             url: '/UserController?name=' + name + '&password=' + password,
//             type: 'get',
//             success: function () {
//                 $(location).attr('href', "Appartments");
//             }
//         });
//     })
// });
//
// $(document).ready(function () {
//     $("#register-btn").click(function () {
//         debugger;
//        var name = $("#name").val();
//        var email = $("#email").val();
//        var password = $("#password").val();
//
//        $.ajax({
//             url: '/UserController',
//             type: 'post',
//             data: {name : name,
//             email:email,
//             password:password},
//             success: function () {
//                 $(location).attr('href', "Appartments");
//             }
//         });
//     })
// });

$(document).ready(function () {
    $("#logout").click(function () {
        $.ajax({
            url: '/UserController',
            type: 'delete',
            success: function () {
                $(location).attr('href', "index.jsp");
            }
        });
    })
});