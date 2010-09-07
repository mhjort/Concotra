$(function() {
 // $.getJSON("http://localhost:8080/api",
 //   function(person) {
 //      $("#name").text(person.name);
 //	}
 // );
  $.post("http://localhost:8080/api", { "salary": $("#salary").text },
    function(person) {
      //$("#salary").text(person.salary);
      $("#status").text("Tallennettu");
    }, 
    "json");
});
