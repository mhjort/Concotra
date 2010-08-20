$(function() {
  $.getJSON("http://localhost:8080/api",
    function(person) {
       $("#name").text(person.name);
	}
  );
  $.post("http://localhost:8080/api", { "age": 31 },
    function(person) {
      $("#age").text(person.age);
    }, 
    "json");
});