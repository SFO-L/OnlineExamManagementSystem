<%@ page import="com.sys.entity.Question" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/4/22
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>土庄町立土庄中学校在线考试管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//cdn.staticfile.org/layui/2.9.7/css/layui.css" rel="stylesheet">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">OEMS(1003)</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>
            <%
                Integer quanxian = (Integer)session.getAttribute("quanxian");
                if(quanxian == 0){
            %>
            <li class="layui-nav-item layui-hide-xs"><a href="javascript:;">土庄町立土庄中学校在线考试管理系统(管理员)</a></li>
            <%
            }else{
            %>
            <li class="layui-nav-item layui-hide-xs"><a href="javascript:;">土庄町立土庄中学校在线考试管理系统(用户端)</a></li>
            <%
                }
            %>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-sm-inline-block">
                <a href="javascript:;">
                    <img src="//unpkg.com/outeres@0.0.10/img/layui/icon-v2.png" class="layui-nav-img">
                    tester
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="<%=request.getContextPath()%>/myjsp/login.jsp">退出登录</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">用户信息管理</a>
                    <dl class="layui-nav-child">
                        <%
                            if(quanxian == 0){
                        %>
                        <dd><a href="<%=request.getContextPath()%>/UserFindAllServlet">用户信息查询</a></dd>
                        <%
                        }else{
                        %>
                        <dd><a href="<%=request.getContextPath()%>/UserFindSelfServlet" >个人信息查询</a></dd>
                        <%
                            }
                        %>
                        <dd><a href="<%=request.getContextPath()%>/User/user_Update.jsp">更新个人信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <%
                        if(quanxian == 0){
                    %>
                    <a href="javascript:;">试题信息管理</a>
                    <%
                    }else{
                    %>
                    <a href="javascript:;">试题库</a>
                    <%
                        }
                    %>

                    <dl class="layui-nav-child">
                        <%
                            if(quanxian == 0){
                        %>
                        <dd><a href="<%=request.getContextPath()%>/Question/question_Add.jsp" >试题注册</a></dd>
                        <dd><a href="<%=request.getContextPath()%>/QuestionFindAllServlet">试题查询</a></dd>
                        <%
                        }else{
                        %>
                        <dd><a href="<%=request.getContextPath()%>/QuestionFindAllServlet">题库学习</a></dd>
                        <%
                            }
                        %>

                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">考试管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=request.getContextPath()%>/QuestionRandServlet">参加考试</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->

        <% Question question = (Question) request.getAttribute("QueInfoById");
            System.out.println(question.getTitle());
        %>
        <font style="color: red;font-size: 30px;text-align: center" >试题信息</font>
        <form action="<%=request.getContextPath()%>/QuestionUpDateServlet">
            <table border='2'  align='center'>
                <tr style="align-content: center">
                    <td>题号</td>
                    <td><input type="text" name="questionId" value="<%=question.getQuestionId()%>"  readonly="readonly" ></td>
                </tr>
                <tr>
                    <td>题目名称</td>
                    <td ><input type="text" name="title" value="<%=question.getTitle()%>"></td>
                </tr>
                <tr>
                    <td>选项A</td>
                    <td ><input type="text" name="optionA" value="<%=question.getOptionA()%>"></td>
                </tr>
                <tr>
                    <td>选项B</td>
                    <td ><input type="text" name="optionB" value="<%=question.getOptionB()%>"></td>
                </tr>
                <tr>
                    <td>选项C</td>
                    <td><input type="text" name="optionC" value="<%=question.getOptionC()%>"></td>
                </tr>
                <tr>
                    <td>选项D</td>
                    <td><input type="text" name="optionD" value="<%=question.getOptionD()%>"></td>
                </tr>
                <tr>
                    <td>正确答案</td>
                    <td >
                        <input type="radio" value="A" name="answer" <%="A".equals(question.getAnswer())?"checked":""%>> A
                        <input type="radio" value="B" name="answer" <%="B".equals(question.getAnswer())?"checked":""%>> B
                        <input type="radio" value="C" name="answer" <%="C".equals(question.getAnswer())?"checked":""%>> C
                        <input type="radio" value="D" name="answer" <%="D".equals(question.getAnswer())?"checked":""%>> D
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="更新试题"></td>
                    <td><input type="reset"></td>

                </tr>

            </table>
        </form>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        欢迎来到林桑的系统
    </div>
</div>

<script src="//cdn.staticfile.org/layui/2.9.7/layui.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element;
        var layer = layui.layer;
        var util = layui.util;
        var $ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            menuLeft: function(othis){ // 左侧菜单事件
                layer.msg('展开左侧菜单的操作', {icon: 0});
            },
            menuRight: function(){  // 右侧菜单事件
                layer.open({
                    type: 1,
                    title: '更多',
                    content: '<div style="padding: 15px;">处理右侧面板的操作</div>',
                    area: ['260px', '100%'],
                    offset: 'rt', // 右上角
                    anim: 'slideLeft', // 从右侧抽屉滑出
                    shadeClose: true,
                    scrollbar: false
                });
            }
        });
    });
</script>
</body>
</html>




