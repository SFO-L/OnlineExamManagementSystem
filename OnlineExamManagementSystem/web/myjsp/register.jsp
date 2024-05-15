<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/5/7
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册</title>
    <!-- 请勿在项目正式环境中引用该 layui.css 地址 -->
    <link href="//unpkg.com/layui@2.9.9/dist/css/layui.css" rel="stylesheet">
</head>
<body>
<style>
    .demo-reg-container{width: 320px; margin: 21px auto 0;}
    .demo-reg-other .layui-icon{position: relative; display: inline-block; margin: 0 2px; top: 2px; font-size: 26px;}
</style>
<form class="layui-form" action="<%=request.getContextPath()%>/UserAddServlet" method="get">
    <div class="demo-reg-container">
        <div class="layui-form-item">
            <div class="layui-input-wrap">
                <div class="layui-input-prefix">
                    <i class="layui-icon-email"></i>
                </div>
                <input type="text" name="email" value="" lay-verify="required" placeholder="邮箱" lay-reqtext="请填写邮箱" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-wrap">
                <div class="layui-input-prefix">
                    <i class="layui-icon layui-icon-password"></i>
                </div>
                <input type="password" name="password" value="" lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input" id="reg-password" lay-affix="eye">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-wrap">
                <div class="layui-input-prefix">
                    <i class="layui-icon layui-icon-password"></i>
                </div>
                <input type="password" name="confirmPassword" value="" lay-verify="required|confirmPassword" placeholder="确认密码" autocomplete="off" class="layui-input" lay-affix="eye">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-wrap">
                <div class="layui-input-prefix">
                    <i class="layui-icon layui-icon-username"></i>
                </div>
                <input type="text" name="userName" value="" lay-verify="required" placeholder="用户姓名" autocomplete="off" class="layui-input" lay-affix="clear">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-wrap">
                <div class="layui-form">
                    <input type="radio" name="sex" value="0" title="默认">
                    <div lay-radio>
                        <span style="color: blue;">男♂</span>
                    </div>
                    <input type="radio" name="sex" value="1" title="默认">
                    <div lay-radio>
                        <span style="color: pink;">女♀</span>
                    </div>
                </div>
        </div>
        <div class="layui-form-item">
            <input type="checkbox" name="agreement" lay-verify="required" lay-skin="primary" title="同意">
            <a href="#terms" target="_blank" style="position: relative; top: 6px; left: -15px;">
                <ins>用户协议</ins>
            </a>
        </div>
        <div class="layui-form-item">
            <input type="submit" value="用户注册" class="layui-btn layui-btn-fluid">
        </div>
        <div class="layui-form-item demo-reg-other">
            <label>社交账号注册</label>
            <span style="padding: 0 21px 0 6px;">
        <a href="javascript:;"><i class="layui-icon layui-icon-login-qq" style="color: #3492ed;"></i></a>
        <a href="javascript:;"><i class="layui-icon layui-icon-login-wechat" style="color: #4daf29;"></i></a>
        <a href="javascript:;"><i class="layui-icon layui-icon-login-weibo" style="color: #cf1900;"></i></a>
      </span>
            <a href="<%=request.getContextPath()%>/myjsp/login.jsp">登录已有帐号</a>
        </div>
    </div>
</form>

<!-- 请勿在项目正式环境中引用该 layui.js 地址 -->
<script src="//unpkg.com/layui@2.9.9/dist/layui.js"></script>
<script>
    layui.use(function(){
        var $ = layui.$;
        var form = layui.form;
        var layer = layui.layer;
        var util = layui.util;

        // 自定义验证规则
        form.verify({
            // 确认密码
            confirmPassword: function(value, item){
                var passwordValue = $('#reg-password').val();
                if(value !== passwordValue){
                    return '两次密码输入不一致';
                }
            }
        });

        // 提交事件
        form.on('submit(demo-reg)', function(data){
            var field = data.field; // 获取表单字段值

            // 是否勾选同意
            if(!field.agreement){
                layer.msg('您必须勾选同意用户协议才能注册');
                return false;
            }

            // 显示填写结果，仅作演示用
            layer.alert(JSON.stringify(field), {
                title: '当前填写的字段值'
            });

            // 此处可执行 Ajax 等操作
            // …

            return false; // 阻止默认 form 跳转
        });

        // 普通事件
        util.on('lay-on', {
            // 获取验证码
            'reg-get-vercode': function(othis){
                var isvalid = form.validate('#reg-cellphone'); // 主动触发验证，v2.7.0 新增
                // 验证通过
                if(isvalid){
                    layer.msg('手机号规则验证通过');
                    // 此处可继续书写「发送验证码」等后续逻辑
                    // …
                }
            }
        });
    });
</script>

</body>
</html>