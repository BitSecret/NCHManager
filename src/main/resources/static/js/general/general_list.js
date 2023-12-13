$(function () {
    $("#menu_general").attr("class", "nav-item has-treeview menu-open");    //设置左侧菜单激活
    $("#menu_general_general_list").attr("class", "nav-link active");


    $("#page_h1").text("非遗列表");    //设置page header 内容
    $("#page_h1_item").text("非遗列表");
    $("#page_h1_menu").text("通用");

    $("#wrapper").attr("style", "display");    //页面加赞完后显示页面

    getAndShowData();    //请求和显示数据
});

function getAndShowData() {
    $.ajax({
        url: "/data_api/getIchInfo",
        method: "get",
        success: function (data) {
            var html = "";
            for (var i = 0; i < data.length; i++){
                html += "<tr>" +
                    "<td>" + data[i].ichId + "</td>" +
                    "<td>" + data[i].grade + "</td>" +
                    "<td>" + data[i].batch + "</td>" +
                    "<td>" + data[i].level1Number + "</td>" +
                    "<td>" + data[i].level2Number + "</td>" +
                    "<td>" + data[i].name + "</td>" +
                    "<td>" + data[i].category + "</td>" +
                    "<td>" + data[i].intro + "</td>" +
                    "<td>" + data[i].location + "</td>" +
                    "<td>" + data[i].nation + "</td>" +
                    "<td>" + data[i].inheritor + "</td>" +
                    "</tr>";
            }
            var dataTable = document.getElementById("data_body");
            dataTable.innerHTML = html;
            $("#example1").DataTable({    //page script
                "responsive": true,
                "autoWidth": false
            });
            $('#example2').DataTable({
                "paging": true,
                "lengthChange": false,
                "searching": false,
                "ordering": true,
                "info": true,
                "autoWidth": false,
                "responsive": true
            });
        }
    });
}