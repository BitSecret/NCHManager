$(function () {
    $.ajax({
        url:"/data_api/initPageMsg",
        type:"get",
        success:function (data) {
            var photoPath = data.photoPath;
            var privateMsgCount = data.privateMsgCount;
            var publicMsgCount = data.publicMsgCount;
            var status = data.statusCode;
            var userId = data.userId;
            var username = data.username;

            if (status == 0){    //游客

                $("#menu_my").remove();    //移除菜单
                $("#menu_msg").remove();
                $("#menu_business_for_user").remove();
                $("#menu_business_for_investigator").remove();
                $("#menu_business_for_manager").remove();

                $("#after_login_div").remove();    //移除用户登录状态

                $("#msg_hint").remove();    //移除顶部菜单栏消息通知

            }
            else if (status == 1){    //user
                $("#user_id").text(userId);    //记录userId

                $("#menu_msg_publicMsg").remove();    //移除菜单
                $("#menu_msg_publicMsgList").remove();
                $("#menu_business_for_investigator").remove();
                $("#menu_business_for_manager").remove();

                $("#before_login_div").remove();    //移除未登录状态

                $("#message_and_notice_count").text(privateMsgCount + publicMsgCount);    //设置消息
                $("#message_count").text(privateMsgCount);
                $("#notice_count").text(publicMsgCount);

                $("#login_img").attr("src", photoPath);    //设置用户头像
                $("#login_href").text(username + "@User");    //设置姓名

            }
            else if (status == 2){    //staff
                $("#user_id").text(userId);    //记录userId

                $("#menu_business_for_user").remove();    //移除菜单
                $("#menu_business_for_manager").remove();

                $("#before_login_div").remove();    //移除未登录状态

                $("#message_and_notice_count").text(privateMsgCount + publicMsgCount);    //设置消息
                $("#message_count").text(privateMsgCount);
                $("#notice_count").text(publicMsgCount);

                $("#login_img").attr("src", photoPath);    //设置用户头像
                $("#login_href").text(username + "@Staff");
            }
            else {                       //manager
                $("#user_id").text(userId);    //记录userId

                $("#menu_business_for_user").remove();    //移除菜单
                $("#menu_business_for_investigator").remove();

                $("#before_login_div").remove();    //移除未登录状态

                $("#message_and_notice_count").text(privateMsgCount + publicMsgCount);    //设置消息
                $("#message_count").text(privateMsgCount);
                $("#notice_count").text(publicMsgCount);

                $("#login_img").attr("src", photoPath);    //设置用户头像
                $("#login_href").text(username + "@Manager");
            }

        }
    });
});

function loginIn() {
    window.location.href = "/login";
    return false;
}

function loginOut() {
    $.ajax({
        url: "/data_api/loginOut",
        data: {},
        method: "get",
        success: function (data) {
            console.log(data);
            if (data.code >= 0){
                window.location.href = "/login";
            }else {
                alert(data.message);
            }
        }    //end of success
    });
    return false;
}