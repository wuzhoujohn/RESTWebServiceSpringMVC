<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${headermessage}</h1>
	<h3>Congratulations!!! The form has been submitted successfully. The information is showing below</h3>
	<h4>Details About You:</h4>
	<table>
		<tr>
			<td>Student Name:</td>
			<td>${student1.studentName}</td>
		</tr>
		<tr>
			<td>Student Hobby:</td>
			<td>${student1.studentHobby}</td>
		</tr>
		<tr>
			<td>Student Mobile:</td>
			<td>${student1.studentMobile}</td>
		</tr>
		<tr>
			<td>Student Date of Birth:</td>
			<td>${student1.studentDOB}</td>
		</tr>
		<tr>
			<td>Student Skills:</td>
			<td>${student1.studentSkills}</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
				Country: ${student1.studentAddress.country}
				City: ${student1.studentAddress.city}
				Province: ${student1.studentAddress.province}
				Street: ${student1.studentAddress.street}
				Postal Code: ${student1.studentAddress.postCode}
			</td>
		</tr>
	</table>
</body>
</html>