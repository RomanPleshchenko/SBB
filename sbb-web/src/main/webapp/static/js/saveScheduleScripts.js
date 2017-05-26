
var freeTicketData;
var headerName;
var csrfToken;

$(document).ready(function() {

        addComposeFreeClicks();

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

function addComposeFreeClicks() {

    $('body').off('click', '[id="addRow"]');

    $('body').off('click', '[value="compose"]');
    $('body').on('click', '[value="compose"]', function() {

            var ScheduleId = $(this).attr("id");
            var search = {};
            search["text"] = ScheduleId.replace("compose","");

            $.ajax({
                type : "POST",

                beforeSend: function(xhr){
                    xhr.setRequestHeader(headerName, csrfToken);
                },

                contentType : "application/json",
                url : "/composeFreeSitesByScheduleId",
                data : JSON.stringify(search),

                success : function(data) {
                    alert(data);

                    if(data=="Sites composed"){
                        window.location.replace("/schedule");
                    }else {
                        alert("error")
                    }
                }
                ,
                error : function(error) {
                    alert("Error");
                }
            });
        }
    );
}