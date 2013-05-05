<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Player Registration</title>
</head>
<body>
<form method="get" action="RegistrationController" name="Update">
<p>Please enter your registration confirmation number: <INPUT TYPE=text NAME=registrationID SIZE=10 MAXLENGTH=30 VALUE=""></p>
<input type="submit" value="Retrieve Player Registration">
</form>
<br>
Or complete a new registration <a href="registration.jsp">here</a>!


</body>
</html>