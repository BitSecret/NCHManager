$(function () {
    var url = window.location.href;    //网址

    var urlSplit = url.split("/");
    var userId = urlSplit[urlSplit.length - 1];
    console.log(userId);
    $.ajax({
        url: "/data_api/getIchInfoByIchId/" + userId,
        method: "get",
        success: function (rs) {
            $("#ichId").val(rs.ichId);
            $("#grade").val(rs.grade);
            $("#batch").val(rs.batch);
            $("#level1Number").val(rs.level1Number);
            $("#level2Number").val(rs.level2Number);
            $("#name").val(rs.name);
            $("#category").val(rs.category);
            $("#intro").val(rs.intro);
            $("#location").val(rs.location);
            $("#nation").val(rs.nation);
            $("#birthday").val(rs.birthday);
            $("#inheritor").val(rs.inheritor);
        }
    })
});



function onSubmitButtonClicked() {
    var data = $("#dataForm").serialize();

    $.ajax({
        url: '/data_api/saveIchInfo',
        method: "post",
        contentType: "application/x-www-form-urlencoded",
        data: data,
        success: function (res) {
            if (res.code >= 0){
                parent.layer.closeAll();
                parent.$("#data_table").bootstrapTable('refresh');
            }
            else {
                alert("更新失败！");
            }
        }
    });

    return false;
}