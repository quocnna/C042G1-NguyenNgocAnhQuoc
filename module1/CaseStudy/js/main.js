'use strict';

(function ($) {
    class Customer{
        constructor(name, idCard, email, birthday, address, cusType, serType, roomType, numGuest, numDay ) {
            this.name = name;
            this.idCard = idCard;
            this.email = email;
            this.birthday = birthday;
            this.address = address;
            this.cusType = cusType;
            this.serType = serType;
            this.roomType = roomType;
            this.numGuest = numGuest;
            this.numDay = numDay;
        }

        testMethod()
        {
            alert("Test Method");
        }
    }

    // Object.objsize = function(Myobj) {
    //     let osize = 0, key;
    //     for (key in Myobj) {
    //         if (Myobj.hasOwnProperty(key)) osize++;
    //     }
    //     return osize;
    // };

    $("#aPopUp").click(()=>{
        $("#abc").remove();
        const tbl = document.createElement("table");
        const thead =  document.createElement("thead");
        const tbody = document.createElement("tbody");
        for (let i = 0; i < list.length; i++) {
            const row = document.createElement("tr");
            const thRow = document.createElement("tr");
            for (let j =0;j< Object.keys(list[i]).length; j++) {
                if(j==1|| j==3 || j==4 || j==7)
                {
                    continue;
                }

                if(i==0)
                {
                    const th = document.createElement("th");
                    const thText = document.createTextNode(Object.keys(list[i])[j]);
                    th.appendChild(thText);
                    th.classList.add("column6");
                    thRow.appendChild(th);
                    thRow.classList.add("table100-head");
                    thead.appendChild(thRow);
                }
                const cell = document.createElement("td");
                const data= document.createTextNode(list[i][Object.keys(list[i])[j]]);
                cell.appendChild(data);
                cell.classList.add("column6");
                row.appendChild(cell);
            }
            tbody.appendChild(row);
        }
        tbl.appendChild(thead);
        tbl.appendChild(tbody);
        tbl.setAttribute("id","abc");
        $(".table100").append(tbl);
    })

    let cusTest1 = new Customer("a","1","email","birthday","address","custype","serType","rType","numGuest","numDay");
    let cusTest2 = new Customer("b","1","email","birthday","address","custype","serType","rType","numGuest","numDay");
    let cusTest3 = new Customer("c","1","email","birthday","address","custype","serType","rType","numGuest","numDay");
   // Object.objsize(cusTest1);
    let list = [cusTest1,cusTest2,cusTest3];
    $("#btCheck").click(function () {
        $("#checkAvailable").hide();
        $("#infoGuest").show();
    })

    $("#btNext").click(()=>{
        $("#infoGuest").hide();
        $("#infoTotal").show();
        let nDay = parseInt(document.getElementById("days").value);
        const lbTotal = document.getElementById("lbTotal");
        const lbDrop = document.getElementById("lbDrop");
        const lbFinal = document.getElementById("lbFinalPrice");
        switch ($("#services").val()) {
            case "Villa":
                lbTotal.textContent = 500*nDay +"$";
                lbDrop.textContent = 0.01*(500*nDay)+"$";
                lbFinal.textContent= ((500*nDay)-0.01*(500*nDay))+"$";
                break;
            case "Home":
                lbTotal.textContent = 300*nDay+"$";
                lbDrop.textContent = 0.01*(300*nDay)+"$";
                lbFinal.textContent= ((300*nDay)-0.01*(300*nDay))+"$";
                break;
            case "Room":
                lbTotal.textContent = 100*nDay+"$";
                lbDrop.textContent = 0.01*(100*nDay)+"$";
                lbFinal.textContent= ((100*nDay)-0.01*(100*nDay))+"$";
                break;
        }
    })

    $("#btSubmit").click(()=>{
        let cusTest4 = new Customer("d","1","email","birthday","address","custype","serType","rType","numGuest","numDay");
        list.push(cusTest4);
        alert(list.length);
    })

    $("#btEdit").click(()=>{
        $("#infoTotal").hide();
        $("#guests").val("4");
        $("#days").val("5");
        $("#checkAvailable").show();
    });

    $("#btTestContact").click(()=>{
        list.forEach(ele => alert(ele.name));
    });

    $("#btRemove").click(()=>{
        $("#infoTotal").hide();
        $("#guests").val("1");
        $("#days").val("1");
        $("#checkAvailable").show();
    });


    $(window).on('load', function () {
        $(".loader").fadeOut();
        $("#preloder").delay(23).fadeOut("slow");
    });

    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        $(this).css('background-image', 'url(' + bg + ')');
    });

    //Offcanvas Menu
    $(".canvas-open").on('click', function () {
        $(".offcanvas-menu-wrapper").addClass("show-offcanvas-menu-wrapper");
        $(".offcanvas-menu-overlay").addClass("active");
    });

    $(".canvas-close, .offcanvas-menu-overlay").on('click', function () {
        $(".offcanvas-menu-wrapper").removeClass("show-offcanvas-menu-wrapper");
        $(".offcanvas-menu-overlay").removeClass("active");
    });

    // Search model
    $('.search-switch').on('click', function () {
        $('.search-model').fadeIn(400);
    });

    $('.search-close-switch').on('click', function () {
        $('.search-model').fadeOut(400, function () {
            $('#search-input').val('');
        });
    });

    /*------------------
		Navigation
	--------------------*/
    $(".mobile-menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

    /*------------------
        Hero Slider
    --------------------*/
   $(".hero-slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 1,
        dots: true,
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        mouseDrag: false
    });

    /*------------------------
		Testimonial Slider
    ----------------------- */
    $(".testimonial-slider").owlCarousel({
        items: 1,
        dots: false,
        autoplay: true,
        loop: true,
        smartSpeed: 1200,
        nav: true,
        navText: ["<i class='arrow_left'></i>", "<i class='arrow_right'></i>"]
    });

    /*------------------
        Magnific Popup
    --------------------*/
    $('.video-popup').magnificPopup({
        type: 'iframe'
    });

    /*------------------
		Date Picker
	--------------------*/
    $(".date-input").datepicker({
        minDate: 0,
        dateFormat: 'dd MM, yy'
    });

    /*------------------
		Nice Select
	--------------------*/
    $("select").niceSelect();

})(jQuery);