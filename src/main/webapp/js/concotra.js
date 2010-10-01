$(function() {
  $('#submit').click(function() {
    $.post("http://localhost:8080/api", { "salary": $("#salary").val(), "firstEmploymentStartDate": $("#firstEmploymentStartDate").val() },
      function(application) {
        if (application.status == '1') {
          $("#status").html('<span class="success">Tallennettu <span id="savedApplicationId">' + application.id + '</span></span>');
	} else {
	  $("#status").html('<span class="error">Virheellinen päivämäärä</span>');
	}
      }, "json");
    return false;
  });
});
