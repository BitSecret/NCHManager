function setData(){
    var user_id = $("#user_id").html().toString();
    var data = new FormData();
    data.set('user_id', user_id);

    $.ajax({
        type:"post",    //使用了表单提交数据，必须用post或put方法
        url: "data_api/getUserInfo",
        data: data,
        cache: false,
        processData: false,
        contentType: false,
        success: function (res) {
            $("#username").attr("value", res.username);
            $("#input_user_id").attr("value", user_id);

            $("#resume").text(res.intro);
            $("#phone_number").attr("value", res.phoneNumber);
            $("#img").attr("src", res.photoPath);

            $("#department").val(res.department);
            $("#position").val(res.departmentPosition);
            $("#birthday").attr("value", res.birthday);
        }
    });
}


$(function () {
    $("#menu_my").attr("class", "nav-item has-treeview menu-open");    //设置左侧菜单激活
    $("#personal_info").attr("class", "nav-link active");

    $("#page_h1").text("我的资料");    //设置page header 内容
    $("#page_h1_item").text("我的资料");
    $("#page_h1_menu").text("我的");

    $("#wrapper").attr("style", "display");    //页面加载完后显示页面

    setTimeout('setData()',100);
});


function save(){
    var username = $("#username").val();    //获取数据
    var userId = $("#input_user_id").attr("value");

    var intro = $("#resume").val();
    var phoneNumber = $("#phone_number").val();
    var photoPath = $("#img").attr("src");

    var department = $("#department").val();
    var departmentPosition = $("#position").val();
    var birthday = $("#birthday").val();

    var data = new FormData();    //装入表单
    data.set('username', username);
    data.set('userId', userId);
    data.set('intro', intro);
    data.set('phoneNumber', phoneNumber);
    data.set('photoPath', photoPath);
    data.set('department', department);
    data.set('departmentPosition', departmentPosition);
    data.set('birthday', birthday);

    $.ajax({
        url: '/data_api/saveUserInfo',    //put请求保存用户数据
        method: "put",
        data: data,
        cache: false,
        processData: false,
        contentType: false,
        success: function (res) {
            console.log(res);
            alert("保存成功");
            $("#login_img").attr("src", photoPath);    //更新用户小头像
        }
    });

    return false;
}


$('#img_path').change(function(){    //用户上传头像到服务器

    var files = $('#img_path').prop('files');
    var data = new FormData();
    data.set('file', files[0]);

    $.ajax({
        type: 'post',    //使用了表单提交数据，必须用post方法
        url: "data_api/upload",
        data: data,
        cache: false,
        processData: false,
        contentType: false,
        success: function (ret) {
            $("#img").attr("src", ret);    //更新页面头像
        }
    });
});


