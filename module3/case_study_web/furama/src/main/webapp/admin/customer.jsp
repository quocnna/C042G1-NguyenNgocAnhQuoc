<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="/assets/commons/images/favicon.png" rel="icon" type="image/png" sizes="16x16">
    <title>Customer Page</title>
    <link href="/assets/commons/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/admin/css/style.css" rel="stylesheet">
    <link href="/assets/admin/css/colors/blue.css" id="theme" rel="stylesheet">
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

            <div class="row page-titles">
                <div class="col-md-6 col-8 align-self-center">
                    <h3 class="text-themecolor m-b-0 m-t-0">Customer</h3>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                        <li class="breadcrumb-item active">Customer</li>
                    </ol>
                </div>
            </div>
            <div class="row">
                <%--                qg23--%>
            </div>
        </div>
        <footer class="footer text-center">
            © 2020 Admin by quocnna@gmail.com
        </footer>
    </div>
</div>

<script src="/assets/commons/plugins/jquery/jquery.min.js"></script>
<script src="/assets/commons/plugins/bootstrap/js/tether.min.js"></script>
<script src="/assets/commons/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/admin/js/jquery.slimscroll.js"></script>
<script src="/assets/admin/js/waves.js"></script>
<script src="/assets/admin/js/sidebarmenu.js"></script>
<script src="/assets/commons/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
<script src="/assets/admin/js/custom.js"></script>
<script src="/assets/commons/plugins/flot/jquery.flot.js"></script>
<script src="/assets/commons/plugins/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
<script src="/assets/admin/js/flot-data.js"></script>
<script src="/assets/commons/plugins/styleswitcher/jQuery.style.switcher.js"></script>
</body>

</html>
