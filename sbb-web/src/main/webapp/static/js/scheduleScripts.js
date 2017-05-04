/**
 * Created by РОМАН on 03.05.2017.
 */
$(document).ready(function() {

    $('#toFind').click(
        function () {
            searchAjax();
        }
    )});

function searchAjax() {

    var st1 = $('#station1').val();
    var st2 = $('#station2').val();
    var date1 = $('#data1').val();
    var date2 = $('#data2').val();

        if(st1 == "NONE"||st2 == "NONE"){
        alert("You mast choose some station");
        return;
    }

    if(date1 == ""||date1 == ""){
        alert("You mast choose some date");
        return;
    }

    $.getJSON("http://localhost:8080/getDataTest?st1=5&st2=8&date1=2017-04-01 03:00:00&date2=2017-05-04 03:00:00", function(data){

        $("#scheduleTable td").remove();

        $.each(data, function (index, value) {

            if(value.active == "true"){
                var btnRef= "<a href=\"<c:url value='/make-active-dir-${dir.id}' />\" class=\"btn btn-success\">make active</a>";
            }else {
                var btnRef= "<a href=\"<c:url value='/make-not-active-dir-${dir.id}' />\" class=\"btn btn-danger\">make not active</a>";
            }

            var htmlrow ="<tr>" +
                "<td>" + value.trainNumber + "</td>" +
                "<td>" + value.routeNumber + " " + value.routeName + "</td>" +
                "<td>" + value.departureTimeInFormat + "</td>" +
                "<td>" + value.destinationTimeInFormat + "</td>" +
                "<td>" + value.numberOfStation + "</td>" +
                "<td>" + btnRef + "</td>" +
                "<tr>";

            $('#scheduleTable').append(htmlrow);
        });
    });

}