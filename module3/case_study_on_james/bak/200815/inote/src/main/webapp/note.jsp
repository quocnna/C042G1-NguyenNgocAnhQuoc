<%@ page import="common.Paging" %>
<%@ page import="java.util.stream.IntStream" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>iNote</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/toastr.css">
    <link rel="stylesheet" href="assets/css/style.css">
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">--%>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="assets/js/toastr.min.js"></script>
    <script src="assets/js/main.js"></script>
</head>

<body>
<c:if test="${toastr!=null}">
    <script>
        $.fn.toastr("${toastr.type}", "${toastr.msg}");
    </script>
</c:if>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-3">
                    <h2>Manage <b>Notes</b></h2>
                </div>
                <div class="col-md-5">
                    <form action="/note?action=search" method="post">
                        <div class="input-group">
                            <div class="input-group-btn search-panel">
                                <button type="button" class="tmp btn btn-default dropdown-toggle"
                                        data-toggle="dropdown">
                                    <span id="search_concept" class="tmp">All</span> <span class="tmp caret"></span>
                                </button>
                                <ul class="dropdown-menu scrollable-dropdown" role="menu">
                                    <li><a href="#">Title</a></li>
                                    <li><a href="#">Content</a></li>
                                    <li><a href="#">Note Type</a></li>
                                </ul>
                            </div>
                            <input type="hidden" name="by" value="all" id="search_param">
                            <input type="text" class="form-control" name="val" placeholder="Search">
                            <span class="input-group-btn">
	     <button type="submit" class="tmp btn btn-default" style="height: 34px" type="button">
	       <span class="glyphicon glyphicon-search"></span>
	     </button>
	 </span>
                        </div>
                    </form>
                </div>
                <div class="col-sm-4">
                    <a href="#addEditModal" class="btn btn-success add" data-toggle="modal"><i
                            class="material-icons">&#xE147;</i>
                        <span>Add New Note</span></a>
                    <a href="#deleteModal" class="btn btn-danger delAll" data-toggle="modal"><i
                            class="material-icons">&#xE15C;</i>
                        <span>Delete</span></a>
                </div>

            </div>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
                </th>
                <th>Title</th>
                <th>Content</th>
                <th>Note Type</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${notes}">
                <tr>
                    <td>
							<span class="custom-checkbox">
								<input type="checkbox" id="cb" value="${item.id}">
								<label for="cb"></label>
							</span>
                    </td>
                    <td>${item.title}</td>
                    <td>${item.content}</td>
                    <td>${item.note_type_name}</td>
                    <td>
                        <a href="#addEditModal" class="edit" data-toggle="modal" data-id="${item.id}"
                           data-title="${item.title}"
                           data-content="${item.content}" data-note_type_id="${item.note_type_id}"
                           data-note_type_name="${item.note_type_name}"><i class="material-icons" data-toggle="tooltip"
                                                                           title="Edit">&#xE254;</i></a>
                        <a data-id="${item.id}" href="#deleteModal" class="delete" data-toggle="modal"><i
                                class="material-icons"
                                data-toggle="tooltip"
                                title="Delete">&#xE872;</i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="clearfix">
            <div class="hint-text">Showing
                <b>${paging.totalItemsPage}</b> out of <b>${paging.totalItems}</b> entries
            </div>

            <ul class="pagination">
                <c:choose>
                    <c:when test="${paging.currentPage>1}">
                        <li class="page-item">
                            <a class="page-link"
                               href="?page=${paging.currentPage - 1}&by=${paging.searchBy}&val=${paging.searchVal}&sortField=${paging.sortField}&sortDir=${paging.sortDir}">Previous</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item disabled">
                            <a href="#">Previous</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <% Paging p = (Paging) request.getAttribute("paging");%>
                <c:set var="t"
                       value="<%= IntStream.rangeClosed(1, p.getTotalPages()).boxed().collect(Collectors.toList()) %>"></c:set>
                <c:forEach var="i" items="${t}">
                    <c:choose>
                        <c:when test="${i==paging.currentPage}">
                            <li class="page-item active">
                                <a class="page-link"
                                   href="?page=${i}&by=${paging.searchBy}&val=${paging.searchVal}&sortField=${paging.sortField}&sortDir=${paging.sortDir}">${i}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link"
                                   href="?page=${i}&by=${paging.searchBy}&val=${paging.searchVal}&sortField=${paging.sortField}&sortDir=${paging.sortDir}">${i}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>

                <c:choose>
                    <c:when test="${paging.currentPage <paging.totalPages}">
                        <li class="page-item">
                            <a class="page-link"
                               href="?page=${paging.currentPage + 1}&by=${paging.searchBy}&val=${paging.searchVal}&sortField=${paging.sortField}&sortDir=${paging.sortDir}">Next</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item disabled">
                            <a href="#">Next</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</div>

<div id="addEditModal" class="modal fade">
    <div class="modal-dialog">
        <form method="post" action="/note">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title"></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <input name="id" type="hidden">
                    <div class="form-group">
                        <label>Title</label>
                        <input name="title" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Content</label>
                        <input name="content" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Note Type:</label>
                        <select name="notetype" class="form-control">
                            <c:forEach var="item" items="${notetypes}">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
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
        <form method="post" action="/note?action=delete">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Note</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these records?</p>
                    <p class="text-warning">
                        <small>These action cannot be undone.</small>
                    </p>
                </div>
                <div class="modal-footer">
                    <input type="hidden" name="id" id="hfDel">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    $(".edit").click(function () {
        $(".modal-title").text("Edit Note");
        $("input[name='id']").val($(this).data("id"));
        $("input[name='title']").val($(this).data("title"));
        $("input[name='content']").val($(this).data("content"));
        var nti = $(this).data("note_type_id");
        $("select[name='notetype'] option").each(function () {
            if (this.value == nti) {
                $(this).prop("selected", true)
                return false;
            }
        });
    });

    $(".add").click(function () {
        $(".modal-title").text("Add Note");
        $("input[name='id'],input[name='title'],input[name='content']").val("");
    });
</script>
</body>

</html>
