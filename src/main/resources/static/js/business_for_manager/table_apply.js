$(function () {
    $("#menu_business_for_manager").attr("class", "nav-item has-treeview menu-open");    //设置左侧菜单激活
    $("#table_apply").attr("class", "nav-link active");


    $("#page_h1").text("非遗申请表");    //设置page header 内容
    $("#page_h1_item").text("非遗申请表");
    $("#page_h1_menu").text("业务办理");

    $("#wrapper").attr("style", "display");    //页面加载完后显示页面
});