<%@ page import="com.sys.entity.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/4/29
  Time: 10:43
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

        <center>
            <form action="ExamServlet" id="examForm">
                <table border="2">
                    <tr>
                        <td>试题编号</td>
                        <td>试题信息</td>
                        <td>A</td>
                        <td>B</td>
                        <td>C</td>
                        <td>D</td>
                        <td>答案</td>
                    </tr>

                    <%
                        List<Question> list = (List)session.getAttribute("questionrand");
                        for(Question q:list){
                    %>
                    <tr>
                        <td><%=q.getQuestionId()%></td>
                        <td><%=q.getTitle()%></td>
                        <td><%=q.getOptionA()%></td>
                        <td><%=q.getOptionB()%></td>
                        <td><%=q.getOptionC()%></td>
                        <td><%=q.getOptionD()%></td>
                        <td>
                            <input type="radio" name="answer_<%=q.getQuestionId()%>" value="A">A
                            <input type="radio" name="answer_<%=q.getQuestionId()%>" value="B">B
                            <input type="radio" name="answer_<%=q.getQuestionId()%>" value="C">C
                            <input type="radio" name="answer_<%=q.getQuestionId()%>" value="D">D
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    <tr align="center">
                        <td colspan="3"><button type="button" id="submitBtn">提交</button></td>
                        <td colspan="4"><input type="reset"></td>
                    </tr>
                </table>
            </form>
        </center>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        欢迎来到林桑的系统
    </div>
</div>

<script src="//cdn.staticfile.org/layui/2.9.7/layui.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<script>
    $(document).ready(function(){
        $("#submitBtn").click(function(event){
            event.preventDefault(); // 阻止默认提交行为
            if(checkAnswers()){
                $("#examForm").submit(); // 所有题目都回答了，提交表单
            }
        });
    });

    function checkAnswers(){
        var allGroupsSelected = true;
        $("[name^='answer_']").each(function(){
            if( !$(this).find("input[type='radio']:checked").length){
                allGroupsSelected = false;
                return; // 发现一个题目组未选，立即结束循环
            }
        });

        if(!allGroupsSelected){
            alert("请确保每个题目都完成选择后再提交！");
        }
        return allGroupsSelected;
    }
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
            }
        });
    });
</script>
</body>
</html>



