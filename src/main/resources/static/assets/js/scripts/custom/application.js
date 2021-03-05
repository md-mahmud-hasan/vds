$(document).ready(function () {

    $(".nxt-btn").on("click", function (e) {
        let thisElem = $(this);
        let applyData = new FormData();
        let step = $(this).attr("data-step");
        let userStep = $('#user-step').val();
        // alert(userStep);
        let hasError = false;

        applyData.append("step", step);

        $('.error-msg').text('');
        $('.error-div').addClass('d-none');

        let errorMsg = '';

        if (step == 1) {

            let boothId = $("#center").val();
            let emergencyContact = $("#emergency-contact").val().replace(/\s+/g, '');

            if (boothId == '' || boothId == null) {
                $('#center').parent().parent().find('.error-msg').text('Required');
                hasError = true;
            }
            if (emergencyContact == '' || emergencyContact == null) {
                $('#emergency-contact').parent().parent().find('.error-msg').text('Required');
                hasError = true;
            }

            applyData.append("boothId", boothId);
            applyData.append("emergencyContact",  $("#emergency-contact").val());

        } else if (step == 2) {
            //do nothing
        } else if (step == 3) {

            if (userStep == 0) {
                hasError = true;
                $('.error-div').removeClass('d-none');
                $('.error-div').html('Set Location information required');
            } else {
                let customFile = $("#customFile")[0].files[0];

                if (customFile == '' || customFile == null) {
                    $('#customFile').parent().parent().find('.error-msg').text('Required');
                    hasError = true;
                }
                applyData.append("file", customFile);

            }

        } else if (step == 4) {

            if (userStep >= 3) {
                applyData.append("hasChronicDisease", $('input[name="cd"]:checked').val());
                applyData.append("hasHeartDisease", $('input[name="hf"]:checked').val());
                applyData.append("hasAllergy", $('input[name="al"]:checked').val());
                applyData.append("hasLungDisease", $('input[name="ld"]:checked').val());

                applyData.append("note", $('#otherDisease').val());

            } else {

                hasError = true;
                $('.error-div').removeClass('d-none');
                if (userStep == 0) {
                    errorMsg = 'Set Location information required <br> Upload Medical Report information required';
                }
                else if (userStep == 1 || userStep == 2) {
                    errorMsg = 'Upload Medical Report information required';
                }
                $('.error-div').html(errorMsg);

            }

        } else if (step == 5) {

            if (userStep >= 4) {

                let preferredAppointmentDate = $("#preferred-appointment-date").val();

                if (preferredAppointmentDate == '' || preferredAppointmentDate == null) {
                    $('#preferred-appointment-date').parent().parent().find('.error-msg').text('Required');
                    hasError = true;
                }
                applyData.append("preferredAppointmentDate", new Date(preferredAppointmentDate));

            } else {
                hasError = true;
                $('.error-div').removeClass('d-none');
                if (userStep == 0) {
                    errorMsg = 'Set Location information required <br> Upload Medical Report information required <br> Recent Health Status information required';
                }
                else if (userStep == 1 || userStep == 2) {
                    errorMsg = 'Upload Medical Report information required  <br> Recent Health Status information required';
                }
                else if (userStep == 3) {
                    errorMsg = 'Recent Health Status information required';
                }
                $('.error-div').html(errorMsg);
            }

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
                   alert('data saved successfully');
                   $('#user-step').val(step);
                }
            });
    });


});

