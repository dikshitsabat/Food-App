<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="savefoodorder" modelAttribute="foodorder">
enter name: <form:input path="name"/>
enter mobileNum : <form:input path="mobileNum"/>
<input type="submit">
</form:form>




</body>
</html>