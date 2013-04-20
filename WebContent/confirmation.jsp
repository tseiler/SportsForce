<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Player Registration Confirmation</title>
</head>
<body>

<h1>Player Registration Confirmation Page</h1>
Player:  
<%= request.getAttribute("pfirstName") %>
<%= request.getAttribute("middleName") %>
<%= request.getAttribute("plastName") %>
<br>
Primary Position:  <%= request.getAttribute("priPos") %> <br>
Secondary Position:  <%= request.getAttribute("secPos") %> <br>
Number of seasons played:  <%= request.getAttribute("seasons") %> <br>
Pitcher Experience:  <%= request.getAttribute("pitcherExp") %> <br>
Catcher Experience:  <%= request.getAttribute("catcherExp") %> <br>
</body>
</html>