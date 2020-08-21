<%@ page import="common.Paging" %>
<%@ page import="java.util.stream.IntStream" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/toastr.css">
    <link rel="stylesheet" href="assets/css/crud.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="assets/js/toastr.min.js"></script>
    <script src="assets/js/crud.js"></script>
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
                    <h2>Manage <b>Products</b></h2>
                </div>
                <div class="col-md-5">
                    <form action="/product?action=search" method="post">
                        <div class="input-group">
                            <div class="input-group-btn search-panel">
                                <button type="button" class="tmp btn btn-default dropdown-toggle"
                                        data-toggle="dropdown">
                                    <span id="search_concept" class="tmp">All</span> <span class="tmp caret"></span>
                                </button>
                                <ul class="dropdown-menu scrollable-dropdown" role="menu">
                                    <li><a href="#">Name</a></li>
                                    <li><a href="#">Price</a></li>
                                    <li><a href="#">Quantity</a></li>
                                    <li><a href="#">Color</a></li>
                                    <li><a href="#">Category</a></li>
                                </ul>
                            </div>
                            <input type="hidden" name="by" value="all" id="search_param">
                            <input type="text" class="form-control" name="val" placeholder="Search" value="${paging.searchVal}">
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
                        <span>Add New Product</span></a>
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
                <th><a href="?page=${paging.currentPage}&by=${paging.searchBy}&val=${paging.searchVal}&sortField=name&sortDir=${reverseSortDir}">Name</a></th>
                <th><a href="?page=${paging.currentPage}&by=${paging.searchBy}&val=${paging.searchVal}&sortField=price&sortDir=${reverseSortDir}">Price</a></th>
                <th><a href="?page=${paging.currentPage}&by=${paging.searchBy}&val=${paging.searchVal}&sortField=quantity&sortDir=${reverseSortDir}">Quantity</a></th>
                <th><a href="?page=${paging.currentPage}&by=${paging.searchBy}&val=${paging.searchVal}&sortField=color&sortDir=${reverseSortDir}">Color</a></th>
                <th><a href="?page=${paging.currentPage}&by=${paging.searchBy}&val=${paging.searchVal}&sortField=category_name&sortDir=${reverseSortDir}">Category</a></th>
                <th><a href="#">Actions</a></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${res}">
                <tr>
                    <td>
							<span class="custom-checkbox">
								<input type="checkbox" id="cb" value="${item.id}">
								<label for="cb"></label>
							</span>
                    </td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>${item.quantity}</td>
                    <td>${item.color}</td>
                    <td>${item.category_name}</td>
                    <td>
                        <a href="#viewModal" class="view" data-toggle="modal"  data-name="${item.name}" data-price="${item.price}" data-quantity="${item.quantity}" data-color="${item.color}"
                           data-category_name="${item.category_name}"><i class="material-icons">&#xE417;</i></a>

                        <a href="#addEditModal" class="edit" data-toggle="modal" data-id="${item.id}"
                           data-name="${item.name}" data-price="${item.price}" data-quantity="${item.quantity}" data-color="${item.color}"
                           data-category_id="${item.category_id}"
                           data-category_name="${item.category_name}"><i class="material-icons" data-toggle="tooltip"
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

<div id="viewModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">View Product</h5>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>Name:</label>
                    <label style="color: blue;padding-left: 5px" class="viewName">name</label>
                </div>
                <div class="form-group">
                    <label>Price:</label>
                    <label style="color: blue;padding-left: 5px" class="viewPrice">price</label>
                </div>
                <div class="form-group">
                    <label>Quantity:</label>
                    <label style="color: blue;padding-left: 5px" class="viewQuantity">quanity</label>
                </div>
                <div class="form-group">
                    <label>Color:</label>
                    <label style="color: blue;padding-left: 5px" class="viewColor">color</label>
                </div>
                <div class="form-group">
                    <label>Category:</label>
                    <label style="color: blue;padding-left: 5px" class="viewCategory">category</label>
                </div>
            </div>
            <div class="modal-footer">
                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
            </div>
        </div>
    </div>
</div>

<div id="addEditModal" class="modal fade">
    <div class="modal-dialog">
        <form id="fAddEdit" method="post" action="/product">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title"></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <input name="id" type="hidden">
                    <div class="form-group">
                        <label>Name</label>
                        <input name="name" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input name="price" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Quantity</label>
                        <input name="quantity" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Color</label>
                        <input name="color" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Category:</label>
                        <select name="category" class="form-control">
                            <c:forEach var="item" items="${cate}">
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
        <form method="post" action="/product?action=delete">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Product</h4>
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
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/css/bootstrapValidator.css"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
<script type="text/javascript">
    $(document).ready(function()
    {
        $('#fAddEdit').bootstrapValidator
        ({
            message: 'This value is not valid', fields:
                {
                    name: {
                        validators: {
                            notEmpty: {
                                message: 'The Name is required and can\'t be empty'
                            },
                            stringLength: {
                                min: 6,
                                max: 30,
                                message: 'The Name must be more than 6 and less than 30 characters long'
                            }
                        }
                    },
                    price: {
                        validators: {
                            notEmpty: {
                                message: 'The Price is required and can\'t be empty'
                            },
                            regexp: {
                                regexp: /^\d*(\.\d+)?$/,
                                message: 'The Price can only double number'
                            }
                        },
                    },
                    quantity: {
                        validators: {
                            notEmpty: {
                                message: 'The Quantity is required and can\'t be empty'
                            },
                            regexp: {
                                regexp: /^\d+$/,
                                message: 'The Quantity can only integer number'
                            }
                        },
                    },
                    color: {
                        validators: {
                            notEmpty: {
                                message: 'The Color is required and can\'t be empty'
                            }
                        }
                    },

                }
        });
    });
</script>
<script>

    $(".view").click(function () {
        $("label[class='viewName']").text($(this).data("name"));
        $("label[class='viewPrice']").text($(this).data("price"));
        $("label[class='viewQuantity']").text($(this).data("quantity"));
        $("label[class='viewColor']").text($(this).data("color"));
        $("label[class='viewCategory']").text($(this).data("category_name"));
    });

    $(".edit").click(function () {
        $(".modal-title").text("Edit Product");
        $("input[name='id']").val($(this).data("id"));
        $("input[name='name']").val($(this).data("name"));
        $("input[name='price']").val($(this).data("price"));
        $("input[name='quantity']").val($(this).data("quantity"));
        $("input[name='color']").val($(this).data("color"));
        var nti = $(this).data("category_id");
        $("select[name='category'] option").each(function () {
            if (this.value == nti) {
                $(this).prop("selected", true)
                return false;
            }
        });
    });

    $(".add").click(function () {
        $(".modal-title").text("Add Product");
        $("input[name='id'],input[name='name'],input[name='price'],input[name='quantity'],input[name='color']").val("");
    });
</script>
</body>

</html>
