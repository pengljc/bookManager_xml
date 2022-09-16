<%--
  Created by IntelliJ IDEA.
  User: 23781
  Date: 2022/8/31
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css"/>
    <script src="../../static/layui/layui.js"></script>
</head>
<%
    Cookie[] cookies = request.getCookies();
    String username = "";
    String password = "";

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                username = cookie.getValue();
            }

            if ("password".equals(cookie.getName())) {
                password = cookie.getValue();
            }
        }
    }
%>
<body>
<div class="layui-row" style="margin-top: 50px">
    <div class="layui-col-md6 layui-col-md-offset3" style="border:1px green solid;height: 50%">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>管理员登录</legend>
        </fieldset>
        <form id="loginFrom" class="layui-form" action="/book" method="post">
            <div class="layui-form-item" style="margin-top: 30px">
                <label class="layui-form-label">用户名：</label>
                <div class="layui-input-block" style="width: 60%">
                    <input type="text" name="username" lay-verify="title" placeholder="用户名"
                           class="layui-input" value=<%=username%>>
                </div>
            </div>
            <div class="layui-form-item" style="margin-top: 30px">
                <label class="layui-form-label">密码：</label>
                <div class="layui-input-block" style="width: 60%">
                    <input type="password" name="password" lay-verify="title" placeholder="密码"
                           class="layui-input" value=<%=password%>>
                </div>
            </div>

            <div class="layui-form-item" style="margin-top: 30px">
                <div class="layui-input-block">
                    <button type="submit" class="layui-btn" lay-submit lay-filter="login" style="margin-right: 100px">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>


<script>



    //Demo
    layui.use(['form','layer'], function () {
        var form = layui.form;
        var layer = layui.layer;
        //监听提交
        form.on('submit(login)', function (data) {
            /*  layer.alert(JSON.stringify(data.field), {
                  title: '最终的提交信息'
              })*/
        });

        if (${not empty loginMsg}) {
            layer.alert("${loginMsg}")
            window.location.href = "login.jsp"
        }

    });
</script>
</body>
</html>
