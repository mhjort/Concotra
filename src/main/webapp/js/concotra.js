$(function() {
 // $.getJSON("http://localhost:8080/api",
 //   function(person) {
 //      $("#name").text(person.name);
 //	}
 // );
  $('#submit').click(function() {
    $.post("http://localhost:8080/api", { "salary": $("#salary").val() },
      function(application) {
        $("#status").html('Tallennettu <span id="savedApplicationId">' + application.status + '</span>');
      }, "json");
    return false;
  });
});
