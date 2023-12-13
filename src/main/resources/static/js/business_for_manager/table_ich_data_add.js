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
                alert("添加失败！");
            }
        }
    });

    return false;
}