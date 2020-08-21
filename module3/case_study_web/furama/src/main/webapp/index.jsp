<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
  <meta charset="UTF-8">
  <title>Furama Resort</title>
  <link rel="stylesheet" href="/assets/css/bootstrap.min.css" type="text/css">
  <link rel="stylesheet" href="/assets/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="/assets/css/elegant-icons.css" type="text/css">
  <link rel="stylesheet" href="/assets/css/flaticon.css" type="text/css">
  <link rel="stylesheet" href="/assets/css/owl.carousel.min.css" type="text/css">
  <link rel="stylesheet" href="/assets/css/nice-select.css" type="text/css">
  <link rel="stylesheet" href="/assets/css/jquery-ui.min.css" type="text/css">
  <link rel="stylesheet" href="/assets/css/magnific-popup.css" type="text/css">
  <link rel="stylesheet" href="/assets/css/slicknav.min.css" type="text/css">
  <link rel="stylesheet" href="/assets/css/style.css" type="text/css">
  <link rel="stylesheet" href="/assets/css/login.css" type="text/css">
</head>

<body>
<div id="preloder">
  <div class="loader"></div>

</div>

<div class="offcanvas-menu-overlay"></div>
<div class="canvas-open">
  <i class="icon_menu"></i>
</div>
<div class="offcanvas-menu-wrapper">
  <div class="canvas-close">
    <i class="icon_close"></i>
  </div>
  <div class="search-icon  search-switch">
    <i class="icon_search"></i>
  </div>
  <div class="header-configure-area">
    <div class="language-option">
      <img src="/assets/img/flag.jpg" alt="">
      <span>EN <i class="fa fa-angle-down"></i></span>
      <div class="flag-dropdown">
        <ul>
          <li><a href="#">Zi</a></li>
          <li><a href="#">Fr</a></li>
        </ul>
      </div>
    </div>
    <a href="#" class="bk-btn">Booking Now</a>
  </div>
  <nav class="mainmenu mobile-menu">
    <ul>
      <li class="active"><a href="./index.html">Home</a></li>
      <li><a href="./rooms.html">Rooms</a></li>
      <li><a href="./about-us.html">About Us</a></li>
      <li><a href="./pages.html">Pages</a>
        <ul class="dropdown">
          <li><a href="./room-details.html">Room Details</a></li>
          <li><a href="#">Deluxe Room</a></li>
          <li><a href="#">Family Room</a></li>
          <li><a href="#">Premium Room</a></li>
        </ul>
      </li>
      <li><a href="./blog.html">News</a></li>
      <li><a href="./contact.html">Contact</a></li>
    </ul>
  </nav>
  <div id="mobile-menu-wrap"></div>
  <div class="top-social">
    <a href="#"><i class="fa fa-facebook"></i></a>
    <a href="#"><i class="fa fa-twitter"></i></a>
    <a href="#"><i class="fa fa-tripadvisor"></i></a>
    <a href="#"><i class="fa fa-instagram"></i></a>
  </div>
  <ul class="top-widget">
    <li><i class="fa fa-phone"></i> (12) 345 67890</li>
    <li><i class="fa fa-envelope"></i> info.colorlib@gmail.com</li>
  </ul>
</div>

<!-- Header Section Begin -->
<header class="header-section">
  <div class="top-nav">
    <div class="container">
      <div class="row">
        <div class="col-lg-6">
          <ul class="tn-left">
            <li><i class="fa fa-phone"></i> (12) 345 67890</li>
            <li><i class="fa fa-envelope"></i> info.furama@gmail.com</li>
          </ul>
        </div>
        <div class="col-lg-6">
          <div class="tn-right">
            <div class="top-social">
              <a href="#"><i class="fa fa-facebook"></i></a>
              <a href="#"><i class="fa fa-twitter"></i></a>
              <a href="#"><i class="fa fa-tripadvisor"></i></a>
              <a href="#"><i class="fa fa-instagram"></i></a>
            </div>
            <a href="#" class="bk-btn">Booking Now</a>
            <div class="language-option">
              <img src="/assets/img/flag.jpg" alt="">
              <span>EN <i class="fa fa-angle-down"></i></span>
              <div class="flag-dropdown">
                <ul>
                  <li><a href="#">Zi</a></li>
                  <li><a href="#">Fr</a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="menu-item">
    <div class="container">
      <div class="row">
        <div style="text-align: center;position: absolute;top:20%;left: 5%" class="col-lg-2">
          <a href="./index.html">
            <label style="font-family: 'Lobster', cursive;font-size: 30px;font-weight: bold;color: #DEA978">Furama<font style="font-weight: bolder" color="blue">.</font></label>
          </a>

        </div>
        <div class="col-lg-10">
          <div class="nav-menu">
            <nav class="mainmenu">
              <ul>
                <li class="active"><a href="./index.html">Home</a></li>
                <li><a><button type="button" style="all:unset" onclick="alert('abc')">Rooms</button></a></li>
                <li>       <div class="book_btn d-none d-lg-block">
                  <a id="aPopUp" class="popup-with-form" href="#test-form">Test PopUp</a>
                </div></li>
                <li><a href="./pages.html">Pages</a>
                  <ul class="dropdown">
                    <li><a href="./room-details.html">Room Details</a></li>
                    <li><a href="./blog-details.html">Blog Details</a></li>
                    <li><a href="#">Family Room</a></li>
                    <li><a href="#">Premium Room</a></li>
                  </ul>
                </li>
                <li><a href="./blog.html">News</a></li>
                <li><a href="./contact.html">Contact</a></li>
              </ul>
            </nav>
            <div class="nav-right search-switch">
              <i class="icon_search"></i>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</header>
<!-- Header End -->

<!-- Hero Section Begin -->
<section class="hero-section">
  <div class="container">
    <div class="row">
      <div class="col-lg-6">
        <div class="hero-text">
          <h1>Testing Furama A Luxury Resort</h1>
          <p>Here are the best resort booking sites, including recommendations for international
            travel and for finding low-priced hotel rooms.</p>
          <a href="#" class="primary-btn">Discover Now</a>
        </div>
      </div>
      <div id="checkAvailable" style="height:580px;display: block" class="col-xl-4 col-lg-5 offset-xl-2 offset-lg-1">
        <div class="booking-form">
          <!--                    <h3>Booking Your Hotel</h3>-->
          <form action="#">
            <div class="check-date">
              <label for="date-in">Check In:</label>
              <input id="qgTest" type="text" class="date-input">
              <i class="icon_calendar"></i>
            </div>
            <div class="check-date">
              <label for="date-in">Check Out:</label>
              <input type="text" class="date-input">
              <i class="icon_calendar"></i>
            </div>
            <div class="select-option">
              <label>Services:</label>
              <select id="services">
                <option value="Villa">Villa</option>
                <option value="Home">Home</option>
                <option value="Room">Room</option>
              </select>
            </div>
            <div class="select-option">
              <label>Room:</label>
              <select id="rooms">
                <option value="">VIP</option>
                <option value="">Business</option>
                <option value="">Normal</option>
              </select>
            </div>
            <div class="contact-form">
              <label>Guests:</label>
              <input style="margin-bottom: 10px;height: 45px;padding-left: 20px;color: #19191a" id="guests" type="number" value="2">
            </div>
            <!--                        <div class="contact-form">-->
            <!--                            <label>Days:</label>-->
            <!--                            <input style="margin-bottom: 0px;height: 45px;padding-left: 20px;color: #19191a" id="days" type="number" value="1">-->
            <!--                        </div>-->
            <button id="btCheck" type="button">Check Availability</button>
          </form>
        </div>
      </div>
      <div id="infoGuest" style="height:580px;display: none" class="col-xl-4 col-lg-5 offset-xl-2 offset-lg-1">
        <div class="booking-form">
          <form action="#">
            <div class="contact-form">
              <label>Your Name:</label>
              <input style="margin-bottom: 10px;height: 45px;padding-left: 20px;color: #19191a" id="idName" type="text">
            </div>
            <div class="check-date">
              <label for="date-in">Your Birthday:</label>
              <input style="height: 45px" type="text" class="date-input" id="date-in">
              <i class="icon_calendar"></i>
            </div>
            <div class="contact-form">
              <label>Your ID card:</label>
              <input style="margin-bottom: 10px;height: 45px;padding-left: 20px;color: #19191a" id="idCard" type="number">
            </div>
            <div class="contact-form">
              <label>Your Email:</label>
              <input style="margin-bottom: 10px;height: 45px;padding-left: 20px;color: #19191a" id="idEmail" type="number">
            </div>
            <div class="contact-form">
              <label>Your Address:</label>
              <input style="margin-bottom: 0px;height: 45px;padding-left: 20px;color: #19191a" id="idAddress" type="number">
            </div>
            <button id="btNext" type="button">Complete Reservation</button>
          </form>
        </div>
      </div>
      <div id="infoTotal" style="height:580px;display: none" class="col-xl-4 col-lg-5 offset-xl-2 offset-lg-1">
        <div class="booking-form">
          <form action="#">
            <div class="select-option">
              <!--                            <label>Your Member Type: <strong>Not A Member Yet</strong></label>-->

              <p id="notMember" style="margin-top: -15px; font-size: 15px">If you are a member, <a id="btLogin" class="popup-with-form" href="#quoc">Click here to login</a></p>
              <p id="idMember" style="display: none">Welcome <strong>Quoc Gunner!</strong></p>
              <!--                            <select style="display: none" id="selCustomer">-->
              <!--                                <option value="">Normal</option>-->
              <!--                                <option name="noMember">Diamond</option>-->
              <!--                                <option name="noMember">Platinum</option>-->
              <!--                                <option name="noMember">Gold</option>-->
              <!--                                <option name="noMember">Silver</option>-->
              <!--                            </select>-->
            </div>

            <div>
              <label style="font-weight: bold;padding-top: 3px">Your Reservation:</label>
              <div class="info">
                <p><label class="field">Reservation Day:</label><label class="field data">05-07-2020</label></p>
                <p><label class="field">Member Type:</label><label id="lbMemberType" class="field data">Not A Member</label></p>
                <p><label class="field">Check In:</label><label class="field data">10-07-2020</label></p>
                <p><label class="field">Check Out:</label><label class="field data">12-07-2020</label></p>
                <p><label class="field">Services:</label><label class="field data">Villa</label></p>
                <p><label class="field">Room:</label><label class="field data">VIP</label></p>
                <p><label class="field">Guest:</label><label class="field data">2</label></p>
                <p><label class="field">Total Price:</label><label id="lbTotal" class="field data" style="font-weight: bold">1000$</label></p>
                <p><label class="field">Drop Price:</label><label id="lbDrop" class="field data" style="font-weight: bold;color: red">200$</label></p>
                <p><label class="field">Final Price:</label><label id="lbFinalPrice" class="field data" style="font-weight: bold; color: #0B29CF">12000$</label></p>
              </div>
              <div id="btSection">
                <button id="btEdit" type="button">Edit</button>
                <button id="btRemove" style="padding-left: 3px" type="button" class="btn btn-link">Remove</button>
              </div>
            </div>
            <div>
            </div>
            <button id="btSubmit" type="button">Booking Now</button>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="hero-slider owl-carousel">
    <div class="hs-item set-bg" data-setbg="/assets/img/hero/hero-1.jpg"></div>
    <div class="hs-item set-bg" data-setbg="/assets/img/hero/hero-2.jpg"></div>
    <div class="hs-item set-bg" data-setbg="/assets/img/hero/hero-3.jpg"></div>
  </div>
</section>
<!-- Hero Section End -->

<!-- Services Section End -->
<section class="services-section spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="section-title">
          <span>What We Do</span>
          <h2>Discover Our Services</h2>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-4 col-sm-6">
        <div class="service-item">
          <i class="flaticon-036-parking"></i>
          <h4>Travel Plan</h4>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
            labore et dolore magna.</p>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6">
        <div class="service-item">
          <i class="flaticon-033-dinner"></i>
          <h4>Catering Service</h4>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
            labore et dolore magna.</p>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6">
        <div class="service-item">
          <i class="flaticon-026-bed"></i>
          <h4>Babysitting</h4>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
            labore et dolore magna.</p>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6">
        <div class="service-item">
          <i class="flaticon-024-towel"></i>
          <h4>Laundry</h4>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
            labore et dolore magna.</p>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6">
        <div class="service-item">
          <i class="flaticon-044-clock-1"></i>
          <h4>Hire Driver</h4>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
            labore et dolore magna.</p>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6">
        <div class="service-item">
          <i class="flaticon-012-cocktail"></i>
          <h4>Bar & Drink</h4>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
            labore et dolore magna.</p>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Services Section End -->

<!-- Home Room Section Begin -->
<section class="hp-room-section">
  <div class="container-fluid">
    <div class="hp-room-items">
      <div class="row">
        <div class="col-lg-3 col-md-6">
          <div class="hp-room-item set-bg" data-setbg="@{/assets/img/room/room-b1.jpg">
            <div class="hr-text">
              <h3>Double Room</h3>
              <h2>199$<span>/Pernight</span></h2>
              <table>
                <tbody>
                <tr>
                  <td class="r-o">Size:</td>
                  <td>30 ft</td>
                </tr>
                <tr>
                  <td class="r-o">Capacity:</td>
                  <td>Max persion 5</td>
                </tr>
                <tr>
                  <td class="r-o">Bed:</td>
                  <td>King Beds</td>
                </tr>
                <tr>
                  <td class="r-o">Services:</td>
                  <td>Wifi, Television, Bathroom,...</td>
                </tr>
                </tbody>
              </table>
              <a href="#" class="primary-btn">More Details</a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="hp-room-item set-bg" data-setbg="@{/assets/img/room/room-b2.jpg">
            <div class="hr-text">
              <h3>Premium King Room</h3>
              <h2>159$<span>/Pernight</span></h2>
              <table>
                <tbody>
                <tr>
                  <td class="r-o">Size:</td>
                  <td>30 ft</td>
                </tr>
                <tr>
                  <td class="r-o">Capacity:</td>
                  <td>Max persion 5</td>
                </tr>
                <tr>
                  <td class="r-o">Bed:</td>
                  <td>King Beds</td>
                </tr>
                <tr>
                  <td class="r-o">Services:</td>
                  <td>Wifi, Television, Bathroom,...</td>
                </tr>
                </tbody>
              </table>
              <a href="#" class="primary-btn">More Details</a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="hp-room-item set-bg" data-setbg="@{/assets/img/room/room-b3.jpg">
            <div class="hr-text">
              <h3>Deluxe Room</h3>
              <h2>198$<span>/Pernight</span></h2>
              <table>
                <tbody>
                <tr>
                  <td class="r-o">Size:</td>
                  <td>30 ft</td>
                </tr>
                <tr>
                  <td class="r-o">Capacity:</td>
                  <td>Max persion 5</td>
                </tr>
                <tr>
                  <td class="r-o">Bed:</td>
                  <td>King Beds</td>
                </tr>
                <tr>
                  <td class="r-o">Services:</td>
                  <td>Wifi, Television, Bathroom,...</td>
                </tr>
                </tbody>
              </table>
              <a href="#" class="primary-btn">More Details</a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="hp-room-item set-bg" data-setbg="@{/assets/img/room/room-b4.jpg">
            <div class="hr-text">
              <h3>Family Room</h3>
              <h2>299$<span>/Pernight</span></h2>
              <table>
                <tbody>
                <tr>
                  <td class="r-o">Size:</td>
                  <td>30 ft</td>
                </tr>
                <tr>
                  <td class="r-o">Capacity:</td>
                  <td>Max persion 5</td>
                </tr>
                <tr>
                  <td class="r-o">Bed:</td>
                  <td>King Beds</td>
                </tr>
                <tr>
                  <td class="r-o">Services:</td>
                  <td>Wifi, Television, Bathroom,...</td>
                </tr>
                </tbody>
              </table>
              <a href="#" class="primary-btn">More Details</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Home Room Section End -->

<!-- Testimonial Section Begin -->
<section class="testimonial-section spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="section-title">
          <span>Testimonials</span>
          <h2>What Customers Say?</h2>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-8 offset-lg-2">
        <div class="testimonial-slider owl-carousel">
          <div class="ts-item">
            <p>After a construction project took longer than expected, my husband, my daughter and I
              needed a place to stay for a few nights. As a Chicago resident, we know a lot about our
              city, neighborhood and the types of housing options available and absolutely love our
              vacation at Sona Hotel.</p>
            <div class="ti-author">
              <div class="rating">
                <i class="icon_star"></i>
                <i class="icon_star"></i>
                <i class="icon_star"></i>
                <i class="icon_star"></i>
                <i class="icon_star-half_alt"></i>
              </div>
              <h5> - Alexander Vasquez</h5>
            </div>
            <img src="/assets/img/testimonial-logo.png" alt="">
          </div>
          <div class="ts-item">
            <p>After a construction project took longer than expected, my husband, my daughter and I
              needed a place to stay for a few nights. As a Chicago resident, we know a lot about our
              city, neighborhood and the types of housing options available and absolutely love our
              vacation at Sona Hotel.</p>
            <div class="ti-author">
              <div class="rating">
                <i class="icon_star"></i>
                <i class="icon_star"></i>
                <i class="icon_star"></i>
                <i class="icon_star"></i>
                <i class="icon_star-half_alt"></i>
              </div>
              <h5> - Alexander Vasquez</h5>
            </div>
            <img src="/assets/img/testimonial-logo.png" alt="">
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Testimonial Section End -->


<!-- Footer Section Begin -->
<footer class="footer-section">
  <div class="container">
    <div class="footer-text">
      <div class="row">
        <div class="col-lg-4">
          <div class="ft-about">
            <a href="#">
              <label style="font-family: 'Lobster', cursive;font-size: 30px;font-weight: bold;color: #DEA978">Furama<font style="font-weight: bolder" color="blue">.</font></label>
            </a>
            <p>We inspire and reach millions of travelers<br /> across 90 local websites</p>
            <div class="fa-social">
              <a href="#"><i class="fa fa-facebook"></i></a>
              <a href="#"><i class="fa fa-twitter"></i></a>
              <a href="#"><i class="fa fa-tripadvisor"></i></a>
              <a href="#"><i class="fa fa-instagram"></i></a>
              <a href="#"><i class="fa fa-youtube-play"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 offset-lg-1">
          <div class="ft-contact">
            <h6>Contact Us</h6>
            <ul>
              <li>(12) 345 67890</li>
              <li>info.furama@gmail.com</li>
              <li>856 Cordia Extension Apt. 356, Lake, United State</li>
            </ul>
          </div>
        </div>
        <div class="col-lg-3 offset-lg-1">
          <div class="ft-newslatter">
            <h6>New latest</h6>
            <p>Get the latest updates and offers.</p>
            <form action="#" class="fn-form">
              <input type="text" placeholder="Email">
              <button type="submit"><i class="fa fa-send"></i></button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</footer>
<!-- Footer Section End -->
<div id="quoc" class="white-popup-block mfp-hide login-page">
  <div class="form">
    <form class="login-form" method="post" action="login">
      <input type="text" placeholder="username" name="username"/>
      <input type="password" placeholder="password" name="password"/>
      <button type="button" onclick="quocClick();">login</button>
    </form>
  </div>
</div>
<!--<form id="login-form" class="white-popup-block mfp-hide" style="margin: 0;text-align: center;padding-bottom: 100px">-->
<!--    <div class="popup_box" style="width: 30%;height: 100%">-->
<!--            hello-->

<!--    </div>-->
<!--</form>-->


<form id="test-form" class="white-popup-block mfp-hide">
  <div class="popup_box">
    <div class="popup_inner">
      <div class="limiter">
        <div class="container-table100">
          <div class="wrap-table100">
            <div class="table100">

            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</form>
<!-- form itself end -->

<!-- Js Plugins -->
<script src="/assets/js/jquery-3.3.1.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/jquery.magnific-popup.min.js"></script>
<script src="/assets/js/jquery.nice-select.min.js"></script>
<script src="/assets/js/jquery-ui.min.js"></script>
<script src="/assets/js/jquery.slicknav.js"></script>
<script src="/assets/js/owl.carousel.min.js"></script>
<script>
  $(document).ready(function() {
    $('.popup-with-form').magnificPopup({
      type: 'inline',
      preloader: false,
      focus: '#name',

      // When elemened is focused, some mobile browsers in some cases zoom in
      // It looks not nice, so we disable it:
  });});

  function quocClick() {
    $("#notMember").hide();
    $("#idMember").show();
    $("#lbMemberType").text("Diamond") ;
    $("#btSubmit").text("Complete Reservation");
    $(".mfp-close").click();
  }
</script>
<script src="/assets/js/main.js"></script>
</body>

</html>