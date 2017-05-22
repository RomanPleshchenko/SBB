var selectOptions = "";
var lastRowId = 0;
$(document).ready(function() {

        fillRoutesTable();
        setTimeout(addRouteRadioClicks,100);
    }
);

function fillRoutesTable() {

    var userSSO = $('#userSSO').val();

    var json = "/getRoutesJSON";

    //заполнение таблицы route
    $.getJSON(json, function(data){

            $("#routeTable td").remove();

            $.each(data, function (index, value) {

                var htmlrow ="<tr>" +
                    "<td> <input id = 'routeRadioId'" + value.routeId + " type='radio' name='routeRadio' value=' " + value.routeId + "'> </td>" +
                    "<td>" + value.routeId + "</td>" +
                    "<td>" + value.routeNumber + "</td>" +
                    "<td>" + value.routeName + "</td>" +
                    "<tr>";

                $('#routeTable').append(htmlrow);
            });
        }
    );

}

function fillRouteCompositionsTable(routeId) {

    var json = "/getRoutesCompositionJSONByRouteId?routeId=" + routeId;
    var StationsJson = "/getStationslistJSON";
    var routeIsEditableJson = "/routeIsEditable?routeId=" + routeId;

    routeIsEditable = false;

    $.getJSON(routeIsEditableJson, function(routeIsEditableJson){

            routeIsEditable = routeIsEditableJson;

            $("#attent").remove();
            $("#addRow").remove();
            $("#confirm").remove();

            $('body').off('click', '[id="addRow"]');
            $('body').off('click', '[id="confirm"]');

            if(routeIsEditable){
                $("#msg").append("<div id='attent'> <label>You can edit composition and click batton CONFIRM to save changes </label></div>");


                $("#btns").append("<button id = 'addRow' class='btn btn-success'>add row</button>");
                $("#btns").append("<button id = 'confirm' class='btn btn-info'>confirm</button>");

                //событие для добавления строки сразу с кнопкой удаления
                $('body').on('click', '[id="addRow"]', function() {
                        var htmlrow ="<tr id = 'tr" + ++lastRowId + "'>"  +
                            "<td>" + selectOptions.replace("stationId1","stationId1" + lastRowId) + "</td>" +
                            "<td>" + selectOptions.replace("stationId1","stationId2" + lastRowId) + "</td>" +
                            "<td><input id = depDate" + lastRowId + " value='0' </td>" +
                            "<td><input id = desDate" + lastRowId + " value='0' </td>" +
                            "<td><button id = del" + lastRowId + " name = 'delBtn' class='btn btn-danger'>delete</btn></td>" +
                            "<tr>";
                        $('#routeCompositionTable').append(htmlrow);
                        addClicksForCompositionsTable();
                    }
                );

                $('body').off('click', '[id="confirm"]');
                $('body').on('click', '[id="confirm"]', function() {

                        // чтение всех данных таблицы композиции
                        var table = $("#routeCompositionTable");

                        var rows = "";
                        $('#routeCompositionTable tr').each(function() {

                                var cId = $(this).attr("id");
                                if(cId!=undefined){
                                    var id = cId.replace("tr","");

                                    var depDate = $("#depDate" + id).val();
                                    if(depDate!=undefined){

                                        var desDate = $("#desDate" + id).val();
                                        var stationId1 = $("#stationId1" + id).val();
                                        var stationId2 = $("#stationId2" + id).val();

                                        rows += "{'st1':" + stationId1 + ",'st2':" + stationId2 + ",'t1':" + depDate + ",'t2':" + desDate + "},";
                                    }
                                }
                            }
                        );

                        //союираю JSON но с круглыми скобками чтобы отправить параметром гет запроса
                        rows = rows.substring(0, rows.length - 1)
                        var allJSON = "{'routeId':" + routeId + ",'arrayJSON':[" + rows + "]}";
                        //

                        var search = {};
                        search["allJSON"] = allJSON;

                        var headerName = $("#headerName").val();
                        var csrfToken = $("#csrfToken").val();

                        $.ajax({
                            type : "POST",

                            beforeSend: function(xhr){
                                xhr.setRequestHeader(headerName, csrfToken);
                            },

                            contentType : "application/json",
                            url : "/sendRouteCompositionsJSON",
                            data : JSON.stringify(search),
                            success : function(data) {
                                alert("All changes confirmed");
                            }
                            ,
                            error : function(error) {
                                console.log("ERROR: ", error);
                                console.log('request',qXHR);
                                console.log('status text', textStatus);
                                console.log(JSON.stringify(error));
                                alert(error);
                            }


                        });
                    }
                );

            }else{
                $("#msg").append("<div id='attent'> <label>You cannot edit composition</label></div>");
            }

        }
    );

    //полуим селект чтобы потом в каждой строке таблицы выбирать станции
    selectOptions = "<select id = stationId1> ";
    $.getJSON(StationsJson, function(stationsList){

            $.each(stationsList, function (index, val) {
                    selectOptions += "<option value='" + val.stationId + "'>" + val.stationName + "</option>\n"
                }
            );
            selectOptions+= " </select>";
        }
    );

    //Заполняет таблицу состава маршрута по данным бд
    $.getJSON(json, function(data){

            $("#routeCompositionTable td").remove();

            $.each(data, function (index, value) {

                var selectStation1 = selectOptions.replace("value='" + value.departureStationId + "'"," selected  value='" + value.departureStationId + "'");
                var selectStation2 = selectOptions.replace("value='" + value.destinationStationId + "'"," selected  value='" + value.destinationStationId + "'");

                var htmlrow ="<tr id = 'tr" + ++lastRowId + "'>"  +
                    "<td>" + selectStation1.replace("stationId1","stationId1" + lastRowId) + "</td>" +
                    "<td>" + selectStation2.replace("stationId1","stationId2" + lastRowId) + "</td>" +
                    "<td><input id = depDate" + lastRowId + " value='" + value.departureTime + "'</td>" +
                    "<td><input id = desDate" + lastRowId + " value='" + value.destinationTime + "'</td>";

                if(routeIsEditable){
                    htmlrow += "<td><button id = del" + lastRowId + " name = 'delBtn' class='btn btn-danger'>delete</btn></td>";
                }

                htmlrow += "<tr>";
                $('#routeCompositionTable').append(htmlrow);

                //добавим событие кнопки удаления строк
                addClicksForCompositionsTable();

            });
        }
    );

}

function addClicksForCompositionsTable() {
    $('body').off('click', '[name="delBtn"]');
    $('body').on('click', '[name="delBtn"]', function() {
            var cId = $(this).attr("id").replace("del","");
            $("#tr"+cId).remove();
        }
    );
}

function addRouteRadioClicks() {

    $('body').off('click', '[name="routeRadio"]');
    $('body').on('click', '[name="routeRadio"]', function() {
            fillRouteCompositionsTable($(this).val());
        }
    );
}

