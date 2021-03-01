$(document).ready(function () {

    $(".nxt-btn").on("click",function (e) {
        let thisElem=$(this);
        let applyData = {};
        let step = $(this).attr("data-step");
        applyData.step = step;
        if(step==1){
            applyData.boothId = $("#center").val();
            applyData.emergencyContact = $("#emergency-contact").val();
        }
        else if (step==2){

        }
        else if (step==3){

        }

        $.ajax({
            data:JSON.stringify(applyData),
            url:"/api/v1/apply",
            contentType: 'application/json',
            method:"post",
            success:function (res, textStatus, xhr) {
                thisElem.closest("li").find(".timeline-point").addClass("completed-step");
            }
        });
    });


});

