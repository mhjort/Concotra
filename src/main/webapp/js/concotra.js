$(function() {
  $('#submit').click(function() {
    $.post("http://localhost:8080/api", { "salary": $("#salary").val(), "firstEmploymentStartDate": $("#firstEmploymentStartDate").val(), 
	"applicationArrivalDate": $("#applicationArrivalDate").val(), "declarationMethod": $("input[name='declarationMethod']:checked").val() },
      function(response) {
	switch(response.status)
	{
	case 'OK':
	  $("#status").html('<span class="success">Application has been saved. This is the reference number for the application: <span id="savedApplicationId">' + response.id + '</span></span>');
	  break;
	case 'BUSINESS_RULE_VIOLATED':
	  $("#status").html('<span class="business_rule_violated">Data is invalid</span>');
	  break;
        case 'FORMAT_ERROR':
	  $("#status").html('<span class="format_error">Data is in invalid format</span>');
	}
      }, "json");
    return false;
  });
});
