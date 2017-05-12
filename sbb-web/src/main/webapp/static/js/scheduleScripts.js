
var freeTicketData;

$(document).ready(function() {

        $('#toFind').click(
            function () {
                searchAjax();
                $("#imapcs").remove();
                setTimeout(addClicks,500);
            }
        );
    }
);

function addClicks() {


    $('body').off('click', '[name="dirRadio"]');
    $('body').on('click', '[name="dirRadio"]', function() {
            includeMaps($(this).val(),$(this).attr("routeId"));
            setTimeout(markFreeSite,500,$(this).val(),$(this).attr("routeId"));
        }
    );
}

function searchAjax() {

    var st1 = $('#station1').val();
    var st2 = $('#station2').val();
    var date1 = $('#data1').val();
    var date2 = $('#data2').val();
    var selectedCar;
    var selectedSite;


    if(st1 == "NONE"||st2 == "NONE"){
        alert("You mast choose some station");
        return;
    }

    if(date1 == ""||date1 == ""){
        alert("You mast choose some date");
        return;
    }

    var json = "http://localhost:8080/getScheduleJSON?st1=" + st1 + "&st2=" + st2 + "&date1=" + date1 + "&date2=" + date2 + "";

    $.getJSON(json, function(data){

        $("#scheduleTable td").remove();

        $.each(data, function (index, value) {

            if(value.active == "true"){
                var actionBtn= "<a href=\"<c:url value='/make-active-dir-${dir.id}' />\" class=\"btn btn-success\">make active</a>";
            }else {
                var actionBtn= "<a href=\"<c:url value='/make-not-active-dir-${dir.id}' />\" class=\"btn btn-danger\">make not active</a>";
            }

            var htmlrow ="<tr>" +
                "<td> <input id = 'dirRadio'" + value.dirId + " type='radio' name='dirRadio' routeId = " + value.routeId + " value='" + value.dirId + "'> </td>" +
                "<td>" + value.trainNumber + "</td>" +
                "<td>" + value.routeNumber + " " + value.routeName + "</td>" +
                "<td>" + value.departureTimeInFormat + "</td>" +
                "<td>" + value.destinationTimeInFormat + "</td>" +
                "<td>" + value.numberOfStation + "</td>" +
                "<td>" + actionBtn + "</td>" +
                "<td>" + value.ticketsCount + "</td>" +
                "<tr>";

            $('#scheduleTable').append(htmlrow);
        });
    });
}

function includeMaps(dirId,routeId) {

    var st1 = $('#station1').val();
    var st2 = $('#station2').val();

    $("#imapcs").remove();

    var json = "http://localhost:8080/getFreeTicket?st1=" + st1 + "&st2=" + st2 + "&dirId=" + dirId + "&routeId=" + routeId + "";//qqqqqqqqq localhost
    $.getJSON(json, function(data){
            freeTicketData = data;

            var htmlrow = "";

            $.each(data, function (index, value) {

                    var svgName = value.carSvgFileName;
                    var carNumber = value.carNumber;
                    var countFree = value.freeSitesArray.length;
                    htmlrow = htmlrow + "<figure id=\"imapc" + carNumber + "\">\n" +
                        "    <figcaption><h4>Car №" + carNumber + "  " + countFree + " free plases" + "</figcaption></h4> \n" +
                        "    <object data=\"/static/svg/" + svgName + ".svg\" type=\"image/svg+xml\" id=\"imap" + carNumber + "\">\n" +
                        "    </object>\n" +
                        "</figure>";
                }
            );

            $('#imaps').append("<div id = 'imapcs'>" + htmlrow + "</div>");
        }

    );
}

function markFreeSite(dirId,routeId) {

    var st1 = $('#station1').val();
    var st2 = $('#station2').val();
    var selectedCar = 0;
    var userName = $('#userName').val();

    $.each(freeTicketData, function (index, value) {
        // $.each(data, function (index, value) {
        var carNumber = value.carNumber;
        var svgobject = document.getElementById('imap' + carNumber);
        if ('contentDocument' in svgobject){

            var svgdom = svgobject.contentDocument;
            $.each(value.freeSitesArray, function (index, siteVal) {
                svgdom.getElementById("s" + siteVal).setAttribute("class","area");
            });

            $(svgdom.getElementsByClassName("area")).click(
                function () {
                    var id = $(this).attr("id");
                    document.getElementById('choosed').innerHTML = 'Selected plase: ' + id.replace("s","") + " car № " + carNumber;

                    btnRef = "/buyTicket?st1=" + st1 + "&st2=" + st2 + "&dirId=" + dirId
                        + "&carId=" + carNumber + "&siteId="+ id.replace("s","") + "&userName=" + userName;

                    var btnBuy = "<a href=" + btnRef + " class=\"btn btn-success\">to buy ticket</a>";

                    document.getElementById('btnBuy').innerHTML = btnBuy;

                    var height= $("body").height();
                    $("html,body").animate({"scrollTop":height},1000);

                    if(selectedCar!=0){
                        var elArr = document.getElementById('imap' + selectedCar).contentDocument.getElementsByClassName("selected");
                        $.each(elArr, function (index, el) {
                            el.setAttribute("class","area");
                        });
                    }
                    selectedCar = carNumber;
                    svgdom.getElementById(id).setAttribute("class","selected");
                }
            );
        }
    });
}