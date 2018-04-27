<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/19
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pers.lyt.myedu.entity.Teacher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function ppi() {
            document.ppi.action="${pageContext.request.contextPath }/edu/edu2_tch_ppi.action";
            document.ppi.submit();
        }
        function myfunction() {
            if(window.name!="hasLoad"){
                location.reload();
                window.name = "hasLoad";
            }else{
                window.name="";
            }
            var x = "${teacher.tch_sex}";
            var all_options = document.getElementById("selec").options;
            if(x == 0){
                all_options[0].selected = true;
            }else{
                all_options[1].selected = true;
            }
        }
    </script>
</head>
<body onload="myfunction()">
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
<div align="center">
    <div align="center" style="background:#d6ffdf; width: 100%;height: 500px">
        <form  method="post" name="ppi"action="${pageContext.request.contextPath }/edu/edu2_tch_ppi.action" >

            <div style=" margin-left:0px;margin-top:50px" >
                <select id="selec" name="teacher.tch_sex" value="${teacher.tch_sex}">
                    <option value=0>男</option>
                    <option value=1>女</option>
                </select>
                <p>教师:${teacher.tch_name} 编号:${teacher.tch_id}</p>
                <br>
            </div>
            <p>年龄</p><input type="text" name="teacher.tch_age" value="${teacher.tch_age}" /><br/>
            <p>电话号码</p><input type="text" name="teacher.tch_tel" value="${teacher.tch_tel}" /><br/>
            <p>所属学院（如信息技术学院）</p><input type="text" name="teacher.tch_sch" value="${teacher.tch_sch}" /><br/>

            <button type="submit">提交</button>
        </form>
        <form action="${pageContext.request.method}/edu/edu2_change_img.action" method="post">
            <input type="submit" value="修改头像">
        </form>
    </div>
</div>
</body>
</html>
