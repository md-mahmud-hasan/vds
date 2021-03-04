$(document).ready(function () {

    $(".nxt-btn").on("click", function (e) {
        let thisElem = $(this);
        let applyData = new FormData();
        let step = $(this).attr("data-step");
        let hasError = false;

        applyData.append("step", step);

        $('.error-msg').text('');
        if (step == 1) {
            // $('.vaccine-center').text('');
            // $('.emergency-contact').text('');

            let boothId = $("#center").val();
            let emergencyContact = $("#emergency-contact").val().replace(/\s+/g, '');

            if (boothId == '' || boothId == null) {
                $('#center').parent().parent().find('.error-msg').text('Required');
                // $('.vaccine-center').text('Required');
                hasError = true;
            }
            if (emergencyContact == '' || emergencyContact == null) {
                $('#emergency-contact').parent().parent().find('.error-msg').text('Required');
                // $('.emergency-contact').text('Required');
                hasError = true;
            }

            applyData.append("boothId", boothId);
            applyData.append("emergencyContact", emergencyContact);

        } else if (step == 2) {
            //do nothing
        } else if (step == 3) {

            let customFile = $("#customFile")[0].files[0];

            if (customFile == '' || customFile == null) {
                $('#customFile').parent().parent().find('.error-msg').text('Required');
                hasError = true;
            }
            applyData.append("file", customFile);

        } else if (step == 4) {
            applyData.append("hasChronicDisease",$('input[name="cd"]:checked').val());
            applyData.append("hasHeartDisease",$('input[name="hf"]:checked').val());
            applyData.append("hasAllergy",$('input[name="al"]:checked').val());
            applyData.append("hasLungDisease",$('input[name="ld"]:checked').val());

            applyData.append("note",$('#otherDisease').val());

        } else if (step == 5) {
            let preferredAppointmentDate = $("#preferred-appointment-date").val();

            if (preferredAppointmentDate == '' || preferredAppointmentDate == null) {
                $('#preferred-appointment-date').parent().parent().find('.error-msg').text('Required');
                hasError = true;
            }
            applyData.append("preferredAppointmentDate",new Date(preferredAppointmentDate));
        }

        console.log(hasError);
        if (hasError === false)
            $.ajax({
                url: "/api/v1/apply",
                type: 'POST',
                data: applyData,
                processData: false,
                contentType: false,
                success: function (res, textStatus, xhr) {
                    thisElem.closest("li").find(".timeline-point").addClass("completed-step");
                    setTimeout(function () {
                        toastr['success'](
                            'You have successfully logged in to Vuexy. Now you can start to explore!',
                            '👋 Welcome John Doe!',
                            {
                                closeButton: true,
                                tapToDismiss: false
                            }
                        );
                    }, 2000);
                }
            });
    });


});

