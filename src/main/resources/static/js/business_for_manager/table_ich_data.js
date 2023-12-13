layui.use('layer', function(){
    var layer = layui.layer;
});

function ViewById(ichId){    //每行小图标查看
    layer.open({
        area: ['600px', '520px'],
        type: 2,
        title: "查看非遗详情",
        content: "table_ich_dataOp/view/" + ichId
    });
}

function DeleteById(ichId) {    //每行小图标删除
    if (confirm("是否删除？")){
        $.ajax({
            url: "/data_api/deleteICHInfoById/" + ichId,
            method: 'delete' ,
            success: function () {
                alert("删除成功!");
                $("#users").bootstrapTable('refresh');
            }
        })
    }
}

function EditById(ichId) {    //每行小图标修改
    layer.open({
        area: ['600px', '520px'],
        type: 2,
        title: "更新非遗信息",
        content: "table_ich_dataOp/update/" + ichId
    });
}

function addNew() {
    layer.open({
        area: ['600px', '520px'],
        type: 2,
        title: "新增非遗信息",
        content: "table_ich_dataOp/add"
    });
}

function getAndShowData(){
    function actionFormatter(value, row) {
        var ichId = row.ichId;
        var result = "";
        result += "<a href='javascript:;' class='btn btn-success btn-sm' onclick=\"ViewById('" + ichId + "')\" title='详情'></a>";
        result += "<a href='javascript:;' class='btn btn-primary btn-sm' onclick=\"EditById('" + ichId + "')\" title='编辑'></a>";
        result += "<a href='javascript:;' class='btn btn-danger btn-sm' onclick=\"DeleteById('" + ichId + "')\" title='删除'></a>";
        return result;
    }
    $("#data_table").bootstrapTable({
        method: 'get',    // 服务器数据的请求方式 get or post
        url: "data_api/getIchInfo",    // 服务器数据的加载地址
        striped: true,    //是否显示行间隔色
        cache: false,    //是否使用缓存，默认为true
        pagination: true,    //是否显示分页
        sortable: false,    //是否启用排序，不启用快一点
        columns: [{
            checkbox: true
        }, {
             field: 'ichId',
             title: 'ID'
            },{
                field: 'grade',
                title: '级别'
            }, {
                field: 'batch',
                title: '批次'
            }, {
                field: 'level1Number',
                title: '一级编号'
            }, {
                field: 'level2Number',
                title: '二级编号'
            }, {
                field: 'name',
                title: '名称'
            }, {
                field: 'category',
                title: '类别'
            }, {
                field: 'intro',
                title: '简介'
            }, {
                field: 'location',
                title: '地区'
            }, {
                field: 'nation',
                title: '民族'
            }, {
                field: 'inheritor',
                title: '继承人'
            }, {
                title: '操作(详情/编辑/删除)',
                align: 'center',
                valign: 'middle',
                formatter: actionFormatter
            }
        ]
    });
}


$(function () {
    $("#menu_business_for_manager").attr("class", "nav-item has-treeview menu-open");    //设置左侧菜单激活
    $("#table_ich_data").attr("class", "nav-link active");

    $("#page_h1").text("非遗信息表");    //设置page header 内容
    $("#page_h1_item").text("非遗信息表");
    $("#page_h1_menu").text("业务办理");

    getAndShowData();    //向服务器请求数据

    $("#wrapper").attr("style", "display");    //页面加载完后显示页面
});


function batchRemove() {    //批量删除
    var rows = $("#data_table").bootstrapTable("getSelections");
    if (rows.length == 0){
        alert("请选择要删除的数据!");
    }
    else {
        if (confirm("是否删除已选中的" + rows.length + "条用户信息?")){
            for (var i = 0; i < rows.length; i++){
                $.ajax({
                    url: "/data_api/deleteICHInfoById/" + rows[i].ichId,
                    method: 'delete'
                });
            }
            alert("删除成功!");
            $("#data_table").bootstrapTable('refresh');
        }
    }
}