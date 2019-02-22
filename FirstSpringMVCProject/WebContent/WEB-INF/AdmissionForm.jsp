<!-- form is the tag name prefix which will be used for the tags from this Spring form tag library in JSP's  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<link rel="stylesheet" href="<spring:theme code="styleSheet"/>" type="text/css"/>

	<p><a href="/FirstSpringMVCProject/admissionForm.html?siteTheme=green">Green</a> | 
	<a href="/FirstSpringMVCProject/admissionForm.html?siteTheme=red">Red</a></p>

	<a href="/FirstSpringMVCProject/admissionForm.html?siteLanguage=en">English</a> |
	<a href="/FirstSpringMVCProject/admissionForm.html?siteLanguage=fr">French</a>

	<h1>${headerMessage}</h1>

	<h3><spring:message code="label.admissionForm"/><!-- STUDENT ADMISSION FORM FOR ENGINEERING COURSES --></h3>

	<form:errors path="student1.*"/>

	<form action="/FirstSpringMVCProject/submitAdmissionForm.html" method="post">
		<table>
			<tr>
				<td><spring:message code="label.studentName"/></td><!-- <td>Student's Name:</td> -->
				<td><input type="text" name="studentName" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.studentHobby"/></td><!-- <td>Student's Hobby:</td> -->
				<td><input type="text" name="studentHobby" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.studentMobile"/></td><!-- <td>Student's Mobile:</td> -->
				<td><input type="text" name="studentMobile" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.studentDOB"/></td><!-- <td>Student's Date of Birth:</td> -->
				<td><input type="text" name="studentDOB" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.studentSkills"/></td><!-- <td>Student's Skills set:</td> -->
				<td><select name="studentSkills" multiple>
						<option value="Java Core">Java Core</option>
						<option value="Spring Core">Spring Core</option>
						<option value="Spring MVC">Spring MVC</option>
				</select></td>
			</tr>
		</table>

		<table>
			<tr>
				<td><spring:message code="label.studentAddress"/> <!-- Student's Address: --></td>
			</tr>

			<tr>
				<td><!-- country: --> <spring:message code="label.country"/><input type="text" name="studentAddress.country" /></td>
				<td><!-- city: --> 	  <spring:message code="label.city"/>	<input type="text" name="studentAddress.city" /></td>
				<td><!-- street: -->  <spring:message code="label.street"/> <input type="text" name="studentAddress.street" /></td>
				<td><!-- pincode: --> <spring:message code="label.pincode"/><input type="text" name="studentAddress.pincode" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="<spring:message code="label.submit.admissionForm"/>" /></td>
			</tr>
		</table>
	</form>
</body>
</html>