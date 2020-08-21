<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>
<div>
<h2>Customer List</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Day Of Birth</th>
        <th>Address</th>
        <th>Avatar</th>
    </tr>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td>${customer.name}</td>
            <td><c:out value="${customer.dayOfBirth}"></c:out> </td>
            <td><c:out value="${customer.address}"></c:out> </td>
            <td><img src="${customer.avatar}"></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
