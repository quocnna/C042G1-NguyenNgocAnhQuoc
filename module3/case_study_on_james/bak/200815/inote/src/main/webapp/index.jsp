<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/home.css">
</head>

<body>
<%
    Cookie[] cookies= request.getCookies();
    String dbUsername="";
    if(cookies!=null)
        for (Cookie cookie : cookies)
            if(cookie.getName().equals("cookuser"))
                dbUsername= cookie.getValue();
%>
<nav class="navbar navbar-expand-md">
    <a class="navbar-brand" href="#">Logo</a>
    <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#main-navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="main-navigation">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/note">Note</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/note_type">Note Type</a>
            </li>
        </ul>
    </div>
</nav>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <form action="/home" method="post"> <div class="modal-content">
            <div class="popDes">iNote is a simple and quick sticky notepad app. This helps you organize your notes, memos, messages, emails, shopping lists, check lists and to-do lists by COLOR. Taking color notes with iNote is never easier than before.</div>
            <div class="popTitle">Please choose the way you store data</div>
            <div class="popDetail">
                <div class="popDetailInline">
                    <div>Database: data wil save on your database so you have to config info your database, username and password </div>
                    <div class="select">
                        <label class="form-check-label" for="rdconfigdb">
                            database
                        </label>
                        <input class="form-check-input" type="radio" name="rdconfig" id="rdconfigdb" value="db"></div>
                </div>
                <div class="popDetailInline">
                    <div>File: data will save to file on your local computer, so you have to config your file path</div>

                    <div class="select">
                        <label class="form-check-label" for="rdconfigfile">
                            file
                        </label>
                        <input class="form-check-input" type="radio" name="rdconfig" id="rdconfigfile" value="file"></div>
                </div>
                <div class="configdb">
                    <label>db name:</label><input name="dbname" type="text"  placeholder="database name">
                    <label>username:</label><input name="dbusername" type="text" placeholder="username">
                    <label>password:</label><input name="dbpassword" type="password" placeholder="password">
                </div>
                <div class="configfile">
                    <label>files path:</label><input name="filepath" type="text" placeholder="C:\">
                </div>
            </div>
            <button class="btnDone" disabled>Done</button>
            <div class="popSub">(You can change the way store data after)</div>
        </div></form>
    </div>
</div>

<script src="http://khaalipaper.com/js/jquery-3.2.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<c:set var="t" value="<%=dbUsername%>"></c:set>
<c:choose>
    <c:when test="${t==''}">
        <script>
            $("#exampleModal").modal('show');
        </script>
    </c:when>
    <c:otherwise>
        <c:redirect url="/home"></c:redirect>
    </c:otherwise>
</c:choose>
<script>
    $('.header').height($(window).height());

    $("#rdconfigdb").click(function () {
        $(".configdb").show();
        $(".configfile").hide();
        $(".btnDone").removeAttr('disabled');;
    });

    $("#rdconfigfile").click(function () {
        $(".configfile").show();
        $(".configdb").hide();
        $(".btnDone").removeAttr('disabled');;
    });
</script>
</body>
</html>
