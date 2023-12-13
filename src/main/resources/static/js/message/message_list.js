$(function () {
    $("#menu_msg").attr("class", "nav-item has-treeview menu-open");    //设置左侧菜单激活
    $("#message").attr("class", "nav-link active");


    $("#page_h1").text("我的消息");    //设置page header 内容
    $("#page_h1_item").text("我的消息");
    $("#page_h1_menu").text("消息和通知");

    $("#wrapper").attr("style", "display");    //页面加载完后显示页面
});