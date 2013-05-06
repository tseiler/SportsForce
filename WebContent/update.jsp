<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>

<script>
<!-- Form validation code by Adrian Robinson --> 
var submitcount=0;
var emailcount = 0;
var errors = "";
var efocus = "";

function IsNumber(TestString) {
	checknum = "1234567890";

	for (i=0; i < TestString.length; i++) {
		temp = TestString.substring (i, i+1);
		if (checknum.indexOf (temp, 0) ==-1)
			return (false);
		}
	return (true);
	}


function validateForm()
{
	var x=document.forms["Reg"]["pfirstName"].value;
	if (x==null || x=="")
		{
		errors = errors + "* You must enter the Player's First Name.\n";
		
		}
	if(document.Reg.plastName.value.length == 0) {
		errors = errors + "* You must enter the Player's Last Name.\n";
		if (efocus == "") { efocus = "plastName"; }
	}
	
	if (document.Reg.gender.options.selectedIndex == 0) {
		errors = errors + "* You must select the Player's Gender.\n";
		if (efocus == "") { efocus = "gender"; }
	}
	if (document.Reg.month.options.selectedIndex==0) {
		errors = errors + "* You must select the month for the Player's Birth Date.\n";
		if (efocus == "") { efocus = "month"; }
	}
	if (document.Reg.day.options.selectedIndex==0) {
		errors = errors + "* You must select the day for the Player's Birth Date.\n";
		if (efocus == "") { efocus = "day"; }
	}
	if (document.Reg.year.options.selectedIndex==0) {
		errors = errors + "* You must select the year for the Player's Birth Date.\n";
		if (efocus == "") { efocus = "year"; }
	}
	if ((document.Reg.day.options.selectedIndex==31)&&((document.Reg.month.options.selectedIndex==2)||(document.Reg.month.options.selectedIndex==4)||(document.Reg.month.options.selectedIndex==6)||(document.Reg.month.options.selectedIndex==9)||(document.Reg.month.options.selectedIndex==11))) {
		errors = errors + "* You must select a day lower than 31.\n";
		if (efocus == "") { efocus = "day"; }
	}
	if ((document.Reg.day.options.selectedIndex==30)&&(document.Reg.month.options.selectedIndex==2)) {
		errors = errors + "* You must select a day lower than 30.\n";
		if (efocus == "") { efocus = "day"; }
	}
	var sindex = document.Reg.year.options.selectedIndex;
	var tyear = document.Reg.year.options[sindex].value % 4;
	if ((document.Reg.month.options.selectedIndex==2)&&((document.Reg.day.options.selectedIndex==29)&&(tyear > 0))) {
		errors = errors + "* You must enter a valid date of birth. Only 28 days are in February " + document.Reg.year.options[sindex].value + ".\n";
		if (efocus == "") { efocus = "day"; }
	}

	if((document.Reg.parea.value.length!=3)||(!IsNumber(document.Reg.parea.value))) {
		errors = errors + "* You must enter a valid Home Phone Number including an Area Code.\n";
		if (efocus == "") { efocus = "parea"; }
	} else if((document.Reg.pphone1.value.length!=3)||(!IsNumber(document.Reg.pphone1.value))) {
		errors = errors + "* You must enter a valid Home Phone Number including an Area Code.\n";
		if (efocus == "") { efocus = "pphone1"; }
	} else if((document.Reg.pphone2.value.length!=4)||(!IsNumber(document.Reg.pphone2.value))) {
		errors = errors + "* You must enter a valid Home Phone Number including an Area Code.\n";
		if (efocus == "") { efocus = "pphone2"; }
	}
	
	if(document.Reg.street.value.length == 0) {
		errors = errors + "* You must enter the Player's Address.\n";
		if (efocus == "") { efocus = "street"; }
	}
	if(document.Reg.city.value.length == 0) {
		errors = errors + "* You must enter the Player's City.\n";
		if (efocus == "") { efocus = "city"; }
	}
	if(document.Reg.county.options.selectedIndex == 0) {
		errors = errors + "* You must select the Player's County.\n";
		if (efocus == "") { efocus = "county"; }
	}
	if(document.Reg.state.options.selectedIndex== 0) {
		errors = errors + "* You must select the Player's State.\n";
		if (efocus == "") { efocus = "state"; }
	}
	if((document.Reg.zipCode.value.length!=5)||(!IsNumber(document.Reg.zipCode.value))) {
		errors = errors + "* You must enter a valid 5-digit Zip Code.\n";
		if (efocus == "") { efocus = "zipCode"; }
	}
	
	if(document.Reg.g1firstName.value == "") {
		errors = errors + "* You must enter the Parent/Guardian #1's First Name.\n";
		if (efocus == "") { efocus = "g1firstName"; }
	}
	if(document.Reg.g1lastName.value == "") {
		errors = errors + "* You must enter the Parent/Guardian #1's Last Name.\n";
		if (efocus == "") { efocus = "g1lastName"; }
	}
	if((document.Reg.g1area.value.length!=3)||(!IsNumber(document.Reg.g1area.value))) {
		errors = errors + "* You must enter a Home Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1area"; }
	} else if((document.Reg.g1phone1.value.length!=3)||(!IsNumber(document.Reg.g1phone1.value))) {
		errors = errors + "* You must enter a Home Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1phone1"; }
	} else if((document.Reg.g1phone2.value.length!=4)||(!IsNumber(document.Reg.g1phone2.value))) {
		errors = errors + "* You must enter a Home Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1phone2"; }
	}
	
	if ((document.Reg.g1warea.value.length>0)&&((document.Reg.g1warea.value.length!=3)||(!IsNumber(document.Reg.g1warea.value)))) {
		errors = errors + "* Please enter a valid Work Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1warea"; }
	} else if((document.Reg.g1warea.value.length==0)&&((document.Reg.g1wphone1.value.length>0)||(document.Reg.g1wphone2.length>0))){
		errors = errors + "* Please enter a valid Work Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1warea"; }
	} else if ((document.Reg.g1wphone1.value.length>0)&&((document.Reg.g1wphone1.value.length!=3)||(!IsNumber(document.Reg.g1wphone1.value)))) {
		errors = errors + "* Please enter a valid Work Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1wphone1"; }
	} else if((document.Reg.g1wphone1.value.length==0)&&((document.Reg.g1warea.value.length>0)||(document.Reg.g1wphone2.length>0))){
		errors = errors + "* Please enter a valid Work Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1wphone1"; }
	} else if ((document.Reg.g1wphone2.value.length>0)&&((document.Reg.g1wphone2.value.length!=4)||(!IsNumber(document.Reg.g1wphone2.value)))) {
		errors = errors + "* Please enter a valid valid Work Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1wphone2"; }
	} else if((document.Reg.g1wphone2.value.length==0)&&((document.Reg.g1wphone1.value.length>0)||(document.Reg.g1warea.length>0))){
		errors = errors + "* Please enter a valid Work Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1wphone2"; }
	}
	
	if ((document.Reg.g1marea.value.length>0)&&((document.Reg.g1marea.value.length!=3)||(!IsNumber(document.Reg.g1marea.value)))) {
		errors = errors + "* Please enter a valid Cell Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1marea"; }
		}
	else if((document.Reg.g1marea.value.length==0)&&((document.Reg.g1mphone1.value.length>0)||(document.Reg.g1mphone2.length>0))){
		errors = errors + "* Please enter a valid Cell Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1marea"; }
	} else if ((document.Reg.g1mphone1.value.length>0)&&((document.Reg.g1mphone1.value.length!=3)||(!IsNumber(document.Reg.g1mphone1.value)))) {
		errors = errors + "* Please enter a valid Cell Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1mphone1"; }
	} else if((document.Reg.g1mphone1.value.length==0)&&((document.Reg.g1marea.value.length>0)||(document.Reg.g1mphone2.length>0))){
		errors = errors + "* Please enter a valid Cell Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1mphone1"; }
	} else if ((document.Reg.g1mphone2.value.length>0)&&((document.Reg.g1mphone2.value.length!=4)||(!IsNumber(document.Reg.g1mphone2.value)))) {
		errors = errors + "* Please enter a valid Cell Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1mphone2"; }
	} else if((document.Reg.g1mphone2.value.length==0)&&((document.Reg.g1mphone1.value.length>0)||(document.Reg.g1marea.length>0))){
		errors = errors + "* Please enter a valid Cell Phone Number including an Area Code for Parent/Guardian #1.\n";
		if (efocus == "") { efocus = "g1mphone2"; }
	}
	
	if (document.Reg.g1role.options.selectedIndex==0) {
		errors = errors + "* You must select the Relationship of Parent/Guardian #1 to the Player.\n";
		if (efocus == "") { efocus = "g1role"; }
	}
	
	if((document.Reg.g2firstName.value.length==0)&&(document.Reg.g2lastName.value.length>0)) {
		errors = errors + "* You must enter the First Name for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2firstName"; }
	}
	if((document.Reg.g2firstName.value.length>0)&&(document.Reg.g2lastName.value.length==0)) {
		errors = errors + "* You must enter the Last Name for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2lastName"; }
	}
	if ((document.Reg.g2area.value.length>0)&&((document.Reg.g2area.value.length!=3)||(!IsNumber(document.Reg.g2area.value)))) {
		errors = errors + "* You must enter a Home Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2area"; }
	} else if((document.Reg.g2area.value.length==0)&&((document.Reg.g2phone1.value.length>0)||(document.Reg.g2phone2.length>0))){
		errors = errors + "* You must enter a Home Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2area"; }
	} else if ((document.Reg.g2phone1.value.length>0)&&((document.Reg.g2phone1.value.length!=3)||(!IsNumber(document.Reg.g2phone1.value)))) {
		errors = errors + "* You must enter a Home Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2phone1"; }
	} else if((document.Reg.g2phone1.value.length==0)&&((document.Reg.g2area.value.length>0)||(document.Reg.g2phone2.length>0))){
		errors = errors + "* You must enter a Home Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2phone1"; }
	} else if ((document.Reg.g2phone2.value.length>0)&&((document.Reg.g2phone2.value.length!=4)||(!IsNumber(document.Reg.g2phone2.value)))) {
		errors = errors + "* You must enter a valid Home Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2phone2"; }
	} else if((document.Reg.g2phone2.value.length==0)&&((document.Reg.g2phone1.value.length>0)||(document.Reg.g2area.length>0))){
		errors = errors + "* You must enter a valid Home Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2phone2"; }
	}
	if ((document.Reg.g1warea.value.length>0)&&((document.Reg.g1warea.value.length!=3)||(!IsNumber(document.Reg.g1warea.value)))) {
		errors = errors + "* You must enter a Work Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g1warea"; }
	} else if((document.Reg.g1warea.value.length==0)&&((document.Reg.g1wphone1.value.length>0)||(document.Reg.g1wphone2.length>0))){
		errors = errors + "* You must enter a Work Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g1warea"; }
	} else if ((document.Reg.g1wphone1.value.length>0)&&((document.Reg.g1wphone1.value.length!=3)||(!IsNumber(document.Reg.g1wphone1.value)))) {
		errors = errors + "* You must enter a Work Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g1wphone1"; }
	} else if((document.Reg.g1wphone1.value.length==0)&&((document.Reg.g1warea.value.length>0)||(document.Reg.g1wphone2.length>0))){
		errors = errors + "* You must enter a Work Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g1wphone1"; }
	} else if ((document.Reg.g1wphone2.value.length>0)&&((document.Reg.g1wphone2.value.length!=4)||(!IsNumber(document.Reg.g1wphone2.value)))) {
		errors = errors + "* You must enter a valid Work Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g1wphone2"; }
	} else if((document.Reg.g1wphone2.value.length==0)&&((document.Reg.g1wphone1.value.length>0)||(document.Reg.g1warea.length>0))){
		errors = errors + "* You must enter a Work Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g1wphone2"; }
	} 
	
	if ((document.Reg.g2marea.value.length>0)&&((document.Reg.g2marea.value.length!=3)||(!IsNumber(document.Reg.g2marea.value)))) {
		errors = errors + "* You must enter a Cell Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2marea"; }
	} else if((document.Reg.g2marea.value.length==0)&&((document.Reg.g2mphone1.value.length>0)||(document.Reg.g2mphone2.length>0))){
		errors = errors + "* You must enter a Cell Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2marea"; }
	} else if ((document.Reg.g2mphone1.value.length>0)&&((document.Reg.g2mphone1.value.length!=3)||(!IsNumber(document.Reg.g2mphone1.value)))) {
		errors = errors + "* You must enter a Cell Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2mphone1"; }
	} else if((document.Reg.g2mphone1.value.length==0)&&((document.Reg.g2marea.value.length>0)||(document.Reg.g2mphone2.length>0))){
		errors = errors + "* You must enter a Cell Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2mphone1"; }
	} else if ((document.Reg.g2mphone2.value.length>0)&&((document.Reg.g2mphone2.value.length!=4)||(!IsNumber(document.Reg.g2mphone2.value)))) {
		errors = errors + "* You must enter a valid Cell Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2mphone2"; }
	} else if((document.Reg.g2mphone2.value.length==0)&&((document.Reg.g2mphone1.value.length>0)||(document.Reg.g2marea.length>0))){
		errors = errors + "* You must enter a valid Cell Phone Number including an Area Code for Parent/Guardian #2.\n";
		if (efocus == "") { efocus = "g2mphone2"; }
	}

	if ((document.Reg.g2role.options.selectedIndex==0)&&(document.Reg.g2firstName.value.length>0)) {
		errors = errors + "* You must select the Relationship of Parent/Guardian #2 to the Player.\n";
		if (efocus == "") { efocus = "g2role"; }	
	}
	
	if (document.Reg.jerseySize.options.selectedIndex==0) {
		errors = errors + "* You must select a Jersey Size.\n";
		if (efocus == "") { efocus = "jerseySize"; }
	}
	
	if (document.Reg.pantSize.options.selectedIndex==0) {
		errors = errors + "* You must select a Pant Size.\n";
		if (efocus == "") { efocus = "pantSize"; }
	}
	
	if (document.Reg.socksSize.options.selectedIndex==0) {
		errors = errors + "* You must select a Sock Size.\n";
		if (efocus == "") { efocus = "socksSize"; }
	}
	
	if (document.Reg.hatSize.options.selectedIndex==0) {
		errors = errors + "* You must select a Hat Size.\n";
		if (efocus == "") { efocus = "hatSize"; }
	}

	if(!document.Reg.liability.checked) {
		errors = errors + "* You must read the Liability Waiver and check the box.\n";
		if (efocus == "") { efocus = "liability"; }
	}
	if(!document.Reg.refundPolicy.checked) {
		errors = errors + "* You must read the Refund Policy and check the box.\n";
		if (efocus == "") { efocus = "refundPolicy"; }
	}
	if(!document.Reg.codeConduct.checked) {
		errors = errors + "* You must read the Code of Conduct Policy and check the box.\n";
		if (efocus == "") { efocus = "codeConduct"; }
	}
	if(!document.Reg.byLaws.checked) {
		errors = errors + "* You must read the By-Laws disclosure and check the box.\n";
		if (efocus == "") { efocus = "byLaws"; }
	}
	if(!document.Reg.photo.checked) {
		errors = errors + "* You must read the Photo Waiver disclosure and check the box.\n";
		if (efocus == "") { efocus = "photo"; }
	}
	
	if (errors.length > 0)
		{
		var msg = "___________________________________________________________________________\n\nThe form was not submitted because of the following error(s).\nPlease correct these error(s) and re-submit.\n___________________________________________________________________________\n\n";
		msg = msg + errors;
		alert(msg);
		msg = "";
		errors = "";
		return false;
		}
	else
		{
			return;
		}
	}
</script>

<title>Update Player Registration</title>
<STYLE TYPE="text/css">
BODY  {
	color: black;
	font-family: Verdana,Tahoma, "MS Trebuchet", Arial, Helvetica, Geneva, sans-serif;
	font-size: 12px;
}
INPUT {
	font-family: Verdana,Tahoma, "MS Trebuchet", Arial, Helvetica, Geneva, sans-serif;
	font-size: 11px;
}
SELECT {
	font-family: Verdana,Tahoma, "MS Trebuchet", Arial, Helvetica, Geneva, sans-serif;
	font-size: 11px;
}
TEXTAREA {
	font-family: Verdana,Tahoma, "MS Trebuchet", Arial, Helvetica, Geneva, sans-serif;
	font-size: 11px;
}
FONT {
	font-family: Verdana,Tahoma, "MS Trebuchet", Arial, Helvetica, Geneva, sans-serif;
}
.tdcell {
	font-family: Verdana,Tahoma, "MS Trebuchet", Arial, Helvetica, Geneva, sans-serif;
	font-size: 13px;
}
.tdcell1 {
	font-family: Verdana,Tahoma, "MS Trebuchet", Arial, Helvetica, Geneva, sans-serif;
	font-size: 11px;
}
</STYLE>
</head>
<BODY BGCOLOR=#FFFFFF topmargin=0 marginheight=0 marginwidth=0 leftmargin=0>
<TABLE WIDTH=100% HEIGHT=100% CELLSPACING=0>
<TR><TD WIDTH=* BGCOLOR=0000CC></TD>

<TD WIDTH=18 BACKGROUND=https://www.youthleaguesusa.com/pryaa/2013/pics/left.gif></TD>
<TD WIDTH=780 BACKGROUND=https://www.youthleaguesusa.com/pryaa/2013/pics/sport.jpg valign=top CLASS=tdcell>

<CENTER>
<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0><TR><TD CLASS=tdcell><IMG SRC=https://www.youthleaguesusa.com/pryaa/2013/pics/logo.gif></TD><TD CLASS=tdcell width=20></TD><TD align=center CLASS=tdcell><TABLE BORDER=2 CELLSPACING=0 CELLPADDING=15><TR><TD align=center CLASS=tdcell bgcolor=0000CC><B><FONT SIZE=6 COLOR=FFFFFF>Player Registration</FONT></B></TD></TR></TABLE></TD></TR></TABLE>
<P>
<FONT COLOR=DD0000>* <B>denotes required field</B></FONT>

<CENTER>
<B><FONT COLOR=0000CC SIZE=4>Please scroll down to begin viewing the Player Application.</FONT></B>
<TABLE WIDTH=500><TR><TD CLASS=tdcell ALIGN=CENTER>
<TABLE BORDER=1 CELLSPACING=0>
<TR><TD BGCOLOR=000000 align=center CLASS=tdcell><FONT COLOR=FFFFFF><B>AGE GROUP</B></FONT></TD><TD BGCOLOR=000000 align=center CLASS=tdcell><FONT COLOR=FFFFFF><B>BORN BETWEEN</B></FONT></TD><TD BGCOLOR=000000 align=center CLASS=tdcell><FONT COLOR=FFFFFF><B>FEES</B></FONT></TD></TR>
<TR><TD CLASS=tdcell nowrap>Tball 5 & 6 year olds</TD><TD CLASS=tdcell>05/01/2006 and 04/30/2008</TD><TD CLASS=tdcell>$185.00</TD></TR>
<TR><TD CLASS=tdcell nowrap>PeeWee 7 & 8 year olds</TD><TD CLASS=tdcell>05/01/2004 and 04/30/2006</TD><TD CLASS=tdcell>$185.00</TD></TR>
<TR><TD CLASS=tdcell nowrap>Minor 9 & 10 year olds</TD><TD CLASS=tdcell>05/01/2002 and 04/30/2004</TD><TD CLASS=tdcell>$185.00</TD></TR>
<TR><TD CLASS=tdcell nowrap>Major 11 & 12 year olds</TD><TD CLASS=tdcell>05/01/2000 and 04/30/2002</TD><TD CLASS=tdcell>$185.00</TD></TR>
<TR><TD CLASS=tdcell nowrap>Pony 13 & 14 year olds</TD><TD CLASS=tdcell>05/01/1998 and 04/30/2000</TD><TD CLASS=tdcell>$185.00</TD></TR>
<TR><TD CLASS=tdcell nowrap>Seniors 15 thru 18 year olds</TD><TD CLASS=tdcell>Please contact www.Duluthyouth.com for 15-18 year old baseball</TD><TD CLASS=tdcell>$185.00</TD></TR>
<TR><TD CLASS=tdcell COLSPAN=3>$25 late fee will be charged if registered after 01/28/2013.</TD></TR>
</TABLE></TD></TR></TABLE><P>
</CENTER>

<P><BR>
</CENTER>

<form method="post" action="RegistrationController" name="Reg" onsubmit="return validateForm()">

<BLOCKQUOTE>
<FONT SIZE=5 COLOR="0000CC"><B>I. PLAYER INFORMATION:</B></FONT>
<P>
<TABLE WIDTH=600>
<TR><TD ALIGN=RIGHT valign=top CLASS=tdcell width=300><FONT COLOR=DD0000>*</FONT><B>First Name<BR>(EXACTLY AS SHOWN ON BIRTH CERTIFICATE): </B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=text NAME=pfirstName SIZE=20 MAXLENGTH=30 VALUE="<%= request.getAttribute("pfirstName") %>"></TD></TR>
<TR><TD ALIGN=RIGHT valign=top CLASS=tdcell width=300><B>Middle Name<BR>(EXACTLY AS SHOWN ON BIRTH CERTIFICATE): </B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=text NAME=middleName SIZE=20 MAXLENGTH=30 VALUE="<%= request.getAttribute("middleName") %>"></TD></TR>
<TR><TD ALIGN=RIGHT valign=top CLASS=tdcell width=300><FONT COLOR=DD0000>*</FONT><B>Last Name<BR>(EXACTLY AS SHOWN ON BIRTH CERTIFICATE): </B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=text NAME=plastName SIZE=20 MAXLENGTH=30 VALUE="<%= request.getAttribute("plastName") %>"></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><B>Suffix: </B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=text NAME=suffix SIZE=20 MAXLENGTH=30 VALUE="<%= request.getAttribute("suffix") %>"></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><B>Nickname: </B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=text NAME=nickName SIZE=20 MAXLENGTH=30 VALUE="<%= request.getAttribute("nickName") %>"></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Gender: </B></TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=gender VALUE="<%= request.getAttribute("gender") %>">
<OPTION VALUE="CHOOSE">-CHOOSE-
<OPTION VALUE="Male">Male
<OPTION VALUE="Female">Female
</SELECT></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Birth Date (mm/dd/yyyy): </B></TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=month>
<OPTION VALUE="0">
<OPTION VALUE="01">01
<OPTION VALUE="02">02
<OPTION VALUE="03">03
<OPTION VALUE="04">04
<OPTION VALUE="05">05
<OPTION VALUE="06">06
<OPTION VALUE="07">07
<OPTION VALUE="08">08
<OPTION VALUE="09">09
<OPTION VALUE="10">10
<OPTION VALUE="11">11
<OPTION VALUE="12">12
</SELECT> / 
<SELECT NAME=day>
<OPTION VALUE="0">
<OPTION VALUE="01">01
<OPTION VALUE="02">02
<OPTION VALUE="03">03
<OPTION VALUE="04">04
<OPTION VALUE="05">05
<OPTION VALUE="06">06
<OPTION VALUE="07">07
<OPTION VALUE="08">08
<OPTION VALUE="09">09
<OPTION VALUE="10">10
<OPTION VALUE="11">11
<OPTION VALUE="12">12
<OPTION VALUE="13">13
<OPTION VALUE="14">14
<OPTION VALUE="15">15
<OPTION VALUE="16">16
<OPTION VALUE="17">17
<OPTION VALUE="18">18
<OPTION VALUE="19">19
<OPTION VALUE="20">20
<OPTION VALUE="21">21
<OPTION VALUE="22">22
<OPTION VALUE="23">23
<OPTION VALUE="24">24
<OPTION VALUE="25">25
<OPTION VALUE="26">26
<OPTION VALUE="27">27
<OPTION VALUE="28">28
<OPTION VALUE="29">29
<OPTION VALUE="30">30
<OPTION VALUE="31">31
</SELECT> / <SELECT NAME=year>
<OPTION VALUE="0">
<OPTION VALUE="1992">1992
<OPTION VALUE="1993">1993
<OPTION VALUE="1994">1994
<OPTION VALUE="1995">1995
<OPTION VALUE="1996">1996
<OPTION VALUE="1997">1997
<OPTION VALUE="1998">1998
<OPTION VALUE="1999">1999
<OPTION VALUE="2000">2000
<OPTION VALUE="2001">2001
<OPTION VALUE="2002">2002
<OPTION VALUE="2003">2003
<OPTION VALUE="2004">2004
<OPTION VALUE="2005">2005
<OPTION VALUE="2006">2006
<OPTION VALUE="2007">2007
<OPTION VALUE="2008">2008
<OPTION VALUE="2009">2009
<OPTION VALUE="2010">2010
</SELECT></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Home Phone: </B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=parea SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("parea");>-<INPUT TYPE=TEXT NAME=pphone1 SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("pphone1");>-<INPUT TYPE=TEXT NAME=pphone2 SIZE=4 MAXLENGTH=4 VALUE="" onkeyup=Phone("pphone2");></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Street Address: </B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME="street" SIZE=30 MAXLENGTH=30 VALUE="<%= request.getAttribute("street") %>"></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>City: </B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=city SIZE=30 MAXLENGTH=30 VALUE="<%= request.getAttribute("city") %>"></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>County: </B></TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=county VALUE="<%= request.getAttribute("county") %>">
<OPTION VALUE=CHOOSE>-CHOOSE-
<OPTION VALUE="Gwinnett">Gwinnett
<OPTION VALUE="Barrow">Barrow
<OPTION VALUE="Fulton">Fulton
<OPTION VALUE="Forsyth">Forsyth
<OPTION VALUE="Jackson">Jackson
<OPTION VALUE="Hall">Hall
<OPTION VALUE="Other">Other
</SELECT></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>State: </B></TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=state VALUE="<%= request.getAttribute("state") %>">
<OPTION VALUE=CHOOSE>-CHOOSE-
<OPTION VALUE="AL">AL
<OPTION VALUE="AK">AK
<OPTION VALUE="AZ">AZ
<OPTION VALUE="AR">AR
<OPTION VALUE="CA">CA
<OPTION VALUE="CO">CO
<OPTION VALUE="CT">CT
<OPTION VALUE="DC">DC
<OPTION VALUE="DE">DE
<OPTION VALUE="FL">FL
<OPTION VALUE="GA" SELECTED>GA
<OPTION VALUE="HI">HI
<OPTION VALUE="ID">ID
<OPTION VALUE="IL">IL
<OPTION VALUE="IN">IN
<OPTION VALUE="IA">IA
<OPTION VALUE="KS">KS
<OPTION VALUE="KY">KY
<OPTION VALUE="LA">LA
<OPTION VALUE="ME">ME
<OPTION VALUE="MD">MD
<OPTION VALUE="MA">MA
<OPTION VALUE="MI">MI
<OPTION VALUE="MN">MN
<OPTION VALUE="MS">MS
<OPTION VALUE="MO">MO
<OPTION VALUE="MT">MT
<OPTION VALUE="NE">NE
<OPTION VALUE="NV">NV
<OPTION VALUE="NH">NH
<OPTION VALUE="NJ">NJ
<OPTION VALUE="NM">NM
<OPTION VALUE="NY">NY
<OPTION VALUE="NC">NC
<OPTION VALUE="ND">ND
<OPTION VALUE="OH">OH
<OPTION VALUE="OK">OK
<OPTION VALUE="OR">OR
<OPTION VALUE="PA">PA
<OPTION VALUE="RI">RI
<OPTION VALUE="SC">SC
<OPTION VALUE="SD">SD
<OPTION VALUE="TN">TN
<OPTION VALUE="TX">TX
<OPTION VALUE="UT">UT
<OPTION VALUE="VT">VT
<OPTION VALUE="VA">VA
<OPTION VALUE="WA">WA
<OPTION VALUE="WV">WV
<OPTION VALUE="WI">WI
<OPTION VALUE="WY">WY
</SELECT></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Zip Code: </B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME="zipCode" SIZE=5 MAXLENGTH=5 VALUE="<%= request.getAttribute("zipCode") %>" onkeyup=Phone("zipCode");></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>School Player Attends: </B></TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=school>
<OPTION VALUE=CHOOSE>-CHOOSE-
<OPTION VALUE="Burnette Elementary">Burnette Elementary
<OPTION VALUE="Chattahoochee Elementary">Chattahoochee Elementary
<OPTION VALUE="Duluth Middle School">Duluth Middle School
<OPTION VALUE="Greater Atlanta Christian">Greater Atlanta Christian
<OPTION VALUE="Hull Middle School">Hull Middle School
<OPTION VALUE="Jackson Elementary">Jackson Elementary
<OPTION VALUE="Mason Elementary">Mason Elementary
<OPTION VALUE="Parsons Elementary">Parsons Elementary
<OPTION VALUE="Peachtree Ridge High School">Peachtree Ridge High School
<OPTION VALUE="Other">Other
</SELECT></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><B>if "Other", please specify: </B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME="otherSchool" SIZE=30 MAXLENGTH=30 VALUE=""></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Current Grade: </B></TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=grade>
<OPTION VALUE=CHOOSE>-CHOOSE-
<OPTION VALUE="Pre-K">Pre-K
<OPTION VALUE="K">K
<OPTION VALUE="1">1
<OPTION VALUE="2">2
<OPTION VALUE="3">3
<OPTION VALUE="4">4
<OPTION VALUE="5">5
<OPTION VALUE="6">6
<OPTION VALUE="7">7
<OPTION VALUE="8">8
<OPTION VALUE="9">9
<OPTION VALUE="10">10
<OPTION VALUE="11">11
<OPTION VALUE="12">12
</SELECT></TD></TR>
</TABLE>
<P>
<HR>
<P>
<FONT SIZE=5 COLOR=0000CC><B>II. FAMILY INFORMATION:</B></FONT>
<P>
<CENTER><I><B>Parent/Guardian #1</B></I></CENTER><P>
<TABLE WIDTH=600>
<TR><TD ALIGN=RIGHT WIDTH=300 CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>First Name:</B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=g1firstName SIZE=30 VALUE="<%= request.getAttribute("g1firstName") %>"></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Last Name: </B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=g1lastName SIZE=30 VALUE="<%= request.getAttribute("g1lastName") %>"></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Home Phone:</B> </TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=g1area SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("g1area");>-<INPUT TYPE=TEXT NAME=g1phone1 SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("g1phone1");>-<INPUT TYPE=TEXT NAME=g1phone2 SIZE=4 MAXLENGTH=4 VALUE="" onkeyup=Phone("g1phone2");></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><B>Work Phone:</B> </TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=g1warea SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("g1warea");>-<INPUT TYPE=TEXT NAME=g1wphone1 SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("g1wphone1");>-<INPUT TYPE=TEXT NAME=g1wphone2 SIZE=4 MAXLENGTH=4 VALUE="" onkeyup=Phone("g1wphone2");> &nbsp; </TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><B>Cell Phone:</B> </TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=g1marea SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("g1marea");>-<INPUT TYPE=TEXT NAME=g1mphone1 SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("g1mphone1");>-<INPUT TYPE=TEXT NAME=g1mphone2 SIZE=4 MAXLENGTH=4 VALUE="" onkeyup=Phone("g1mphone2");></TD></TR>
<TR><TD ALIGN=RIGHT WIDTH=300 CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>E-mail:</B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=g1emailAddress SIZE=30 VALUE="<%= request.getAttribute("g1emailAddress") %>"></TD></TR>
<!--
<TR><TD ALIGN=RIGHT CLASS=tdcell><B>E-mail:</B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=OPTP SIZE=30 VALUE=""></TD></TR>
//-->
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Relationship:</B> </TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=g1role VALUE="<%= request.getAttribute("g1role") %>">
<OPTION VALUE="CHOOSE">-CHOOSE-
<OPTION VALUE="Mother">Mother
<OPTION VALUE="Father">Father
<OPTION VALUE="Guardian">Guardian
</SELECT></TD></TR>
</TABLE><P>
<CENTER><I><B>Parent/Guardian #2</B></I></CENTER><P>
<TABLE WIDTH=600>
<TR><TD ALIGN=RIGHT WIDTH=300 CLASS=tdcell><B>First Name:</B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=g2firstName SIZE=30 VALUE="<%= request.getAttribute("g2firstName") %>"></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><B>Last Name: </B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=g2lastName SIZE=30 VALUE="<%= request.getAttribute("g2lastName") %>"></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><B>Home Phone:</B> </TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=g2area SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("g2area");>-<INPUT TYPE=TEXT NAME=g2phone1 SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("g2phone1");>-<INPUT TYPE=TEXT NAME=g2phone2 SIZE=4 MAXLENGTH=4 VALUE="" onkeyup=Phone("g2phone2");></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><B>Work Phone:</B> </TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=g2warea SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("g2warea");>-<INPUT TYPE=TEXT NAME=g2wphone1 SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("g2wphone1");>-<INPUT TYPE=TEXT NAME=g2wphone2 SIZE=4 MAXLENGTH=4 VALUE="" onkeyup=Phone("g2wphone2");> &nbsp; </TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><B>Cell Phone:</B> </TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=g2marea SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("g2marea");>-<INPUT TYPE=TEXT NAME=g2mphone1 SIZE=3 MAXLENGTH=3 VALUE="" onkeyup=Phone("g2mphone1");>-<INPUT TYPE=TEXT NAME=g2mphone2 SIZE=4 MAXLENGTH=4 VALUE="" onkeyup=Phone("g2mphone2");></TD></TR>
<TR><TD ALIGN=RIGHT WIDTH=300 CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>E-mail:</B></TD><TD ALIGN=LEFT CLASS=tdcell><INPUT TYPE=TEXT NAME=g2emailAddress SIZE=30 VALUE="<%= request.getAttribute("g2emailAddress") %>"></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><B>Relationship:</B> </TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=g2role VALUE="<%= request.getAttribute("g2role") %>">
<OPTION VALUE="CHOOSE">CHOOSE
<OPTION VALUE="Mother">Mother
<OPTION VALUE="Father">Father
<OPTION VALUE="Guardian">Guardian
</SELECT></TD></TR>
</TABLE>
<P>
<HR>
<P>
<FONT SIZE=5 COLOR=0000CC><B>III. BASEBALL INFORMATION:</B></FONT>
<P>
<B>Players uniforms will include Jersey, Pants, Socks, Hat and Belt. 
<BR><BR>Uniforms are sized to match typical youth and adult sizes. If you have questions regarding your child's size requirements, please visit Colters Sporting Goods.</B>
<P>
<TABLE WIDTH=600>
<TR><TD ALIGN=RIGHT width=310 CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Number of Seasons Played: </B></TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=seasons>
<OPTION VALUE="0">0
<OPTION VALUE="1">1
<OPTION VALUE="2">2
<OPTION VALUE="3">3
<OPTION VALUE="4">4
<OPTION VALUE="5">5
<OPTION VALUE="6">6
<OPTION VALUE="7">7
<OPTION VALUE="8">8
<OPTION VALUE="9">9
<OPTION VALUE="10">10
<OPTION VALUE="11">11
<OPTION VALUE="12+">12+
</SELECT></TD></TR>
<%-- Primary position --%>
<TR><TD ALIGN=RIGHT width=310 CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Primary Position: </B></TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=priPos>
<OPTION VALUE="None" SELECTED>None
<OPTION VALUE="P">P
<OPTION VALUE="C">C
<OPTION VALUE="1B">1B
<OPTION VALUE="2B">2B
<OPTION VALUE="3B">3B
<OPTION VALUE="SS">SS
<OPTION VALUE="LF">LF
<OPTION VALUE="CF">CF
<OPTION VALUE="RF">RF
</SELECT></TD></TR>
<%-- Secondary position --%>
<TR><TD ALIGN=RIGHT width=310 CLASS=tdcell><FONT COLOR=DD0000></FONT><B>Secondary Position: </B></TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=secPos>
<OPTION VALUE="None" SELECTED>None
<OPTION VALUE="P">P
<OPTION VALUE="C">C
<OPTION VALUE="1B">1B
<OPTION VALUE="2B">2B
<OPTION VALUE="3B">3B
<OPTION VALUE="SS">SS
<OPTION VALUE="LF">LF
<OPTION VALUE="CF">CF
<OPTION VALUE="RF">RF
</SELECT></TD></TR>
<%-- Additional position --%>
<TR><TD ALIGN=RIGHT width=310 CLASS=tdcell><FONT COLOR=DD0000></FONT><B>Additional Position: </B></TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=addPos>
<OPTION VALUE="None" SELECTED>None
<OPTION VALUE="P">P
<OPTION VALUE="C">C
<OPTION VALUE="1B">1B
<OPTION VALUE="2B">2B
<OPTION VALUE="3B">3B
<OPTION VALUE="SS">SS
<OPTION VALUE="LF">LF
<OPTION VALUE="CF">CF
<OPTION VALUE="RF">RF
</SELECT></TD></TR>
<%-- Pitching Experience --%>
<TR><TD ALIGN=RIGHT width=310 CLASS=tdcell><FONT COLOR=DD0000></FONT><B>Pitching Experience: </B></TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=pitcherExp>
<OPTION VALUE="false" SELECTED>No
<OPTION VALUE="true">Yes
</SELECT></TD></TR>
<%-- Catcher Experience --%>
<TR><TD ALIGN=RIGHT width=310 CLASS=tdcell><FONT COLOR=DD0000></FONT><B>Catcher Experience: </B></TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=catcherExp>
<OPTION VALUE="false" SELECTED>No
<OPTION VALUE="true">Yes
</SELECT></TD></TR>
<%-- Own Catcher's Gear --%>
<TR><TD ALIGN=RIGHT width=310 CLASS=tdcell><FONT COLOR=DD0000></FONT><B>Do you own a full set of catcher's gear?: </B></TD><TD ALIGN=LEFT CLASS=tdcell><SELECT NAME=catcherGear>
<OPTION VALUE="false" SELECTED>No
<OPTION VALUE="true">Yes
</SELECT></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Jersey Size: </B></TD><TD><SELECT NAME=jerseySize>
<OPTION VALUE="">-CHOOSE-
<OPTION VALUE="Youth Small">Youth Small (6-8)
<OPTION VALUE="Youth Medium">Youth Medium (10-12)
<OPTION VALUE="Youth Large">Youth Large (14-16)
<OPTION VALUE="Youth XL">Youth XL (18-20)
<OPTION VALUE="Adult Medium">Adult Medium (38-40 Chest)
<OPTION VALUE="Adult Large">Adult Large (42-44 Chest)
<OPTION VALUE="Adult XL">Adult XL (46 Chest)
<OPTION VALUE="Adult XXL">Adult XXL (48 Chest)
</SELECT></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Pants Size: </B></TD><TD><SELECT NAME=pantSize>
<OPTION VALUE="">-CHOOSE-
<OPTION VALUE="Youth XS">Youth X-Small (18-20 waist)
<OPTION VALUE="Youth Small">Youth Small (22-24 waist)
<OPTION VALUE="Youth Medium">Youth Medium (24-26 waist)
<OPTION VALUE="Youth Large">Youth Large (27-29 waist)
<OPTION VALUE="Youth XL">Youth X-Large (30-32 waist)
<OPTION VALUE="Adult Small">Adult Small (28-30 waist)
<OPTION VALUE="Adult Medium">Adult Medium (32-34 waist)
<OPTION VALUE="Adult Large">Adult Large (36-38 waist)
<OPTION VALUE="Adult XL">Adult X-Large (40-42 waist)
<OPTION VALUE="Adult XXL">Adult XX-Large (44-46 waist)
</SELECT></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Socks Size: </B></TD><TD><SELECT NAME=socksSize>
<OPTION VALUE="">-CHOOSE-
<OPTION VALUE="Youth">Youth
<OPTION VALUE="Adult">Adult
</SELECT></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><FONT COLOR=DD0000>*</FONT><B>Hat Size: </B></TD><TD><SELECT NAME=hatSize>
<OPTION VALUE="">-CHOOSE-
<OPTION VALUE="Youth">Youth
<OPTION VALUE="Adult">Adult
</SELECT></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><B>Jersey # First Choice: </B></TD><TD CLASS=tdcell><INPUT TYPE=TEXT NAME=jersey1 SIZE=3 MAXLENGTH=3 VALUE="<%= request.getAttribute("jersey1") %>"></TD></TR>
<TR><TD ALIGN=RIGHT CLASS=tdcell><B>Jersey # Second Choice: </B></TD><TD CLASS=tdcell><INPUT TYPE=TEXT NAME=jersey2 SIZE=3 MAXLENGTH=3 VALUE="<%= request.getAttribute("jersey2") %>"></TD></TR>
</TABLE><P>
<TABLE>
</TABLE><P>
<P>
<HR>
<P>
<A NAME="DONATION"></A>
<FONT SIZE=5 COLOR=0000CC><B>IV. DONATIONS: </B></FONT>
<P>
<FONT COLOR=0000CC><B>DONATION:</B></FONT><P>
<B>Peachtree Ridge Youth Athletic Association is a non-profit organization and we rely solely on registration fees to operate, however, we also accept donations.
<BR><BR>Donations are used to offset the expense of Risk Management Background Checks of all PRYAA Board Members, coaches and adult volunteers. This is to ensure the safety of your players. 
<BR><BR>Donations are also used to help provide scholarships to PRYAA youth, allowing all kids to participate regardless of their financial situation. We provide scholarships to those in need.
<BR><BR>Please check the following box if you wish to make a tax deductible donation to Peachtree Ridge Youth Athletic Association. This amount will be added to your total amount due at the completion of online registration. Your certificate of registration will reflect your donation and should be retained for tax purposes.</B>
<P>
<INPUT TYPE=RADIO NAME=donation VALUE=10> <B>$10.00</B> &nbsp; &nbsp; &nbsp; &nbsp;
<INPUT TYPE=RADIO NAME=donation VALUE=25> <B>$25.00</B> &nbsp; &nbsp; &nbsp; &nbsp;
<INPUT TYPE=RADIO NAME=donation VALUE=50> <B>$50.00</B> &nbsp; &nbsp; &nbsp; &nbsp;
<INPUT TYPE=RADIO NAME=donation VALUE=100> <B>$100.00</B> &nbsp; &nbsp; &nbsp; &nbsp;
<INPUT TYPE=RADIO NAME=donation VALUE=200> <B>$200.00</B> &nbsp; &nbsp; &nbsp; &nbsp;
<INPUT TYPE=RADIO NAME=donation VALUE=500> <B>$500.00</B> <P>
<INPUT TYPE=RADIO NAME=donation VALUE=other> <B>Other: </B><INPUT TYPE=TEXT NAME=dother SIZE=4><P>
<INPUT TYPE=RADIO NAME=donation VALUE=0> <B>I do not wish to donate at this time.</B><P>
<HR><P>
<FONT SIZE=5 COLOR=0000CC><B>V. IMPORTANT POLICY INFORMATION:</B></FONT>
<P>
<FONT COLOR=DD0000>*</FONT><B>By checking the boxes I agree to each of the following.</B>
<BR>
<TABLE>
<TR><TD align=center valign=top width=50 CLASS=tdcell><INPUT TYPE=CHECKBOX NAME=liability VALUE=true></TD>
<TD CLASS=tdcell><BLOCKQUOTE><B><FONT COLOR=0000CC><U>Liability Waiver:</U></FONT> I understand that PRYAA, Inc, its Officers, Coaches, Gwinnett County Parks and Recreation and its employees will not be held liable in any manner whatsoever while the above named is participating in the PRYAA sports programs.</B>
</BLOCKQUOTE></TD></TR>
<TR><TD align=center valign=top width=50 CLASS=tdcell><INPUT TYPE=CHECKBOX NAME=refundPolicy VALUE=true></TD>
<TD CLASS=tdcell><BLOCKQUOTE><B><FONT COLOR=0000CC><U>Refund Policy:</U></FONT> I understand PRYAA has adopted a NO REFUND POLICY and the decision to register my child is final.<!-- Only exceptions are a season ending injury or company transfer outside the Atlanta Metropolitan area or if a player must register prior to a middle school or high school sports team announcement AND if the registration was <U>approved</U> by the Sports Director. Refund would be pro-rated and minus incurred expenses (example: uniforms).--> Please visit our web site at <A HREF="http://www.pryaa.com" target='blank'>www.pryaa.com</A> and visit our forms page to review our refund policy in the PRYAA Bylaws.</B>
</BLOCKQUOTE></TD></TR>
<TR><TD align=center valign=top width=50 CLASS=tdcell><INPUT TYPE=CHECKBOX NAME=codeConduct VALUE=true></TD>
<TD CLASS=tdcell><BLOCKQUOTE><B><FONT COLOR=0000CC><U>Code of Conduct Policy:</U></FONT> I understand that it is strictly against the policy of PRYAA for any person, either as a participant, coach or a spectator to engage in arguments, to use abusive language, to harass or make any threatening gestures towards umpires, officials, coaches, players or league officials or to exhibit any behavior not in concert with the general intention of this park. Failure to abide by these policies will result in game suspensions and/or removal from the park. Any further incidents may result in permanent suspension from PRYAA. Any players, coaches, and parents caught fighting or found consuming any controlled substance will be suspended from league play for an amount of time to be determined by the respective Sports Board. </B>
</BLOCKQUOTE></TD></TR>
<TR><TD align=center valign=top width=50 CLASS=tdcell><INPUT TYPE=CHECKBOX NAME=byLaws VALUE=true></TD>
<TD CLASS=tdcell><BLOCKQUOTE><B>I agree to all releases and requirements as stated in the Peachtree Ridge Youth Athletic Association By-Laws which can be viewed at <A HREF="http://www.pryaa.com" target='blank'>www.pryaa.com</A>.</B>
</BLOCKQUOTE></TD></TR>
<TR><TD align=center valign=top width=50 CLASS=tdcell><INPUT TYPE=CHECKBOX NAME=photo VALUE=true></TD>
<TD CLASS=tdcell><BLOCKQUOTE><B>Photo Waiver: I hereby waive and release, and agree to indemnify, defend and hold harmless PRYAA, and any affiliated entities from and against all rights, liabilities, damages or lawsuits arising out of, in connection with, or as a result of the photograph being taken of any PRYAA registrants or members and used for publicity purposes for PRYAA. I acknowledge and understand that I have no rights of ownership to photos taken at any PRYAA sanctioned event and used by PRYAA.</B>
</BLOCKQUOTE></TD></TR>
</TABLE>
<P>
<HR>

<P>
<P><BLOCKQUOTE><CENTER>
<FONT COLOR=FF3333><B>Please review all information entered for accuracy and completeness, then click on the appropriate button below to continue the registration process.</B></FONT>
<P></CENTER></BLOCKQUOTE>
<INPUT TYPE=HIDDEN NAME=TYPE VALUE="REGULAR">
<INPUT TYPE=HIDDEN NAME=SPORT VALUE="Baseball">
<INPUT TYPE=HIDDEN NAME=PROGRAM VALUE="">
<INPUT TYPE=HIDDEN NAME=PSEASON VALUE="Spring">
<input type=hidden name=reccount value="0">
<input type=hidden name=sccount value="0">
<input type=hidden name=sncount value="">
<input type=hidden name=bbcount value="0">
<input type=hidden name=sbcount value="0">
<input type=hidden name=krcount value="0">
<input type=hidden name=fbcount value="0">
<input type=hidden name=chcount value="0">
<input type=hidden name=laxcount value="0">

</BLOCKQUOTE>

<P><BR><P>
<FONT COLOR=FF0000><B>PLEASE VISIT OUR WEBSITE AT <A HREF="http://www.pryaa.com" target='blank'>WWW.PRYAA.COM</A> FOR CONTACT INFORMATION SHOULD YOU HAVE ANY QUESTIONS ABOUT YOUR REGISTRATION.  AT THE END OF YOUR REGISTRATION PROCESS YOU WILL BE ABLE TO RETURN TO PRYAA WEB SITE FOR MORE INFORMATION.</B></FONT>
<P>
<CENTER><IMG SRC=https://www.youthleaguesusa.com/pryaa/2013/pics/ylusa.gif alt="Applications powered by GroupNet Solutions">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <A><IMG SRC=https://www.youthleaguesusa.com/pryaa/2013/pics/privacy.gif onClick=Privacy(); alt="Privacy Policy" border=0></A></CENTER>
<P>
<input type="hidden" name="registration" value="update">
<center><input type="submit" value="Submit Registration Information"></center>
</form>

</TD>
<TD WIDTH=12 BACKGROUND=https://www.youthleaguesusa.com/pryaa/2013/pics/right.gif></TD>
<TD WIDTH=* BGCOLOR=0000CC></TD>
</TR>

</TABLE>

</body>
</html>
