$(function () {
    $("#menu_my").attr("class", "nav-item has-treeview menu-open");    //设置左侧菜单激活
    $("#change_password").attr("class", "nav-link active");


    $("#page_h1").text("修改密码");    //设置page header 内容
    $("#page_h1_item").text("修改密码");
    $("#page_h1_menu").text("我的");

    $("#wrapper").attr("style", "display");    //页面加载完后显示页面
});