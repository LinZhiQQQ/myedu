<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/17
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">

        function clearSession() {
            sessionStorage.clear();
        }
    </script>
</head>
<body>
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
    <script type="text/javascript">
        if("${student}" == null){
            location.reload();
        }
    </script>

<div style="color: cornflowerblue; width: 100%;height: 300px; background:#d6ffdf;" align="center">
        <h2>学生:${student.stu_name} 学生学号:${student.stu_id} </h2>
        <img alt="尚未上传头像" src="${img.url}" style="height: 70px">
        <form action="${pageContext.request.contextPath }/edu/edu1_stu_to_ppi.action">
            <input type="submit" value="修改个人信息">
        </form>
        <form action="${pageContext.request.contextPath }/edu/edu1_ck_sub.action">
            <input type="submit" value="查看个人课表">
        </form>

        <form action="${pageContext.request.contextPath}/edu/edu1_exit.action">
            <input type="submit" value="退出" onsubmit="clearSession()">
        </form>
    </div>
</body>
</html>
