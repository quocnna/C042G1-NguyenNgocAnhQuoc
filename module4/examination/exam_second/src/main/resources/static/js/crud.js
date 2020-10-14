$.fn.toastr= function(type,msg){
        toastr.options = {
        "closeButton": false,
        "debug": false,
        "newestOnTop": false,
        "progressBar": false,
        "positionClass": "toast-top-full-width",
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "3000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }
    toastr[type](msg)
    };

$(document).ready(function(){
    var checkbox = $('table tbody input[type="checkbox"]');
    var checkboxArr=[];
    $("#selectAll").click(function(){
        if(this.checked){
            checkbox.each(function(){
                this.checked = true;
            });
        } else{
            checkbox.each(function(){
                this.checked = false;
            });
        }
    });
    checkbox.click(function(){
        if(!this.checked){
            $("#selectAll").prop("checked", false);
        }
    });

    $('.delAll').click(function () {
        checkbox.each(function(index){
            if(checkbox[index].checked){
                checkboxArr.push($(this).val());
            }
        });
        if(checkboxArr.length<=0){
            $(this).attr("href","#");
            $.fn.toastr("info","Please choose at least one to delete");
            return;
        }
        $(this).attr("href","#deleteModal");
        document.getElementById("hfDel").value=checkboxArr;
    });


    $(".delete").click(function () {
        $("input[name='id']").val($(this).data("id"));
    });


    $('.search-panel .dropdown-menu').find('a').click(function(e) {
        e.preventDefault();
        var concept = $(this).text();
        $('.search-panel span#search_concept').text(concept);
        $('.input-group #search_param').val(concept);
    });
});