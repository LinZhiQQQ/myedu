<%@ page import="pers.lyt.myedu.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/4/1
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Upload Picture</title>
</head>
<body>
    <%
        session.setAttribute("userId",((Student)request.getAttribute("student")).getStu_id());
        session.setAttribute("userType","student");
    %>
    <form action="${pageContext.request.contextPath }/edu/AddFile_execute.action"  method="post" enctype="multipart/form-data">
        <input type="file" name="file" id="file">
        <input type="submit" value="上传">
    </form>
</body>
</html>
