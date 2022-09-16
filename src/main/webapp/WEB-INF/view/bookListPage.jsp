<%--
  Created by IntelliJ IDEA.
  User: 23781
  Date: 2022/9/2
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书列表</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css"/>
    <script src="../../static/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">
    <span style="float: right;font-size: 18px">当前管理员：${name}</span>
    <fieldset class="layui-elem-field layui-field-title red layui-font-green " style="margin-top: 30px;">
        <legend>图书信息</legend>
    </fieldset>
    <div class="layui-row">
        <div class="layui-col-md4 ">
            <label for="bname">搜索书名：</label>
            <input id="bname" type="text" name="bname" placeholder="书名/类型"
                   class="layui-input-inline layui-input" style="width: 50%">
            <label for="type" style="margin-left: 40px">图书类型：</label>
        </div>
        <div class="layui-input-inline layui-form">
            <select id="type" name="type" lay-verify="required">
                <option value="-1">请选择图书类型</option>
            </select>
        </div>
        <button id="search" type="button" class="layui-btn" style="margin-left: 40px">搜索</button>
        <div style="float: right">
            <div class="layui-btn-group">
                <button id="add" type="button" class="layui-btn">新增</button>
                <button id="edit" type="button" class="layui-btn">编辑</button>
                <button id="del" type="button" class="layui-btn">删除</button>
            </div>
        </div>
    </div>
    <div class="layui-row">
        <table id="book" lay-filter="test"></table>
    </div>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.use(['table', 'layer', 'form'], function () {
        var table = layui.table,
            layer = layui.layer,
            form = layui.form,
            $ = layui.jquery

        //数据表格渲染
        table.render({
            elem: '#book'
            , type: 'get'
            , id: 'tableId'
            , url: '/books'
            , cellMinWidth: 80
            , page: true
            , limit: 6
            , limits: [6, 12, 18]
            , cols: [[
                {type: 'checkbox', width: 50, fixed: 'left'},
                {type: 'numbers', title: '序号', align: 'center'},
                {field: 'bno', title: '书号', align: 'center', sort: 'true', width: 80},
                {field: 'bname', title: '书名', align: 'center', width: 200},
                {field: 'author', title: '作者', align: 'center'},
                {field: 'press', title: '出版社', align: 'center'},
                {field: 'pubdate', title: '出版日期', align: 'center', sort: 'true'},
                {field: 'bnums', title: '数量', align: 'center', sort: 'true', width: 80},
                {field: 'price', title: '价格', align: 'center', sort: 'true', width: 80},
                {field: 'type', title: '类型', align: 'center', width: 80},
                {fixed: 'right', title: '操作', align: 'center', toolbar: '#barDemo', width: 120}
            ]]
        })

        //行内删除与编辑的实现
        table.on('tool(test)', function (obj) {
            console.log(obj)
            console.log(obj.data)
            console.log(obj.event)
            console.log(obj.data.bno)

            var data = obj.data
            var event = obj.event
            var bnos = data.bno

            // debugger
            //点击删除
            if (event == "del") {
                layer.confirm('真的删除吗？', function (index) {
                    obj.del();

                    $.ajax({
                        url: 'books?bnos=' + data.bno,
                        type: 'delete',
                        // contentType:'application/json',
                        // data: JSON.stringify(data.field),
                        // data: "bnos=" + data.bno,
                        success: function (msg) {
                            if (msg == "true") {
                                layer.msg("删除成功")
                            } else {
                                layer.msg("删除失败")
                            }
                        },
                        error: function () {
                            layer.msg("删除失败")
                        }

                    })

                    layer.close(index);
                })
                //点击修改
            } else if (event == "edit") {
                var bno = data.bno

                layer.open({
                    type: 2,
                    title: " 编辑图书信息",
                    content: '/pages/' + bno,
                    area: ['500px', '550px']
                })
            } else {
                console.log("工具栏出错")
            }
        })

        //搜索功能实现
        $("#search").click(function () {
            var bname = $("#bname").val()
            var type = $("#type").val()
            table.reload('tableId', {
                where: {bname:bname,type:type}
            })
        })

        //新增功能实现
        $("#add").click(function () {
            layer.open({
                type: 2,
                title: '添加图书',
                content: 'pages/add',
                area: ['500px', '550px']
            })
        })

        //删除功能实现
        $("#del").click(function () {
            var checkStatus = table.checkStatus('tableId'),
                data = checkStatus.data,
                bookId = ""

            if (data.length > 0) {
                for (var i in data) {
                    bookId += data[i].bno + ","
                }
                bookId = bookId.substring(0,bookId.length - 1)
                console.log(bookId)

                layer.confirm("确定删除所选信息？", function () {
                    $.ajax({
                        url: 'books?bnos=' + bookId,
                        type: 'delete',
                        async: true,
                        success: function (msg) {
                            if (msg == "true") {
                                layer.msg("删除成功")
                                table.reload('tableId')
                            } else {
                                layer.msg("删除失败")
                            }
                        },
                        error: function () {
                            layer.msg("删除失败")
                        }
                    })
                })
            } else {
                layer.msg("请选择要删除的对象")
            }
        })

        //编辑功能的实现
        $("#edit").click(function () {
            var checkStatus = table.checkStatus('tableId'),
                data = checkStatus.data

            if (data.length != 1) {
                layer.msg("请选择一个图书")
            } else {
                var bno = data[0].bno
                // console.log(bno);

                layer.open({
                    type: 2,
                    title: " 编辑图书信息",
                    content: '/pages/' + bno,
                    area: ['500px', '550px']
                })

            }
        })

        $.ajax({
            url: 'types',
            type: 'get',
            success: function (data) {
                // debugger
                $.each(data, function (i, type) {
                    var obj = $("<option value='" + type.tno + "'>" + type.type + "</option>")

                    $("#type").append(obj)

                })
                form.render()
            }
        })
    })
</script>
</body>
</html>
