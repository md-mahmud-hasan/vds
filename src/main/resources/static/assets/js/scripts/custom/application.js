$(document).ready(function () {

    $(".nxt-btn").on("click", function (e) {
        let thisElem = $(this);
        let applyData = new FormData();
        let step = $(this).attr("data-step");
        applyData.append("step", step);
        if (step == 1) {
            applyData.append("boothId", $("#center").val());
            applyData.append("emergencyContact", $("#emergency-contact").val());
        } else if (step == 2) {
            applyData.append("file", $("#customFile")[0].files[0]);
        } else if (step == 3) {

        }

        $.ajax({
            url: "/api/v1/apply",
            type : 'POST',
            data : applyData,
            processData: false,
            contentType: false,
            success: function (res, textStatus, xhr) {
                thisElem.closest("li").find(".timeline-point").addClass("completed-step");
            }
        });
    });


});

