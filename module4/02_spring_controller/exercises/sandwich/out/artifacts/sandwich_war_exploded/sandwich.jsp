<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<form action="/sandwich" method="post">
<fieldset>
    <legend>Sandwich Condiment</legend>
    <div>
        Lettuce <input type="checkbox" name="condiment" value="lettuce">
    </div>
    <div>
        Tomato <input type="checkbox" name="condiment" value="tomato">
    </div>
    <div>
        Mustard <input type="checkbox" name="condiment" value="mustard">
    </div>
    <div>
        Sprouts <input type="checkbox" name="condiment" value="sprouts">
    </div>
    <button>Click</button>
</fieldset>
</form>
<div>
    Your choices: ${res}
</div>
</body>
</html>
