<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/31
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/edu/edu1_turn_back.action" name="form1"></form>
<%
    session.invalidate();
    request.logout();
%>
<script type="text/javascript">
    document.form1.submit();
</script>
</body>
</html>
