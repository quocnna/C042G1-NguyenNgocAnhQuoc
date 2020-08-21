<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="main.css">
</head>
<body>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-md-6" >
                    <h2>Manage <b>Users</b></h2>
                </div>
                <div class="col-md-6">
                    <a class="btn btn-success add" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                        <span>Add New User</span></a>
                </div>
            </div>
        </div>
        <div>
            <form action="/users?action=search" method="post">
                Search By Country: <input name="search">
                <button>Search</button>
            </form>

        </div>
        <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Action</th>
            </tr>
            <c:forEach var="item" items="${userList}">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.email}</td>
                    <td>${item.country}</td>
                    <td>
                        <a href="#addEditModal" data-id="${item.id}" data-name="${item.name}" data-email="${item.email}" data-country="${item.country}"
                           class="edit" data-toggle="modal"><i id="edit1" class="material-icons"
                                                               data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                        <a data-id="${item.id}" href="#deleteModal" class="delete" data-toggle="modal"><i class="material-icons"
                                                                                                             data-toggle="tooltip"
                                                                                                             title="Delete">&#xE872;</i></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


<div id="addEditModal" class="modal fade">
    <div class="modal-dialog">
        <form method="post" action="/users">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title"></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <input name="id" type="hidden">
                    <div class="form-group">
                        <label>Name</label>
                        <input name="name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input name="email" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Country</label>
                        <input name="country" type="text" class="form-control" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-info" value="Save">
                </div>
            </div>
        </form>
    </div>
</div>
<div id="deleteModal" class="modal fade">
    <div class="modal-dialog">
        <form method="post" action="/users?action=delete">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Delete User</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete this record?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="hidden" name="id">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </div>
        </form>
    </div>
</div>

<script src="http://khaalipaper.com/js/jquery-3.2.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="main.js"></script>
</body>
</html>
