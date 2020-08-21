<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="/assets/commons/images/favicon.png" rel="icon" type="image/png" sizes="16x16">
    <title>Administrator Page</title>
    <link href="/assets/commons/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/admin/css/style.css" rel="stylesheet">
    <link href="/assets/admin/css/colors/blue.css" id="theme" rel="stylesheet">
</head>

<body class="fix-header fix-sidebar card-no-border">

<div class="preloader">
    <svg class="circular" viewBox="25 25 50 50">
        <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" /> </svg>
</div>
<div id="main-wrapper">
    <header class="topbar">
        <nav class="navbar top-navbar navbar-toggleable-sm navbar-light">
            <div class="navbar-header">
                <a class="navbar-brand" href="index.html">
                    <b>
                        <img src="/assets/commons/images/logo-icon.png" alt="homepage" class="dark-logo" />

                    </b>
                    <span>
                            Admin
                        </span>
                </a>
            </div>
            <div class="navbar-collapse">
                <ul class="navbar-nav mr-auto mt-md-0 ">
                    <li class="nav-item"> <a class="nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark" href="javascript:void(0)"><i class="ti-menu"></i></a> </li>
                    <li class="nav-item hidden-sm-down">
                        <form class="app-search p-l-20">
                            <input type="text" class="form-control" placeholder="Search for..."> <a class="srh-btn"><i class="ti-search"></i></a>
                        </form>
                    </li>
                </ul>
                <ul class="navbar-nav my-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="/assets/commons/images/users/a.jpg" alt="user" class="profile-pic m-r-5" />Quoc Gunner</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <div class="left-sidebar">
        <!-- Sidebar scroll-->
        <div class="scroll-sidebar">
            <!-- Sidebar navigation-->
            <nav class="sidebar-nav">
                <ul id="sidebarnav">
                    <li>
                        <a href="/" class="waves-effect"><i class="fa fa-clock-o m-r-10" aria-hidden="true"></i>Dashboard</a>
                    </li>
                    <li>
                        <a href="pages-profile.html" class="waves-effect"><i class="fa fa-user m-r-10" aria-hidden="true"></i>Profile</a>
                    </li>
                    <li>
                        <a href="/admin/customer" class="waves-effect"><i class="fa fa-font m-r-10" aria-hidden="true"></i>Reservation</a>
                    </li>
                    <li>
                        <a href="/admin//employee" class="waves-effect"><i class="fa fa-table m-r-10" aria-hidden="true"></i>Employer</a>
                    </li>
                    <li>
                        <a href="/admin/customer" class="waves-effect"><i class="fa fa-font m-r-10" aria-hidden="true"></i>Customer</a>
                    </li>
                    <li>
                        <a href="map-google.html" class="waves-effect"><i class="fa fa-globe m-r-10" aria-hidden="true"></i>Google Map</a>
                    </li>
                    <li>
                        <a href="pages-blank.html" class="waves-effect"><i class="fa fa-columns m-r-10" aria-hidden="true"></i>Blank Page</a>
                    </li>
                    <li>
                        <a href="pages-error-404.html" class="waves-effect"><i class="fa fa-info-circle m-r-10" aria-hidden="true"></i>Error 404</a>
                    </li>
                </ul>
            </nav>
            <!-- End Sidebar navigation -->
        </div>
        <!-- End Sidebar scroll-->
    </div>
    <!-- ============================================================== -->
    <!-- End Left Sidebar - style you can find in sidebar.scss  -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- Page wrapper  -->
    <!-- ============================================================== -->
    <div class="page-wrapper">
        <!-- ============================================================== -->
        <!-- Container fluid  -->
        <!-- ============================================================== -->
        <div class="container-fluid">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="row page-titles">
                <div class="col-md-6 col-8 align-self-center">
                    <h3 class="text-themecolor m-b-0 m-t-0">Dashboard</h3>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Start Page Content -->
            <!-- ============================================================== -->
            <!-- Row -->
            <div class="row">
                <!-- Column -->
                <div class="col-sm-6">
                    <div class="card">
                        <div class="card-block">
                            <h4 class="card-title">Daily Sales</h4>
                            <div class="text-right">
                                <h2 class="font-light m-b-0"><i class="ti-arrow-up text-success"></i> $120</h2>
                                <span class="text-muted">Todays Income</span>
                            </div>
                            <span class="text-success">80%</span>
                            <div class="progress">
                                <div class="progress-bar bg-success" role="progressbar" style="width: 80%; height: 6px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Column -->
                <!-- Column -->
                <div class="col-sm-6">
                    <div class="card">
                        <div class="card-block">
                            <h4 class="card-title">Weekly Sales</h4>
                            <div class="text-right">
                                <h2 class="font-light m-b-0"><i class="ti-arrow-up text-info"></i> $5,000</h2>
                                <span class="text-muted">Todays Income</span>
                            </div>
                            <span class="text-info">30%</span>
                            <div class="progress">
                                <div class="progress-bar bg-info" role="progressbar" style="width: 30%; height: 6px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Column -->
            </div>
            <!-- Row -->
            <!-- Row -->
            <div class="row">
                <!-- column -->
                <div class="col-sm-12">
                    <div class="card">
                        <div class="card-block">
                            <h4 class="card-title">Revenue Statistics</h4>
                            <div class="flot-chart">
                                <div class="flot-chart-content" id="flot-line-chart"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- column -->
            </div>
            <!-- Row -->
            <!-- Row -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="card">
                        <div class="card-block">
                            <select class="custom-select pull-right">
                                <option selected>January</option>
                                <option value="1">February</option>
                                <option value="2">March</option>
                                <option value="3">April</option>
                            </select>
                            <h4 class="card-title">Projects of the Month</h4>
                            <div class="table-responsive m-t-40">
                                <table class="table stylish-table">
                                    <thead>
                                    <tr>
                                        <th colspan="2">Assigned</th>
                                        <th>Name</th>
                                        <th>Budget</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td style="width:50px;"><span class="round">S</span></td>
                                        <td>
                                            <h6>Sunil Joshi</h6><small class="text-muted">Web Designer</small></td>
                                        <td>Elite Admin</td>
                                        <td>$3.9K</td>
                                    </tr>
                                    <tr class="active">
                                        <td><span class="round"><img src="/assets/commons/images/users/2.jpg" alt="user" width="50" /></span></td>
                                        <td>
                                            <h6>Andrew</h6><small class="text-muted">Project Manager</small></td>
                                        <td>Real Homes</td>
                                        <td>$23.9K</td>
                                    </tr>
                                    <tr>
                                        <td><span class="round round-success">B</span></td>
                                        <td>
                                            <h6>Bhavesh patel</h6><small class="text-muted">Developer</small></td>
                                        <td>MedicalPro Theme</td>
                                        <td>$12.9K</td>
                                    </tr>
                                    <tr>
                                        <td><span class="round round-primary">N</span></td>
                                        <td>
                                            <h6>Nirav Joshi</h6><small class="text-muted">Frontend Eng</small></td>
                                        <td>Elite Admin</td>
                                        <td>$10.9K</td>
                                    </tr>
                                    <tr>
                                        <td><span class="round round-warning">M</span></td>
                                        <td>
                                            <h6>Micheal Doe</h6><small class="text-muted">Content Writer</small></td>
                                        <td>Helping Hands</td>
                                        <td>$12.9K</td>
                                    </tr>
                                    <tr>
                                        <td><span class="round round-danger">N</span></td>
                                        <td>
                                            <h6>Johnathan</h6><small class="text-muted">Graphic</small></td>
                                        <td>Digital Agency</td>
                                        <td>$2.6K</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Row -->
            <!-- Row -->
            <div class="row">
                <!-- Column -->
                <div class="col-lg-4">
                    <div class="card">
                        <img class="card-img-top img-responsive" src="/assets/commons/images/big/img1.jpg" alt="Card">
                        <div class="card-block">
                            <ul class="list-inline font-14">
                                <li class="p-l-0">20 May 2016</li>
                                <li><a href="javascript:void(0)" class="link">3 Comment</a></li>
                            </ul>
                            <h3 class="font-normal">Featured Hydroflora Pots Garden &amp; Outdoors</h3>
                        </div>
                    </div>
                </div>
                <!-- Column -->
                <!-- Column -->
                <div class="col-lg-4">
                    <div class="card">
                        <img class="card-img-top img-responsive" src="/assets/commons/images/big/img2.jpg" alt="Card">
                        <div class="card-block">
                            <ul class="list-inline font-14">
                                <li class="p-l-0">20 May 2016</li>
                                <li><a href="javascript:void(0)" class="link">3 Comment</a></li>
                            </ul>
                            <h3 class="font-normal">Featured Hydroflora Pots Garden &amp; Outdoors</h3>
                        </div>
                    </div>
                </div>
                <!-- Column -->
                <!-- Column -->
                <div class="col-lg-4">
                    <div class="card">
                        <img class="card-img-top img-responsive" src="/assets/commons/images/big/img4.jpg" alt="Card">
                        <div class="card-block">
                            <ul class="list-inline font-14">
                                <li class="p-l-0">20 May 2016</li>
                                <li><a href="javascript:void(0)" class="link">3 Comment</a></li>
                            </ul>
                            <h3 class="font-normal">Featured Hydroflora Pots Garden &amp; Outdoors</h3>
                        </div>
                    </div>
                </div>
                <!-- Column -->
            </div>
            <!-- Row -->
            <!-- ============================================================== -->
            <!-- End PAge Content -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Container fluid  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- footer -->
        <!-- ============================================================== -->
        <footer class="footer text-center">
            © 2020 Admin by quocnna@gmail.com
        </footer>
        <!-- ============================================================== -->
        <!-- End footer -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Page wrapper  -->
    <!-- ============================================================== -->
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

