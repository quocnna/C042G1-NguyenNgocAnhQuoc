<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/translate" method="post">
<div>Input a english word: <input name="eng" value="${eng}"></div>
<div>Result: <label>${res}</label></div>
<button>Translate</button>
</form>
</body>
</html>
