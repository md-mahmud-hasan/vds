$(document).ready(function () {

    $(".nxt-btn").on("click",function (e) {
        let thisElem=$(this);
        let applyData = {};
        applyData.emergencyContact = $("#emergency-contact").val();
        applyData.boothId = $("#center").val();
        applyData.step = 1;

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

