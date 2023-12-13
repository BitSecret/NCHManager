$(function () {
    $("#menu_general").attr("class", "nav-item has-treeview menu-open");    //设置左侧菜单激活
    $("#menu_general_home").attr("class", "nav-link active");

    $("#page_h1").text("首页");    //设置page header 内容
    $("#page_h1_item").text("首页");
    $("#page_h1_menu").text("通用");

    initData();    //初始化页面数据

    $("#wrapper").attr("style", "display");    //页面加载完后显示页面
});


function initData() {    //初始化页面数据
    //slide图片
    $('#slide1').attr("src", "img/home_slide1.jpg");
    $('#slide2').attr("src", "img/home_slide2.jpg");
    $('#slide3').attr("src", "img/home_slide3.jpg");


    //图表数据
    //- DONUT CHART
    var donutChartCanvas = $('#donutChart').get(0).getContext('2d');
    var donutData        = {
        labels: [
            '第一批',
            '第二批',
            '第三批',
            '第四批',
            '第五批',
            '第六批'
        ],
        datasets: [
            {
                data: [62,97,119,109,123,205],
                backgroundColor : ['#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc', '#d2d6de'],
            }
        ]
    };
    var donutOptions     = {
        maintainAspectRatio : false,
        responsive : true
    };
    var donutChart = new Chart(donutChartCanvas, {
        type: 'doughnut',
        data: donutData,
        options: donutOptions
    });

    //- PIE CHART -
    var pieChartCanvas = $('#pieChart').get(0).getContext('2d');
    var pieData        = {
        labels: [
            '传统技艺',
            '传统美术',
            '传统体育、游艺与杂技',
            '传统舞蹈',
            '传统戏剧',
            '传统医药',
            '传统音乐',
            '民间文学',
            '民俗',
            '曲艺'

        ],
        datasets: [
            {
                data: [271,61,33,56,29,45,107,32,64,18],
                backgroundColor : ['#f571c1', '#a65a59', '#eff37a', '#ef7549', '#1abc91',
                    '#f50502', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc']
            }
        ]
    };
    var pieOptions     = {
        maintainAspectRatio : false,
        responsive : true
    };
    var pieChart = new Chart(pieChartCanvas, {
        type: 'pie',
        data: pieData,
        options: pieOptions
    });
}