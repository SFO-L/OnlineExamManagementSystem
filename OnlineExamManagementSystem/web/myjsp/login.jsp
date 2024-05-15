<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/5/7
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <!-- 请勿在项目正式环境中引用该 layui.css 地址 -->
    <link href="//unpkg.com/layui@2.9.9/dist/css/layui.css" rel="stylesheet">
</head>
<body>
<style>
    .demo-login-container{width: 320px; margin: 21px auto 0;}
    .demo-login-other .layui-icon{position: relative; display: inline-block; margin: 0 2px; top: 2px; font-size: 26px;}
</style>
<form class="layui-form" action="<%=request.getContextPath()%>/LoginServlet" method="post">
    <div class="demo-login-container">
        <div class="layui-form-item">
            <div class="layui-input-wrap">
                <div class="layui-input-prefix">
                    <i class="layui-icon layui-icon-username"></i>
                </div>
                <input type="text" name="email" value="" lay-verify="required" placeholder="邮箱" lay-reqtext="请填写邮箱" autocomplete="off" class="layui-input" lay-affix="clear">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-wrap">
                <div class="layui-input-prefix">
                    <i class="layui-icon layui-icon-password"></i>
                </div>
                <input type="password" name="password" value="" lay-verify="required" placeholder="密   码" lay-reqtext="请填写密码" autocomplete="off" class="layui-input" lay-affix="eye">
            </div>
        </div>
        <div class="layui-form-item">
            <input type="checkbox" name="remember" lay-skin="primary" title="记住密码">
            <a href="#forget" style="float: right; margin-top: 7px;">忘记密码？</a>
        </div>
        <div class="layui-form-item">
            <input type="submit" value="登录" class="layui-btn layui-btn-fluid">
        </div>
        <div class="layui-form-item demo-login-other">
            <label>社交账号登录</label>
            <span style="padding: 0 21px 0 6px;">
        <a href="javascript:;"><i class="layui-icon layui-icon-login-qq" style="color: #3492ed;"></i></a>
        <a href="javascript:;"><i class="layui-icon layui-icon-login-wechat" style="color: #4daf29;"></i></a>
        <a href="javascript:;"><i class="layui-icon layui-icon-login-weibo" style="color: #cf1900;"></i></a>
      </span>
            或 <a href="<%=request.getContextPath()%>/myjsp/register.jsp">注册帐号</a>
        </div>
    </div>
</form>

<!-- 请勿在项目正式环境中引用该 layui.js 地址 -->
<script src="//unpkg.com/layui@2.9.9/dist/layui.js"></script>
<script>
    layui.use(function(){
        var form = layui.form;
        var layer = layui.layer;
        // 提交事件
        form.on('submit(demo-login)', function(data){
            var field = data.field; // 获取表单字段值
            // 显示填写结果，仅作演示用
            layer.alert(JSON.stringify(field), {
                title: '当前填写的字段值'
            });
            // 此处可执行 Ajax 等操作
            // …
            return false; // 阻止默认 form 跳转
        });
    });
</script>

</body>
</html>