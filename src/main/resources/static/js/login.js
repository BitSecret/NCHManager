function onSignButtonClicked() {
    var account = $("#account").val();
    var password = $("#password").val();
    $.ajax({
        url: "/data_api/login",
        data: {"account": account, "password": password},
        method: "get",
        success: function (data) {
            console.log(data);
            if (data.code >= 0){
                window.location.href = "/home";
            }else {
                alert("验证失败，用户名或密码错误！");
            }
        }    //end of success
    });

    return false;    //表单的按钮要写成 onclick="return onSignButtonClicked()"    防刷新
}