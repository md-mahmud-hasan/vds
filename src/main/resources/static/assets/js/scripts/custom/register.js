$(document).ready(function () {

    $("#signup-btn").on("click",function (e) {
        e.preventDefault();
        let user = {};
        user.firstname=$("#firstname").val();
        user.lastname=$("#lastname").val();
        user.nid=$("#nid").val();
        user.email=$("#register-email").val();
        user.password=$("#password").val();

        $.ajax({
            data:JSON.stringify(user),
            url:"/api/v1/user",
            contentType: 'application/json',
            method:"post",
            success:function (res, textStatus, xhr) {
                if(xhr.status==200){
                    window.location.href="/login?registration=success";
                }
                else{
                    alert("something wrong");
                }
            }

        });

        console.log(user)
    });



});