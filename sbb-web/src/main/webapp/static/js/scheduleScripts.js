
var freeTicketData;
var headerName;
var csrfToken;

$(document).ready(function() {

        headerName = $("#headerName").val();
        csrfToken = $("#csrfToken").val();

        $('#toFind').click(
            function () {
                fillScheduleTable();
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
            setTimeout(markFreeSite, 500, $(this).val(), $(this).attr("routeId"), $(this).attr("departureTimeInFormat"), $(this).attr("destinationTimeInFormat"));

        }
    );
}

function fillScheduleTable() {

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

    var json = "/getScheduleJSON?st1=" + st1 + "&st2=" + st2 + "&date1=" + date1 + "&date2=" + date2 + "";

    $.getJSON(json, function(data){

            $("#scheduleTable td").remove();

            $.each(data, function (index, value) {

                var htmlrow ="<tr>" +
                    "<td> <input id = 'dirRadio'" + value.dirId + " type='radio' name='dirRadio' routeId = " + value.routeId + " destinationTimeInFormat = " + value.destinationTimeInFormat.replace(" ","_") + " departureTimeInFormat = " + value.departureTimeInFormat.replace(" ","_") + " value='" + value.dirId + "'> </td>" +
                    "<td>" + value.trainNumber + "</td>" +
                    "<td>" + value.routeNumber + " " + value.routeName + "</td>" +
                    "<td>" + value.departureTimeInFormat + "</td>" +
                    "<td>" + value.destinationTimeInFormat+ "</td>" +
                    "<td>" + value.numberOfStation + "</td>" +
                    "<td>" + value.ticketsCount + "</td>" +
                    "<tr>";

                $('#scheduleTable').append(htmlrow);
            });
        }
    );
}

function includeMaps(dirId,routeId) {

    var st1 = $('#station1').val();
    var st2 = $('#station2').val();

    $("#imapcs").remove();
    $("#choosed").remove();
    $("#btnBuy").remove();

    $("#btns").append("<div id='choosed'></div> <div id='btnBuy'></div>");

    var json = "/getFreeTicket?st1=" + st1 + "&st2=" + st2 + "&dirId=" + dirId + "&routeId=" + routeId + "";//qqqqqqqqq localhost
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

function markFreeSite(dirId,routeId,departureTimeInFormat,destinationTimeInFormat) {

    var st1 = $('#station1').val();
    var st2 = $('#station2').val();
    var selectedCar = 0;
    var userName = $('#userName').val();

    $.each(freeTicketData, function (index, value) {
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
                    document.getElementById('choosed').innerHTML = '<h4>Selected plase: ' + id.replace("s","") + " car № " + carNumber + "</h4>";

                    // btnRef = "/buyTicket?st1=" + st1 + "&st2=" + st2 + "&dirId=" + dirId
                    //     + "&carId=" + carNumber + "&siteId="+ id.replace("s","") + "&userName=" + userName
                    //     + "&desTime=" + destinationTimeInFormat + "&depTime=" + departureTimeInFormat ;
                    //
                    // var btnBuy = "<a href=" + btnRef + " class='btn btn-success'>to buy ticket</a>";

                    var siteId = id.replace("s","");

                    var btnBuy = "<button id='buttonBuy' type='button' class='btn btn-success' st1='" + st1 + "' st2='" + st2 + "' dirId='" + dirId + "' carNumber='" + carNumber
                        + "' siteId='" + siteId + "' userName='" + userName + "' desTime='" + destinationTimeInFormat + "' depTime='" + departureTimeInFormat + "'>to buy ticket</button>";

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

                    setTimeout(addBtnBuyClicks,10);
                }
            );
        }
    });
}


function addBtnBuyClicks() {


    $('body').off('click', '[id="buttonBuy"]');
    $('body').on('click', '[id="buttonBuy"]', function() {

        var st1 = $(this).attr("st1");
        var st2 = $(this).attr("st2");
        var dirId = $(this).attr("dirId");
        var carNumber = $(this).attr("carNumber");
        var siteId = $(this).attr("siteId");
        var userName = $(this).attr("userName");
        var destinationTimeInFormat = $(this).attr("desTime");
        var departureTimeInFormat = $(this).attr("depTime");

        var jsonOb = {};
        jsonOb["st1"] = st1;
        jsonOb["st2"] = st2;
        jsonOb["dirId"] = dirId;
        jsonOb["carNumber"] = carNumber;
        jsonOb["siteId"] = siteId;
        jsonOb["userName"] = userName;
        jsonOb["destinationTimeInFormat"] = destinationTimeInFormat;
        jsonOb["departureTimeInFormat"] = departureTimeInFormat;

        var search = {};
        search["text"] = JSON.stringify(jsonOb);

        $.ajax({
                type: "POST",

                beforeSend: function (xhr) {
                    xhr.setRequestHeader(headerName, csrfToken);
                },

                contentType: "application/json",
                url: "/buyTicket",
                data: JSON.stringify(search),
                success: function (data) {

                    if(data=="Ticket purchased"){
                        alert(data);
                        window.location.replace("/myTickets");
                    }else {
                        alert(data);
                    }
                }
                ,
                error: function (error) {
                    alert("Ticket is not purchased");
                }
            })

        }
    );
}