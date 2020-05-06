/**
 * 
 */
$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
 {
 $("#alertSuccess").hide();
 }
 $("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear alerts---------------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();
// Form validation-------------------
var status = validateItemForm();
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }
// If valid------------------------
 $("#formItem").submit();
});
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
 $("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());
 $("#ID").val($(this).closest("tr").find('td:eq(0)').text());
 $("#dName").val($(this).closest("tr").find('td:eq(1)').text());
 $("#specialization").val($(this).closest("tr").find('td:eq(2)').text());
 $("#hName").val($(this).closest("tr").find('td:eq(3)').text());
});
// CLIENTMODEL=========================================================================
function validateItemForm()
{
// CODE
if ($("#ID").val().trim() == "")
 {
 return "Insert Doctor ID.";
 }

if ($("#dName").val().trim() == "")
 {
 return "Insert Doctor Name.";
 } 

if ($("#specialization").val().trim() == "")
 {
 return "Insert specialization.";
 }
if ($("#hName").val().trim() == "")
{
return "Insert specialization.";
}
return true;
}

var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";

$.ajax(
		{
		 url : "DoctorAPI",
		 type : type,
		 data : $("#formItem").serialize(),
		 dataType : "text",
		 complete : function(response, status)
		 {
		 onItemSaveComplete(response.responseText, status);
		 }
		});