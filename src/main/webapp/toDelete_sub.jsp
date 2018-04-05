<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/25
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pers.lyt.myedu.entity.Subject" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function refrs() {
            if(window.name!="hasLoad"){
                location.reload();
                window.name = "hasLoad";
            }else{
                window.name="";
            }
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
<div style="margin-left: 20%; width: 50%; height: 50%; background:#d6ffdf;" align="center">
    <%
        List<Subject> list = (List<Subject>) session.getAttribute("list");
    %>
    <form method="post" name="delete" action="${pageContext.request.contextPath}/edu/edu1_delete_sub.action">
        <c:forEach items="${list}" var="item">

            <p><input type="checkbox" name="deleteId" value="${item.sub_id}"><c:out value="${item.sub_name}"></c:out></p>
        </c:forEach>

        <input type="submit" value="提交">

        <font color="green">${resultC}</font><br>

    </form>
    <form method="post" action="${pageContext.request.contextPath}/edu/edu1_ck_sub.action">
        <input type="submit" value="返回">
    </form>
</div>
</body>
</html>
