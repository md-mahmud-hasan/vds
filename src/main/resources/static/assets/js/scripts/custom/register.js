$(document).ready(function () {

    $("#registration-form").on("submit",function (e) {
        e.preventDefault();
        let user = {};
        let regForm = $("#registration-form");
        // if (regForm.valid()){
            user.firstname=$("#firstname").val();
            user.lastname=$("#lastname").val();
            user.nid=$("#nid").val();
            user.email=$("#register-email").val();
            user.dob=$("#dob").val();
            user.password=$("#password").val();
            user.street = $("#street").val();
            user.city = $("#city").val();
            user.zip = $("#zip").val();
            user.country = $("#country").val();

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
        // }

        console.log(user)
    });



});
