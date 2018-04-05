<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/25
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form method="post" action="${pageContext.request.contextPath }/edu/edu2_create_sub.action">
        <p>课程名称</p>
        <input type="text" name="subject.sub_name" value="${subject.sub_name}"><br>

        <p>课程学分</p>
        <input type="text" name="subject.sub_sco" value="${subject.sub_sco}"><br>

        <input type="submit" value="创建课程">

    </form>

    <form method="post" action="${pageContext.request.contextPath }/edu/edu2_tch_sub.action">
        <input type="submit" value="返回">
    </form>
</div>

</body>
</html>
