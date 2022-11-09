/* 식당 추가 */
function getAddRestaurantForm() {
    let length = $('#restaurant-table > thead > tr > th').length;
    $('#restaurant-table > thead > tr > th').eq(0).html('<input name="restaurant-name" placeholder="식당 이름">');
    $('input[name=restaurant-name]').focus();
    $('#restaurant-table > thead > tr > th').eq(length - 3).css('display', 'none');
    $('#restaurant-table > thead > tr > th').eq(length - 2).css('display', 'table-cell');
    $('#restaurant-table > thead > tr > th').last().css('display', 'table-cell');
}


function addRestaurant() {
    let restaurantName = $('input[name=restaurant-name]').val();
    let data = {"restaurantName": restaurantName};
    $.ajax({
        url: "/restaurant/add",
        type: "post",
        data: data,
        // data: JSON.stringify(data),
        // dataType: "json",
        success: function () {
            getRestaurantPage();
        },
        error: function () {
            console.log("error");
        }
    })
}

/* 식당 리스트 */
function getRestaurantList() {
    $.ajax({
        url: "/restaurant/list",
        success: function (data) {
            let str = "";
            for (let idx in data) {
                console.log(data[idx]);
                str += "<tr>";
                str += "<td>" + data[idx].restaurantName + "</td>";
                str += "<td>" + data[idx].restaurantName + "</td>";
                str += "</tr>";
            }
            $('#restaurant-table > tbody').html(str);
        },
        error: function () {
            console.log("error");
        }
    })
}