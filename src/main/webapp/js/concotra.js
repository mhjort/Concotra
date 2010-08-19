/*!
* Insert some cool functions
*/
$(function() {
  $.getJSON("http://localhost:8080/api",
    function(person) {
       $("#hello").text("Age " + person.age);
	}
  );
});