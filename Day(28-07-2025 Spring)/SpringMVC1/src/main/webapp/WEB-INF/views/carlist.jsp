<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Brand List</title>
    <style>
        body {
            font-family: sans-serif;
            background-color: #f9f9f9;
            padding: 20px;
        }
        h1 {
            color: #444;
        }
        .car-item {
            padding: 5px;
            margin-bottom: 4px;
            background-color: #eaeaea;
            width: fit-content;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <h1>Car Brand List</h1>
    <c:forEach var="car" items="${carlist}">
        <div class="car-item">${car}</div>
    </c:forEach>
</body>
</html>
