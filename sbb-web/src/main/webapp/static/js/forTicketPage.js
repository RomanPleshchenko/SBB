$(document).ready(function() {

        $('#toShow').click(
            function () {
                fillTicketTable();
            }
        );
    }
);

function fillTicketTable() {

    var trainId = $('#train').val();

    var json = "http://localhost:8080/getTicketsJSON?trainId=" + trainId;

    $.getJSON(json, function(data){

            $("#ticketTable td").remove();

            $.each(data, function (index, value) {

                var htmlrow ="<tr>" +
                    "<td>" + value.ticketId + "</td>" +
                    "<td>" + value.trainNumber + "</td>" +
                    "<td>" + value.destinationStation + "</td>" +
                    "<td>" + value.departureStation + "</td>" +
                    "<td>" + value.destinationTime.replace("T"," ").replace("Z"," ") + "</td>" +
                    "<td>" + value.departureTime.replace("T"," ").replace("Z"," ") + "</td>" +
                    "<td>" + value.passenger + "</td>" +
                    "<tr>";

                $('#ticketTable').append(htmlrow);
            });
        }
    );


}