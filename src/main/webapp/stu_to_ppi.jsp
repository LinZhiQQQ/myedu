<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/19
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pers.lyt.myedu.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function ppi() {
            document.ppi.action="${pageContext.request.contextPath }/edu/edu_stu_ppi.action";
            document.ppi.submit();
        }
        function myfunction() {
            if(window.name!="hasLoad"){
                location.reload();
                window.name = "hasLoad";
            }else{
                window.name="";
            }
            var x = "${student.stu_sex}";
            console.log(x);
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
<div align="center">
    <div align="center" style="background:#d6ffdf; width: 100%;height: 500px">
        <form  method="post" name="ppi"action="${pageContext.request.contextPath }/edu/edu1_stu_ppi.action" >
            <div style=" margin-left:0px;margin-top:50px" >
                <select id="selec" name="student.stu_sex" value="${student.stu_sex}">
                    <option value=0>男生</option>
                    <option value=1>女生</option>
                </select>
                <p>学生:${student.stu_name} 学号:${student.stu_id}</p>
                <br>
            </div>
            <p>年龄</p><input type="text" name="student.stu_age" value="${student.stu_age}" /><br/>
            <p>电话号码</p><input type="text" name="student.stu_tel" value="${student.stu_tel}" /><br/>
            <p>所属年级（如16）</p><input type="text" name="student.stu_gra" value="${student.stu_gra}" /><br/>
            <p>所属班级（如2）</p><input type="text" name="student.stu_cls" value="${student.stu_cls}" /><br/>
            <p>所属学院（如信息技术学院）</p><input type="text" name="student.stu_sch" value="${student.stu_sch}" /><br/>
            <button type="submit">提交</button>
        </form>
        <form action="${pageContext.request.method}/edu/edu1_change_img.action" method="post">
            <input type="submit" value="修改头像">
        </form>
    </div>

</div>

</body>
</html>
