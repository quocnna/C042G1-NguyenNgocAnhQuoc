<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div>
    <form action="/converter" method="get">
      <div><h2>Currency Converter</h2></div>
      <div>
        <p>Rate:</p>
      <input type="number" name="rate" value="23000">
      </div>
      <div>
        <p>USD:</p>
        <input type="number" name="amount" value="0">
      </div>
      <div>
        <button>Converter</button>
      </div>
    </form>
  </div>
  </body>
</html>
