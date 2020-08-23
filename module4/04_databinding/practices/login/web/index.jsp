<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <c:if test="${res==null || res.equals('fail')}">
    <form action="/login" method="post">
      <div>
        Username: <input name="username">
      </div>
      <div>
        Password <input type="password" name="password">
      </div>
      <button>Login</button>
    </form>
  </c:if>
  <c:if test="${res.equals('sucess')}">
    sucess
  </c:if>
  <c:if test="${res.equals('fail')}">
    fail
  </c:if>
  </body>
</html>
