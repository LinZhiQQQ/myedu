<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/23
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="pers.lyt.myedu.entity.Subject" %>
<%@ page import="pers.lyt.myedu.entity.Student" %>
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
    <p>学生:${student.stu_name} 学号:${student.stu_id}</p>

    <div >

        <div style="margin-left: 20%; width: 50%; height: 50%; background:#d6ffdf;" align="center">
            <table>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <form action="${pageContext.request.contextPath}/edu/edu1_stu_sub_detail.action">
                            <input type="hidden" name="detial" value=x>
                            <td><c:out value="${item.sub_name}"></c:out>&nbsp;&nbsp;
                                <input type="hidden" name="detail" value="${item.sub_id}">
                                <input type="submit" value="查看">
                            </td><br>
                        </form>

                    </tr>
                </c:forEach>
            </table>

            <form action="${pageContext.request.contextPath}/edu/edu1_toAdd_sub.action">
                <input type="submit" value="选课">
            </form>

            <form action="${pageContext.request.contextPath}/edu/edu1_toDelete_sub.action">
                <input type="submit" value="退课">
            </form>

            <form action="${pageContext.request.contextPath}/edu/edu1_returnTo_stu.action">
                <input type="submit" value="返回">
            </form>
        </div>

    </div>
</body>
</html>
