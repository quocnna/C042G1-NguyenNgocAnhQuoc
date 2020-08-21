<%@ page import="common.Paging" %>
<%@ page import="java.util.stream.IntStream" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="/assets/commons/images/favicon.png" rel="icon" type="image/png" sizes="16x16">
    <title>Employee Page</title>
<%--    <link href="/assets/commons/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="/assets/admin/css/style.css" rel="stylesheet">
    <link href="/assets/admin/css/colors/blue.css" id="theme" rel="stylesheet">

    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="/assets/css/toastr.css">
    <link rel="stylesheet" href="/assets/css/crud.css">
<%--    <script src="/assets/commons/plugins/jquery/jquery.min.js"></script>--%>
<%--    <script src="/assets/commons/plugins/bootstrap/js/bootstrap.min.js"></script>--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/assets/js/toastr.min.js"></script>
    <script src="/assets/js/crud.js"></script>

</head>

<body class="fix-header fix-sidebar card-no-border">

<div class="preloader">
    <svg class="circular" viewBox="25 25 50 50">
        <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10"/>
    </svg>
</div>
<div id="main-wrapper">
    <header class="topbar">
        <nav class="navbar top-navbar navbar-toggleable-sm navbar-light">
            <div class="navbar-header">
                <a class="navbar-brand" href="index.html">
                    <b>
                        <img src="/assets/commons/images/logo-icon.png" alt="homepage" class="dark-logo"/>

                    </b>
                    <span>
                            Admin
                        </span>
                </a>
            </div>
            <div class="navbar-collapse">
                <ul class="navbar-nav mr-auto mt-md-0 ">
                    <li class="nav-item"><a class="nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark"
                                            href="javascript:void(0)"><i class="ti-menu"></i></a></li>
                    <li class="nav-item hidden-sm-down">
                        <form class="app-search p-l-20">
                            <input type="text" class="form-control" placeholder="Search for..."> <a class="srh-btn"><i
                                class="ti-search"></i></a>
                        </form>
                    </li>
                </ul>
                <ul class="navbar-nav my-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href=""
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img
                                src="/assets/commons/images/users/a.jpg" alt="user" class="profile-pic m-r-5"/>Quoc
                            Gunner</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <div class="left-sidebar">
        <div class="scroll-sidebar">
            <nav class="sidebar-nav">
                <ul id="sidebarnav">
                    <li>
                        <a href="/" class="waves-effect"><i class="fa fa-clock-o m-r-10" aria-hidden="true"></i>Dashboard</a>
                    </li>
                    <li>
                        <a href="pages-profile.html" class="waves-effect"><i class="fa fa-user m-r-10"
                                                                             aria-hidden="true"></i>Profile</a>
                    </li>
                    <li>
                        <a href="/reservation" class="waves-effect"><i class="fa fa-font m-r-10" aria-hidden="true"></i>Reservation</a>
                    </li>
                    <li>
                        <a href="/employee" class="waves-effect"><i class="fa fa-table m-r-10" aria-hidden="true"></i>Employer</a>
                    </li>
                    <li>
                        <a href="/customer" class="waves-effect"><i class="fa fa-font m-r-10" aria-hidden="true"></i>Customer</a>
                    </li>
                    <li>
                        <a href="map-google.html" class="waves-effect"><i class="fa fa-globe m-r-10"
                                                                          aria-hidden="true"></i>Google Map</a>
                    </li>
                    <li>
                        <a href="pages-blank.html" class="waves-effect"><i class="fa fa-columns m-r-10"
                                                                           aria-hidden="true"></i>Blank Page</a>
                    </li>
                    <li>
                        <a href="pages-error-404.html" class="waves-effect"><i class="fa fa-info-circle m-r-10"
                                                                               aria-hidden="true"></i>Error 404</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <%--                qg23--%>
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
                                        <h2>Manage <b>Employee</b></h2>
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
                                                        <li><a href="#">Name</a></li>
                                                        <li><a href="#">Email</a></li>
                                                        <li><a href="#">Phone</a></li>
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
                                            <span>Add New Employee</span></a>
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
                                    <th>Name</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th>Salary</th>
                                    <th>Position Name</th>
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
                                        <td>${item.phone}</td>
                                        <td>${item.email}</td>
                                        <td>${item.salary}</td>
                                        <td>${item.position_name}</td>
                                        <td>
                                            <a href="#addEditModal" class="edit" data-toggle="modal" data-id="${item.id}"
                                               data-name="${item.name}" data-phone="${item.phone}" data-email="${item.email}"
                                               data-salary="${item.salary}" data-position_id="${item.position_id}"
                                               data-position_name="${item.position_name}"><i class="material-icons" data-toggle="tooltip"
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
                            <form method="post" action="/note" id="SignupForm">
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
                                            <label>Email</label>
                                            <input name="email" type="text" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Division:</label>
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
                            $(".modal-title").text("Edit Empployee");
                            $("input[name='id']").val($(this).data("id"));
                            $("input[name='name']").val($(this).data("name"));
                            $("input[name='email']").val($(this).data("email"));
                            // var nti = $(this).data("note_type_id");
                            // $("select[name='notetype'] option").each(function () {
                            //     if (this.value == nti) {
                            //         $(this).prop("selected", true)
                            //         return false;
                            //     }
                            // });
                        });

                        $(".add").click(function () {
                            // $("#addEditModal").modal('show');
                            $(".modal-title").text("Add Note");
                            $("input[name='id'],input[name='name'],input[name='email']").val("");
                        });
                    </script>
            </div>
        </div>
        <footer class="footer text-center">
            © 2020 Admin by quocnna@gmail.com
        </footer>
    </div>
</div>

<script src="/assets/commons/plugins/bootstrap/js/tether.min.js"></script>
<script src="/assets/admin/js/jquery.slimscroll.js"></script>
<script src="/assets/admin/js/waves.js"></script>
<script src="/assets/admin/js/sidebarmenu.js"></script>
<script src="/assets/commons/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
<script src="/assets/admin/js/custom.js"></script>
<script src="/assets/commons/plugins/flot/jquery.flot.js"></script>
<script src="/assets/commons/plugins/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
<script src="/assets/admin/js/flot-data.js"></script>
<script src="/assets/commons/plugins/styleswitcher/jQuery.style.switcher.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/css/bootstrapValidator.css"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
<script type="text/javascript">
    $(document).ready(function()
    {
        // Generate a simple captcha
        function randomNumber(min, max)
        {
            return Math.floor(Math.random() * (max - min + 1) + min);
        };
        $('#captchasignup').html([randomNumber(1, 100), '+', randomNumber(1, 200), '='].join(' '));
        $('#SignupForm').bootstrapValidator
        ({
            message: 'This value is not valid', fields:
                {
                    name: {
                        message: 'The username is not valid',
                        validators: {
                            notEmpty: {
                                message: 'The username is required and can\'t be empty'
                            },
                            stringLength: {
                                min: 6,
                                max: 30,
                                message: 'The username must be more than 6 and less than 30 characters long'
                            },
                            regexp: {
                                regexp: /^[a-zA-Z0-9_\.]+$/,
                                message: 'The username can only consist of alphabetical, number, dot and underscore'
                            },
                            different: {
                                field: 'password',
                                message: 'The username and password can\'t be the same as each other'
                            }
                        }
                    },
                    email: {
                        validators: {
                            notEmpty: {
                                message: 'The email address is required and can\'t be empty'
                            },
                            emailAddress: {
                                message: 'The input is not a valid email address'
                            }
                        }
                    },
                    password: {
                        validators: {
                            notEmpty: {
                                message: 'The password is required and can\'t be empty'
                            },
                            identical: {
                                field: 'confirmPassword',
                                message: 'The password and its confirm are not the same'
                            },
                            different: {
                                field: 'username',
                                message: 'The password can\'t be the same as username'
                            }
                        }
                    },
                    confirmPassword: {
                        validators: {
                            notEmpty: {
                                message: 'The confirm password is required and can\'t be empty'
                            },
                            identical: {
                                field: 'password',
                                message: 'The password and its confirm are not the same'
                            },
                            different: {
                                field: 'username',
                                message: 'The password can\'t be the same as username'
                            }
                        }
                    },
                    captcha: {
                        validators: {
                            callback: {
                                message: 'Wrong answer',
                                callback: function(value, validator) {
                                    var items = $('#captchaOperation').html().split(' '),
                                        sum = parseInt(items[0]) + parseInt(items[2]);
                                    return value == sum;
                                }
                            }
                        }
                    }
                }
        });
    });
</script>
</body>

</html>
