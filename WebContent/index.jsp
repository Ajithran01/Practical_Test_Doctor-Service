<%@ page import="model.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%
   String stsMsg = ""; 
  //Insert Doctor---------------------------------
    if (request.getParameter("hidItemIDUpdate") != null)
     {
     Doctor d1 = new Doctor();
      stsMsg = d1.insertDoctor(request.getParameter("dID"),
     request.getParameter("dName"),
     request.getParameter("specialization"),
     request.getParameter("hName"));
     session.setAttribute("statusMsg", stsMsg);
     } 
    else//Update----------------------
    {
    	 Doctor d1 = new Doctor();
    stsMsg = d1.updateDoctor(request.getParameter("dID"),
    request.getParameter("dID"),
    request.getParameter("dName"),
    request.getParameter("specialization"),
    request.getParameter("hName"));
    }
    session.setAttribute("statusMsg", stsMsg); 
   %> 
      <%  
      //Delete Doctor---------------------------------
   if (request.getParameter("dID") != null)
   {
	   Doctor d1 = new Doctor();
    stsMsg = d1.deleteDoctor(request.getParameter("dID"));
   session.setAttribute("statusMsg", stsMsg);
   } 
      %> 

       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Style.css">
<title>Doctor Management</title>
</head>
<body>
<h1>Add new Doctors</h1>
<div class="form-style-8">
<form method="post"  action="index.jsp">
 Doctor ID: <input name="dID" id="dID" type="text" ><br>
 Doctor name: <input name="dName" id="dName" type="text" ><br>
Doctor specialization : <input name="specialization" id="specialization" type="text" ><br>
Doctor residing Hospital: <input name="hName" id="hName" type="text" ><br>
 <input id="btnSave" name="btnSubmit" type="button" value="Save">
 <input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
 <input type="reset" value="Reset" />
</form>
</div>
<br>
<a href="http://localhost:8080/DoctorService/rest/rest">View Doctors</a>
<%
 out.print(session.getAttribute("statusMsg"));
%>
<br>
<%
//Doctor itemObj = new Doctor();
//System.out.print(itemObj.readItems());
//System.out.println(itemObj.readItems());
//itemObj.readItems();
%>

</body>
</html>