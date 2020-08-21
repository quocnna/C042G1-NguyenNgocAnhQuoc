<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple calculator</title>
    <style>
      div{
        margin-top: 10px;
      }
      label{
        display: inline-block;
        width: 150px;
      }
    </style>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form action="/calculator" method="post">
  <fieldset>
    <legend>
      Calculator
    </legend>
    <div><label>First operand:</label> <input name="fOperand" /></div>
    <div><label>Operator:</label> <select name="operator">
    <option>Addition</option>
    <option>Subtraction</option>
    <option>Multiplication</option>
    <option>Division</option>
  </select></div>
    <div><label>Second operand:</label> <input name="sOperand" /></div>
    <div><button>Calculator</button></div>
  </fieldset>
  </form>
  </body>
</html>
