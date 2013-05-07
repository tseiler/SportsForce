<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Player Registration Confirmation</title>
</head>
<body bgcolor=#FFFFFF topmargin=0 marginheight=0 marginwidth=0 leftmargin=0>
    <table width=100% height=100% cellspacing=0>
		<tr>
			<td width=* bgcolor=0000CC></td>
			<td width=18
				background=https://www.youthleaguesusa.com/pryaa/2013/pics/left.gif></td>
			<td width=780
				background=https://www.youthleaguesusa.com/pryaa/2013/pics/sport.jpg
				valign=top class=tdcell>
				<table>
					<tr>
						<td class=tdcell><img
							src=https://www.youthleaguesusa.com/pryaa/2013/pics/logo.gif></td>
						<td class=tdcell width=20></td>
						<td align=center class=tdcell>
							<table border=2 cellspacing=0 cellpadding=15>
								<tr>
									<td align=center class=tdcell bgcolor=0000CC><b><font
											size=6 color=FFFFFF>Player Registration Confirmation</font></b></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<p>
								Confirmation Number:
								<%=request.getAttribute("registrationID")%></p> Player: <%=request.getAttribute("pfirstName")%>
							<%=request.getAttribute("middleName")%> <%=request.getAttribute("plastName")%>
							<%=request.getAttribute("suffix")%> (<%=request.getAttribute("nickName")%>)
							<br> Gender: <%=request.getAttribute("gender")%><br>
							Birth Date (mm/dd/yyy): <%=request.getAttribute("birth")%><br>
							Home Phone: <%=request.getAttribute("phomePhone")%> <br>
							Street Address: <%=request.getAttribute("street")%> <br>
							City: <%=request.getAttribute("city")%> <br> County: <%=request.getAttribute("county")%>
							<br> State: <%=request.getAttribute("state")%> <br> Zip
							Code: <%=request.getAttribute("zipCode")%> <br> <br>
							Guardian #1<br> First Name: <%=request.getAttribute("g1firstName")%>
							<br> Last Name: <%=request.getAttribute("g1lastName")%> <br>
							Home Phone: <%=request.getAttribute("g1homePhone")%> <br>
							Work Phone: <%=request.getAttribute("g1workPhone")%> <br>
							Cell Phone: <%=request.getAttribute("g1mobilePhone")%> <br>
							E-mail: <%=request.getAttribute("g1emailAddress")%> <br>
							Relationship: <%=request.getAttribute("g1role")%> <br> <br>
							Guardian #2<br> First Name: <%=request.getAttribute("g2firstName")%>
							<br> Last Name: <%=request.getAttribute("g2lastName")%> <br>
							Home Phone: <%=request.getAttribute("g2homePhone")%> <br>
							Work Phone: <%=request.getAttribute("g2workPhone")%> <br>
							Cell Phone: <%=request.getAttribute("g2mobilePhone")%> <br>
							E-mail: <%=request.getAttribute("g2emailAddress")%> <br>
							Relationship: <%=request.getAttribute("g2role")%> <br> <br>
							Baseball Information<br> Number of seasons played: <%=request.getAttribute("seasons")%>
							<br> Primary Position: <%=request.getAttribute("priPos")%> <br>
							Secondary Position: <%=request.getAttribute("secPos")%> <br>
							Additional Position: <%=request.getAttribute("addPos")%> <br>
							Pitcher Experience: <%=request.getAttribute("pitcherExp")%> <br>
							Catcher Experience: <%=request.getAttribute("catcherExp")%> <br>
							Own Catcher's Gear?: <%=request.getAttribute("catcherGear")%> <br>
							Jersey Size: <%=request.getAttribute("jerseySize")%> <br>
							Pant Size: <%=request.getAttribute("pantSize")%> <br> Socks
							Size: <%=request.getAttribute("socksSize")%> <br> Hat Size:
							<%=request.getAttribute("hatSize")%> <br> Jersey # First
							Choice: <%=request.getAttribute("jersey1")%> <br> Jersey #
							Second Choice: <%=request.getAttribute("jersey2")%> <br> <br>
							Donation: <%=request.getAttribute("donation")%> <br>
						</td>
					</tr>
				</table>
			<td width=12 background=https://www.youthleaguesusa.com/pryaa/2013/pics/right.gif></td>
			<td width=* bgcolor=0000CC></td>
		</tr>
	</table>
</body>
</html>
