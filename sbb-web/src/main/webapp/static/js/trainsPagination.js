$(document).ready(function() {

    $("#stationsList").dataTable( {
        "bProcessing": true,
        "bServerSide": true,
        "sort": "position",
        //bStateSave variable you can use to save state on client cookies: set value "true"
        "bStateSave": false,
        //Default: Page display length
        "iDisplayLength": 10,
        //We will use below variable to track page number on server side(For more information visit: http://legacy.datatables.net/usage/options#iDisplayStart)
        "iDisplayStart": 0,
        "fnDrawCallback": function () {
        },
        "sAjaxSource": "getStationslist",
        "aoColumns": [
            { "mData": "name" },
        ]
    } );

} );