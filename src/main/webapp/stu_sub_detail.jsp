<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/29
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function refsh() {
            if(window.name!="hasLoad"){
                location.reload();
                window.name = "hasLoad";
            }else{
                window.name="";
            }
        }
    </script>
</head>
<body onload="refsh()">
<form action="${pageContext.request.contextPath}/edu/edu1_turn_back.action" name="turn" id="turn"></form>
<%
    if(session.getAttribute("student") == null) {
%>
<script type="text/javascript" language="javascript">
    alert("已安全退出");
    document.turn.submit();
</script>
<%
    }
%>
<p>姓名:${student.stu_name}</p>
    <div align="center">
        <h2>${sbj.sub_name}</h2>
        <p>分数: ${ssb.score}</p>

        <form action="${pageContext.request.contextPath}/edu/edu1_ck_sub.action" method="get">
            <input type="submit" value="返回">
        </form>
    </div>
</body>
</html>
