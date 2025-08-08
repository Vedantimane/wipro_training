<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
</head>
<body>
    <h2>User Registration Form</h2>

    <form:form method="post" action="register" modelAttribute="user">
        <label for="username">UserName:</label>
        <form:input path="username" id="userName" /><br/><br/>

        <label for="userEmail">Email:</label>
        <form:input path="userEmail" id="userEmail" /><br/><br/>

        <label for="userPhone">Phone:</label>
        <form:input path="userPhone" id="userPhone" /><br/><br/>

        <input type="submit" value="Register"/>
    </form:form>
</body>
</html>
