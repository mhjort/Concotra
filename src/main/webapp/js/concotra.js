$(function() {
  $.getJSON("http://localhost:8080/api",
    function(person) {
       $("#name").text(person.name);
	}
  );
  $.post("http://localhost:8080/api", { "salary": "9500" },
    function(person) {
      $("#salary").text(person.salary);
    }, 
    "json");
});
