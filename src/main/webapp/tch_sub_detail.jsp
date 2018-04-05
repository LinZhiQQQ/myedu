<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/29
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pers.lyt.myedu.entity.Student_sub" %>
<%@ page import="java.util.List" %>
<%@ page import="pers.lyt.myedu.entity.Subject" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script>
        function refrs() {
            if(window.name!="hasLoad"){
                location.reload();
                window.name = "hasLoad";
            }else{
                window.name="";
            }
        }
        function getScore(form)
        {
           var score=prompt("请输入分数","xxx"); // 弹出input框
            form.newScore.value = score;
           return true;
        }
    </script>
</head>
<body onload="refrs()">
<form action="${pageContext.request.contextPath}/edu/edu2_turn_back.action" name="turn" id="turn"></form>
<%
    if(session.getAttribute("teacher") == null) {
%>
<script type="text/javascript" language="javascript">
    alert("已安全退出");
    document.turn.submit();
</script>
<%
    }
%>
<p>教师:${teacher.tch_name}</p>
<div align="center">
    <table border="1">
        <thead>
            <th>学生姓名</th>
            <th>学生学号</th>
            <th>学生成绩</th>
            <th>修改成绩</th>
        </thead>
        <tbody>
        <c:forEach items="${ssblist}" var="item" varStatus="loop">
            <tr>
                <td>${name[loop.count - 1]}</td>
                <td><c:out value="${item.stu_id}"></c:out></td>
                <td><c:out value="${item.score}"></c:out></td>
                <td>
                <form name="changeScore" action="${pageContext.request.contextPath }/edu/edu2_changeScore.action" method="post" onsubmit="return getScore(this)">
                    <input type="hidden" id="newScore" name="newScore">
                    <input type="hidden" id="stu_id" name="stu_id" value="${item.stu_id}">
                    <input type="hidden" id="sub_id" name="sub_id" value="${item.sub_id}">
                    <input type="submit" value="修改">
                </form>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="${pageContext.request.contextPath }/edu/edu2_tch_sub.action" method="get">
        <input type="submit" value="返回">
    </form>
</div>
</body>
</html>
