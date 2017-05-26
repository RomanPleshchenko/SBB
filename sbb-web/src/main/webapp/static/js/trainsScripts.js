var lastRowId = 0;
var headerName;
var csrfToken;

$(document).ready(function() {
        headerName = $("#headerName").val();
        csrfToken = $("#csrfToken").val();
        addSaveTrainClicks();
        addRouteRadioClicks();
        addTrainsDeleteClicks();
    }
);

function saveTrain(trainsNumber) {

    if(trainsNumber==""){
        alert("You must enter a trains number");
    }else{

        var search = {};
        search["text"] = trainsNumber;

        $.ajax({
            type : "POST",

            beforeSend: function(xhr){
                xhr.setRequestHeader(headerName, csrfToken);
            },

            contentType : "application/json",
            url : "/saveTrain",
            data : JSON.stringify(search),

            success : function(data) {
                alert(data);

                if(data=="Train saved"){
                    window.location.replace("/trains");
                }
            }
            ,
            error : function(error) {
                alert("Train is not saved");
            }
        });
    }
}

function addSaveTrainClicks() {

    $('#saveTrain').click(
        function () {

            var trainsNumber = $('#trainsNumber').val();
            saveTrain(trainsNumber)

        }
    );
}

function addRouteRadioClicks() {

    $('body').off('click', '[name="trainRadio"]');
    $('body').on('click', '[name="trainRadio"]', function() {
            fillTrainsCompositionTable($(this).val());
        }
    );
}

function addTrainsDeleteClicks() {

    $('body').off('click', '[value="delete"]');
    $('body').on('click', '[value="delete"]', function() {

            var trainId = $(this).attr("id");
            var search = {};
            search["text"] = trainId.replace("del","");

            $.ajax({
                type : "POST",

                beforeSend: function(xhr){
                    xhr.setRequestHeader(headerName, csrfToken);
                },

                contentType : "application/json",
                url : "/deleteTrainByNumber",
                data : JSON.stringify(search),

                success : function(data) {
                    alert(data);

                    if(data=="Train deleted"){
                        window.location.replace("/trains");
                    }
                }
                ,
                error : function(error) {
                    alert("Train is not deleted");
                }
            });
        }
    );
}

function fillTrainsCompositionTable(trainId) {

    selectOptions = getSelectOptions();

    var json = "/trainIsEditable?trainId=" + trainId;
    $.getJSON(json, function(trainIsEditable) {

            var trainsJson = "/getTrainsCompositionJSONByTrainId?trainId=" + trainId;
            $.getJSON(trainsJson, function(carList){

                    $("#trainsCompositionTable td").remove();
                    $.each(carList, function (index, el) {

                            var select = selectOptions.replace("value='" + el.carId + "'"," selected  value='" + el.carId + "'");

                            var htmlrow ="<tr id = 'tr" + ++lastRowId + "'>"  +
                                "<td>" + select.replace("carId","carId" + lastRowId) + "</td>";

                            if(trainIsEditable){
                                htmlrow += "<td><button id = del" + lastRowId + " name = 'delBtn' class='btn btn-danger'>delete</btn></td>";
                            }

                            htmlrow += "<tr>";

                            $('#trainsCompositionTable').append(htmlrow);
                            addDeleteClicks();
                        }
                    );

                    if(trainIsEditable){
                        $("#btns").html("<button id = 'addRow' class='btn btn-success'>add row</button> <button id = 'confirm' class='btn btn-info'>confirm</button>");
                        setTimeout(addConfirmAndAddEowClicks,100,selectOptions,trainIsEditable,trainId);
                    }else{
                        $("#btns").html("");
                    }

                }
            );
        }
    );
}

function addConfirmAndAddEowClicks(selectOptions,trainIsEditable,trainId) {

    $('body').off('click', '[id="addRow"]');
    $('body').off('click', '[id="confirm"]');

    $('body').on('click', '[id="addRow"]', function() {

            var htmlrow ="<tr id = 'tr" + ++lastRowId + "'>"  +
                "<td>" + selectOptions.replace("carId","carId" + lastRowId) + "</td>";

            if(trainIsEditable){
                htmlrow += "<td><button id = del" + lastRowId + " name = 'delBtn' class='btn btn-danger'>delete</btn></td>";
            }

            htmlrow += "<tr>";

            $('#trainsCompositionTable').append(htmlrow);
            addDeleteClicks();
        }
    );

    $('body').on('click', '[id="confirm"]', function() {

            // чтение всех данных таблицы композиции
            var carArray = [];

            $('#trainsCompositionTable tr').each(function() {

                var cId = $(this).attr("id");
                if(cId!=undefined){
                    var id = cId.replace("tr","");

                    varCarId = $("#carId" + id).val();

                    if(varCarId!=undefined){
                        carArray.push({carId:varCarId});
                    }
                }
            });

            sendChoosedData(carArray,trainId)
        }
    );
}

function getSelectOptions() {

    var carsJson = "/getAllCarsJSON";    selectOptions = "<select id = stationId1> ";
    selectOptions = "<select id = carId> ";
    $.getJSON(carsJson, function(carsList){
            $.each(carsList, function (index, val) {
                    selectOptions += "<option value='" + val.carId + "'>" + val.car + "</option>\n"
                }
            );
            selectOptions+= " </select>";
        }
    );
    return selectOptions;
}

function sendChoosedData(carArray,trainId) {

    var jsonOb = {};
    jsonOb["carArray"] = carArray;
    jsonOb["trainId"] = trainId;

    var search = {};
    search["text"] = JSON.stringify(jsonOb);

    $.ajax({
        type: "POST",

        beforeSend: function (xhr) {
            xhr.setRequestHeader(headerName, csrfToken);
        },

        contentType: "application/json",
        url: "/sendTrainCompositionsJSON",
        data: JSON.stringify(search),
        success: function (data) {
            alert("All changes confirmed");
        }
        ,
        error: function (error) {
            alert("error:" + error);
        }
    })
}

function addDeleteClicks() {
    $('body').off('click', '[name="delBtn"]');
    $('body').on('click', '[name="delBtn"]', function() {
            var cId = $(this).attr("id").replace("del","");
            $("#tr"+cId).remove();
        }
    );
}
