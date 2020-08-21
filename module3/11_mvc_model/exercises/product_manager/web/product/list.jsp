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
                <h2>Manage <b>Products</b></h2>
            </div>
            <div class="col-md-6">
                <a class="btn btn-success add" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                    <span>Add New Employee</span></a>
            </div>
        </div>
    </div>
    <div>
        <form action="/products?action=search" method="post">
            Search By Name: <input name="search">
            <button>Search</button>
        </form>

    </div>
    <table>
        <tr>
            <th>Brand Name</th>
            <th>Category</th>
            <th>Supplier</th>
            <th>Made In</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td>${product.brandName}</td>
                <td>${product.category}</td>
                <td>${product.supplier}</td>
                <td>${product.madeIn}</td>
                <td>${product.price}</td>
                <td>
                    <a href="#addEditModal" data-id="${product.id}" data-name="${product.brandName}" data-category="${product.category}" data-supplier="${product.supplier}"
                       data-madein="${product.madeIn}" data-price="${product.price}" data-discontinue="${product.discontinued}"
                       class="edit" data-toggle="modal"><i id="edit1" class="material-icons"
                                                           data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                    <a data-id="${product.id}" href="#deleteModal" class="delete" data-toggle="modal"><i class="material-icons"
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
            <form method="post" action="/products">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit Product</h5>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
<%--                <input name="id" class="invisible">--%>
                <input name="id" type="hidden">
                <div class="form-group">
                    <label>Name</label>
                    <input name="name" type="text" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Category</label>
                    <input name="category" type="text" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Supplier</label>
                    <input name="supplier" type="text" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Made In</label>
                    <input name="madein" type="text" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input name="price" type="text" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Discontinue</label>
                    <input name="discontinue" type="checkbox" class="form-control">
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
        <form method="post" action="/products?action=delete">
        <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Product</h4>
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
<script>
    // function test(pname) {
    //     $("#exampleModal").modal('show');
    //     $("#quoc").text(pname);
    // }
    $(document).ready(function () {
       $(".edit").click(function () {
           $(".modal-title").text("Edit Product");
           $("input[name='id']").val($(this).data("id"));
           $("input[name='name']").val($(this).data("name"));
           $("input[name='category']").val($(this).data("category"));
           $("input[name='supplier']").val($(this).data("supplier"));
           $("input[name='madein']").val($(this).data("madein"));
           $("input[name='price']").val($(this).data("price"));
           $("input[name='discontinue']").prop("checked", $(this).data("discontinue"));
       });

       $(".add").click(function(){
           $("#addEditModal").modal('show');
           $(".modal-title").text("Add Product");
           $("input[name='name'],input[name='name'],input[name='category'],input[name='supplier'],input[name='madein'],input[name='price']").val("");
           $("input[name='discontinue']").prop("checked", true);
       });

       $(".delete").click(function () {
           $("input[name='id']").val($(this).data("id"));
       });
    });
</script>
</body>
</html>
