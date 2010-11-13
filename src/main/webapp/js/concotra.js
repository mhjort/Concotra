$(function() {
  $('#submit').click(function() {
    $.post("http://localhost:8080/api", { "salary": $("#salary").val(), "firstEmploymentStartDate": $("#firstEmploymentStartDate").val(), 
	"applicationArrivalDate": $("#applicationArrivalDate").val(), "declarationMethod": $("input[name='declarationMethod']:checked").val() },
      function(response) {
        if (response.status == 'OK') {
          $("#status").html('<span class="success">Tallennettu <span id="savedApplicationId">' + response.id + '</span></span>');
	} else {
	  $("#status").html('<span class="format_error">Virheellinen päivämäärä</span>');
	}
      }, "json");
    return false;
  });
});
