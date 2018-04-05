<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/17
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pers.lyt.myedu.entity.Teacher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script type="text/javascript">
        function clearSession() {
            $.cookie("userId","",{ expires: -1, path:"/"});
            $.cookie("userPwd","",{expires: -1, path:"/"});
        }
    </script>
</head>
<body>
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
<div style="color: cornflowerblue; width: 100%;height: 300px; background:#d6ffdf;" align="center">
    <h2>教师:${teacher.tch_name}  教师编号:${teacher.tch_id} </h2>

    <img alt="尚未上传头像" src="${img.url}" style="height: 70px">

    <form action="${pageContext.request.contextPath }/edu/edu2_tch_to_ppi.action">
        <input type="submit" value="修改个人信息">
    </form>

    <form action="${pageContext.request.contextPath }/edu/edu2_tch_sub.action">
        <input type="submit" value="负责课程">
    </form>
    <form action="${pageContext.request.contextPath }/edu/edu2_exit.action">
        <input type="submit" value="退出" onclick="clearSession()">
    </form>
</div>
</body>
</html>