var headerName;
var csrfToken;

$(document).ready(function() {

        headerName = $("#headerName").val();
        csrfToken = $("#csrfToken").val();

        fillCarsTable();
        addSaveNewCarClicks();

    }
);

function addSaveNewCarClicks() {

    $('#SaveNewCar').click(
        function () {

            var carsNumber = $('#carsNumber').val();
            var carsClassId = $('#carsClassId').val();
            saveCar(carsNumber,carsClassId);
        }
    );
}

function saveCar(carsNumber,carsClassId) {

    if(carsNumber==""||carsClassId==""){
        alert("You must enter all fields");
    }else{

        var jsonOb = {};
        jsonOb["carsNumber"] = carsNumber;
        jsonOb["carsClassId"] = carsClassId;

        var search = {};
        search["text"] = JSON.stringify(jsonOb);

        $.ajax({
            type : "POST",

            beforeSend: function(xhr){
                xhr.setRequestHeader(headerName, csrfToken);
            },

            contentType : "application/json",
            url : "/saveNewCar",
            data : JSON.stringify(search),

            success : function(data) {
                alert(data);

                if(data=="Car saved"){
                    window.location.replace("/cars");
                }
            }
            ,
            error : function(error) {
                alert("Train is not saved");
            }
        });
    }
}

function fillCarsTable() {

    var json = "/getAllCarsJSON";

    $.getJSON(json, function(data){

            $("#carsTable td").remove();

            $.each(data, function (index, value) {

                var htmlrow ="<tr id = tr" + value.carId + ">" +
                    "<td>" + value.number + "</td>" +
                    "<td>" + value.capacity + "</td>" +
                    "<td>" + value.carsClass + "</td>" +
                    "<td><button id = del" + value.carId + " name = 'delBtn' class='btn btn-danger'>delete</btn></td>";

                "<tr>";

                $('#carsTable').append(htmlrow);
                addDeleteClicks();
            });
        }
    );
}

function addDeleteClicks() {
    $('body').off('click', '[name="delBtn"]');
    $('body').on('click', '[name="delBtn"]', function() {

            var cId = $(this).attr("id").replace("del","");

            var search = {};
            search["text"] = cId;

            $.ajax({
                type: "POST",

                beforeSend: function (xhr) {
                    xhr.setRequestHeader(headerName, csrfToken);
                },

                contentType: "application/json",
                url: "/deleteCarById",
                data: JSON.stringify(search),
                success: function (data) {
                    alert("Car deleted");
                    $("#tr"+cId).remove();
                }
                ,
                error: function (error) {
                    alert("Car is not deleted");
                }
            })

        }
    );
}