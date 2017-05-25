
var freeTicketData;
var headerName;
var csrfToken;

$(document).ready(function() {



        $('#departureTime').datetimepicker();

        headerName = $("#headerName").val();
        csrfToken = $("#csrfToken").val();

        addSaveNewScheduleClick();
    }
);

function addSaveNewScheduleClick() {

    $('#saveNewSchedule').click(
        function () {

            var departureTime = $('#departureTime').val();

            if(departureTime==""){
                alert("You must cheat date")
            }

            departureTime = departureTime.replace("/","-").replace("/","-").replace(" ","T") + ":00.00Z";

            var routeId = $('#routeId').val();
            var trainId = $('#trainId').val();

            saveSchedule(routeId,trainId,departureTime);
        }
    );
}

function saveSchedule(routeId,trainId,departureTime) {

    if(routeId==""||trainId==""||departureTime==""){
        alert("You must enter all fields");
    }else{

        var jsonOb = {};
        jsonOb["routeId"] = routeId;
        jsonOb["trainId"] = trainId;
        jsonOb["departureTime"] = departureTime;

        var search = {};
        search["text"] = JSON.stringify(jsonOb);

        $.ajax({
            type : "POST",

            beforeSend: function(xhr){
                xhr.setRequestHeader(headerName, csrfToken);
            },

            contentType : "application/json",
            url : "/saveNewSchedule",
            data : JSON.stringify(search),

            success : function(data) {
                alert(data);

                if(data=="Schedule saved"){
                    window.location.replace("/schedule");
                }
            }
            ,
            error : function(error) {
                alert("Schedule is not saved");
            }
        });
    }
}