$(document).ready(function() {

        fillUserTicketTable();
    }
);

function fillUserTicketTable() {

    var userSSO = $('#userSSO').val();

    var json = "/getTicketsJSONByUserSSO?userSSO=" + userSSO;

    $.getJSON(json, function(data){

            $("#ticketTable td").remove();

            $.each(data, function (index, value) {

                var htmlrow ="<tr>" +
                    "<td>" + value.ticketId + "</td>" +
                    "<td>" + value.plasesNumber + "</td>" +
                    "<td>" + value.trainNumber + "</td>" +
                    "<td>" + value.destinationStation + "</td>" +
                    "<td>" + value.departureStation + "</td>" +
                    "<td>" + value.departureTime.replace("T"," ").replace("Z"," ") + "</td>" +
                    "<td>" + value.destinationTime.replace("T"," ").replace("Z"," ") + "</td>" +
                    "<tr>";

                $('#ticketTable').append(htmlrow);
            });
        }
    );

}