$(function () {
    $("#menu_business_for_user").attr("class", "nav-item has-treeview menu-open");    //设置左侧菜单激活
    $("#apply_list").attr("class", "nav-link active");


    $("#page_h1").text("申请记录");    //设置page header 内容
    $("#page_h1_item").text("申请记录");
    $("#page_h1_menu").text("通用");

    $("#wrapper").attr("style", "display");    //页面加载完后显示页面
});