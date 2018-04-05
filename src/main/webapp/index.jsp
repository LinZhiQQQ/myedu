<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/7
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
        function registered() {
            document.login.action="${pageContext.request.contextPath }/edu/edu_to_regs.action";
            document.login.submit();
        }
        function logins() {
            if(document.getElementById("selec").value == "stu"){
                document.login.action="${pageContext.request.contextPath }/edu/edu1_stu_login.action";
                document.login.submit();
            }else{
                document.login.action="${pageContext.request.contextPath }/edu/edu2_tch_login.action";
                document.login.submit();
            }
        }
        function check1(x) {
            if (x.userId.value ==''){
                alert("请输入账号");
                x.userId.focus();
                return false;
            }
            if (x.userPwd.value ==''){
                alert("请输入密码");
                x.userPwd.focus();
                return false;
            }
            if(isNaN(x.userId.value)){
                alert("账号只能为数字");
                x.userId.focus();
                return false;
            }
            logins();
        }
        function refsh() {
            if(window.name!="hasLoad"){
                location.reload();
                window.name = "hasLoad";
            }else{
                window.name="";
            }
        }
    </script>

    <title>My_Edu</title>
    <style type="text/css">
        .btn {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 12px;
        }
    </style>
</head>
<body onload="refsh()">
<%
    session.setAttribute("error1","");
%>
    <div id="content" style="margin:0 auto;  width:1000px; height:500px; position:relative; align-items: center;">
        <div style=" text-align:center">
            <div class="login" style="position:absolute; top:50%;left:50%;margin-top:-100px;margin-left:-200px;background:#d6ffdf; width:400px; height: 210px; border-radius:10px;">
                <form  method="post" name="login">
                    <div style=" margin-left:0px;margin-top:50px">
                        <select id="selec" name="selec" value="${selec }">
                            <option value="stu">学生</option>
                            <option value="tch">教师</option>
                        </select>
                        <p style="display:inline">登陆账号:</p>
                        <input type="text" name="userId" value="${userId}"/><br/>
                    </div>
                    <div style="margin-left:53px;margin-top:20px">
                        <p style="display:inline">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</p>
                        <input type="password" name="userPwd" value="${userPwd}" ><br/>
                    </div>
                        <div style="margin-top:20px;margin-left: 10px">
                            <button onclick="return check1(this.form)" class="btn" >登录</button>
                            <button onclick="registered()"class="btn">注册</button>
                        </div>
                    <font color="red">${error1}</font>
                </form>
            </div>
        </div>
    </div>

</body>
</html>

