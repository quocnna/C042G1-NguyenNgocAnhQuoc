$(document).ready(function () {
    $(".edit").click(function () {
        $(".modal-title").text("Edit User");
        $("input[name='id']").val($(this).data("id"));
        $("input[name='name']").val($(this).data("name"));
        $("input[name='email']").val($(this).data("email"));
        $("input[name='country']").val($(this).data("country"));
    });

    $(".add").click(function(){
        $("#addEditModal").modal('show');
        $(".modal-title").text("Add User");
        $("input[name='name'],input[name='email'],input[name='country']").val("");
    });

    $(".delete").click(function () {
        $("input[name='id']").val($(this).data("id"));
    });
});