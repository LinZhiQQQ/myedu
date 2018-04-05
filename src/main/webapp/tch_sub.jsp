<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/25
  Time: 19:25
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
    <p>教师:${teacher.tch_name} 教师编号:${teacher.tch_id}</p>

    <div >
        <%
            List<Subject> list = (List<Subject>) session.getAttribute("list");
        %>
        <div style="margin-left: 20%; width: 50%; height: 50%; background:#d6ffdf;" align="center">
            <table>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <form action="${pageContext.request.contextPath}/edu/edu2_tch_sub_detail.action">
                            <input type="hidden" name="detial" value=x>
                            <td><c:out value="${item.sub_name}"></c:out>&nbsp;&nbsp;
                                <input type="hidden" name="detail" value="${item.sub_id}">
                                <input type="submit" value="查看">
                            </td><br>
                        </form>
                    </tr>
                </c:forEach>
            </table>
            <form action="${pageContext.request.contextPath }/edu/edu2_toCreate_sub.action">
                <input type="submit" value="开设课程">
            </form>
            <form action="${pageContext.request.contextPath }/edu/edu2_toCancel_sub.action">
                <input type="submit" value="取消课程">
            </form>
            <form action="${pageContext.request.contextPath }/edu/edu2_returnTo_tch.action">
                <input type="submit" value="返回">
            </form>

        </div>

    </div>

</body>
</html>
