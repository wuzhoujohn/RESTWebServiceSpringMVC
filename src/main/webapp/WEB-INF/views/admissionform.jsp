<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- in order to make web pages support multiple languages, it needs to do 3 things -->
	<!-- 1. include two links - English and French on top of the AdmissionForm.jsp page-->
	<!-- 2. register an interceptor with the name localeChangeInterceptor in the spring's configuration file -->
	<!-- 3. Include an entry of cookieLocaleResolver bean in the spring's configuration file -->
	<a href="/myfirstspringapp/AdmissionForm.html?siteLanguage=en">English</a>|
	<a href="/myfirstspringapp/AdmissionForm.html?siteLanguage=fr">French</a>
	<h1><spring:message code="label.headerMsg" /></h1>
	<h3><spring:message code="label.basicInfo" /></h3>
	<h4><spring:message code="label.fillingIn" /></h4>
	
	<form:errors path="student1.*" />
	
	<form action="/myfirstspringapp/submitAdmissionForm.html" method="post">
		<table>
		<tr><td><spring:message code="label.studentName" />	</td>	<td><input name="studentName" type="text"/></td>						</tr>
		<tr><td><spring:message code="label.studentHobby" />	</td>	<td><input name="studentHobby" type="text"/></td>						</tr>
		<tr><td><spring:message code="label.studentMobile" />	</td>	<td><input name="studentMobile" type="text"/></td>						</tr>
		<tr><td><spring:message code="label.studentDOB" />	</td>	<td><input name="studentDOB" type="text"/></td>							</tr>
		<tr><td><spring:message code="label.studentSkills" />	</td>	<td><select multiple name="studentSkills" >
														<option value="Java Core">Java Core</option>
														<option value="Spring Core">Spring Core</option>
														<option value="Spring MVC">Spring MVC</option>
														<option value=".NET C#">.NET C#</option>
														</select></td>						</tr>
		</table>
		
		<table>
		<tr><td><spring:message code="label.studentAddress" /></td></tr>
		<tr><td><spring:message code="label.country" /><input name="studentAddress.country" type="text" /></td></tr>
		<tr><td><spring:message code="label.province" /><input name="studentAddress.province" type="text" /></td></tr>
		<tr><td><spring:message code="label.city" /><input name="studentAddress.city" type="text" /></td></tr>
		<tr><td><spring:message code="label.street" /> <input name="studentAddress.street" type="text" /></td></tr>
		<tr><td><spring:message code="label.postalCode" /><input name="studentAddress.postCode" type="text" /></td></tr>
		</table>
		
		<input type="submit" name="submitButton" value="Click this button to submit the form" />
	</form>
</body>
</html>