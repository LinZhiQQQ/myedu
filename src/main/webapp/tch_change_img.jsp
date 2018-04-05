<%@ page import="pers.lyt.myedu.entity.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/4/1
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.setAttribute("userId",((Teacher)request.getAttribute("teacher")).getTch_id());
    session.setAttribute("userType","teacher");
%>
<form action="${pageContext.request.contextPath }/edu/AddFile_execute.action"  method="post" enctype="multipart/form-data">
    <input type="file" name="file" id="file">
    <input type="submit" value="上传">
</form>
</body>
</html>
