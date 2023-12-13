$(function () {
    $("#menu_business_for_investigator").attr("class", "nav-item has-treeview menu-open");    //设置左侧菜单激活
    $("#investigate_list").attr("class", "nav-link active");

    $("#page_h1").text("审批非遗申请");    //设置page header 内容
    $("#page_h1_item").text("审批非遗申请");
    $("#page_h1_menu").text("业务办理");

    $("#wrapper").attr("style", "display");    //页面加载完后显示页面
});