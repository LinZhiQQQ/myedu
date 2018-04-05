<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/10
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List</title>
</head>
<body>
    <c:forEach items="${list}" var="list">
        UserId : ${list.id} -----
        UserName : ${list.userName}
        <hr/>
    </c:forEach>
</body>
</html>
