<%--
  Created by IntelliJ IDEA.
  User: 23781
  Date: 2022/9/3
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑图书</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css"/>
    <script src="../../static/layui/layui.js"></script>
</head>
<body>
<div class="layui-container" style="width: 80%">

    <form id="bookForm" class="layui-form " action="" style="margin-top: 20px;">
        <div class="layui-form-item">
            <label class="layui-form-label">图书编号：</label>
            <div class="layui-input-inline">
                <input type="text" readonly name="bno" class="layui-input" value="${book.bno}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">书名：</label>
            <div class="layui-input-inline">
                <input type="text" name="bname" required placeholder="请输入书名" class="layui-input" value="${book.bname}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">作者：</label>
            <div class="layui-input-inline">
                <input type="text" name="author" required placeholder="请输入作者" class="layui-input"
                       value="${book.author}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">出版社：</label>
            <div class="layui-input-inline">
                <input type="text" name="press" required placeholder="请输入出版社" class="layui-input" value="${book.press}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">出版日期：</label>
            <div class="layui-input-inline">
                <input type="text" id="pubdate" name="pubdate" required lay-verify="date" placeholder="请选择出版日期"
                       class="layui-input" value="${book.pubdate}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">图书数量：</label>
            <div class="layui-input-inline">
                <input type="text" name="bnums" required lay-verify="positiveInt" placeholder="请输入图书数量"
                       class="layui-input" value="${book.bnums}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">图书价格：</label>
            <div class="layui-input-inline">
                <input type="text" name="price" required lay-verify="positiveDouble" placeholder="请输入图书价格"
                       class="layui-input" value="${book.price}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">图书类型：</label>
            <div class="layui-input-inline">
                <select id="type" name="tno" lay-verify="required">
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button id="submit" class="layui-btn" lay-submit lay-filter="btn">修改</button>
                <button id="cancel" type="button" class="layui-btn layui-btn-primary">取消</button>
            </div>
        </div>
    </form>

</div>

<script>
    layui.use(['form', 'layer', 'laydate'], function () {
        var form = layui.form
        var layer = layui.layer
        var laydate = layui.laydate
        var $ = layui.jquery

        form.on('submit(btn)', function (data) {

            $.ajax({
                url: ' http://localhost:8080/books',
                type: 'post',
                contentType:'application/json',
                data: JSON.stringify(data.field),
                async: 'true',
                success: function (msg) {
                    var index = parent.layer.getFrameIndex(window.name)

                    if (msg == "true") {
                        parent.layui.layer.msg('修改成功')
                        parent.layui.table.reload('tableId')
                    } else {
                        parent.layui.layer.msg('修改失败')
                    }

                    parent.layer.close(index)
                },
                error: function () {
                    layer.msg("修改失败")
                }
            })
        })



        //渲染日期选择框
        laydate.render({
            elem: '#pubdate',
            trigger: 'click',
            format: 'yyyy-MM-dd'
        })

        form.verify({
            positiveInt: [
                /^[1-9]\d*$/
                , '输入内容只能是正整数'
            ]
            , positiveDouble: [
                /^((0{1}\.\d{1,2})|([1-9]\d*\.{1}\d{1,2})|([1-9]+\d*))$/
                , '输入内容必须大于0'
            ]
        })

        $("#cancel").click(function () {
            var index = parent.layer.getFrameIndex(window.name)

            parent.layer.close(index)
        })


        $.ajax({
            url: 'http://localhost:8080/types',
            async: 'true',
            type: 'get',
            success: function (data) {
                $.each(data, function (i, type) {
                    var obj = $("<option value='" + type.tno + "'>" + type.type + "</option>")

                    $("#type").append(obj)

                })
                //设置图书类型的回显
                $("#type option[value=" + ${book.tno} +"]").prop("selected", true);
                form.render()
            }
        })
    })
</script>
</body>
</html>
