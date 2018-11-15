function runAlert() {
  alert ('И вот почему!');
  console.log("Мы зашли в функцию!")
}

function getList() {
  document.getElementsByTagName("ul")[1].getElementsByTagName("li")[2].innerHTML = 'Changed list';
}


$(document).ready(function () {
  $(".btn").click(function () {
    $("#place-for-text").append("<div>" + $(".my-input").val() + "</div>");
  });
  $("li").click(function () {
    $(this).hide();
  });
});
