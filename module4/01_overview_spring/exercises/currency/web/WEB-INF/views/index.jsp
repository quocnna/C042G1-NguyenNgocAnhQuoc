
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert" method="post">
    <div>USD: <input name="usd" value="${usd}"></div>
    <div>Rate: 1 USD/ 23000 VND</div>
    <div>Result: <label style="color: blue">${res}</label></div>
    <button>Convert</button>
</form>
</body>
</html>
