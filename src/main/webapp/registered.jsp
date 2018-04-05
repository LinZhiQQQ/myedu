<%--
  Created by IntelliJ IDEA.
  User: 林之谦
  Date: 2018/3/16
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function chg1(x){
            if(x.value == "stu"){
                document.getElementById("t1").innerHTML = "学生姓名";
                document.getElementById("t2").innerHTML = "学生学号";
            }else{
                document.getElementById("t1").innerHTML = "教师姓名";
                document.getElementById("t2").innerHTML = "教师编号";
            }
        }
        function registered() {
            if(document.getElementById("selec").value == "stu"){
                document.login.action="${pageContext.request.contextPath }/edu/edu1_stu_regs.action";
                document.login.submit();
            }else{
                document.login.action="${pageContext.request.contextPath }/edu/edu2_tch_regs.action";
                document.login.submit();
            }

        }
        function chg3() {
            document.login.action="${pageContext.request.contextPath }/edu/edu_to_login.action";
            document.login.submit();
        }
        function check1(x) {
            if (x.userName.value ==''){
                alert("请输入用户名");
                x.userName.focus();
                return false;
            }
            if (x.userPwd.value ==''){
                alert("请输入密码");
                x.userPwd.focus();
                return false;
            }
            if (x.userId.value ==''){
                alert("请输入id");
                x.userId.focus();
                return false;
            }
            registered(x);
        }
    </script>
    <style type="text/css">
        .btn {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 12px 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 12px;
        }
    </style>
</head>
<body>
<div id="content" style="margin:0 auto;  width:1000px; height:500px; position:relative; align-items: center;">
    <div style=" text-align:center">
        <div class="login" style="position:absolute; top:50%;left:50%;margin-top:-100px;margin-left:-200px;background:#d6ffdf; width:400px; height: 320px; border-radius:10px;">

            <form  method="post" name="login" onsubmit="check(this)">
                <div style=" margin-left:0px;margin-top:50px">
                    <select id="selec" name="selec" value="${selec }" onchange="chg1(this)">
                        <option value="stu">学生</option>
                        <option value="tch">教师</option>
                    </select>
                    <p style="display:inline" id="t1">学生姓名</p>
                    <input type="text" name="userName" value="${userName}"  /><br/>

                </div>
                <div style="margin-left:53px;margin-top:20px">
                    <p style="display:inline" id="t2">学生账号</p>
                    <input type="text" name="userId" value="${userId}"  /><br/>
                </div>
                <div style="margin-left:53px;margin-top:20px">
                    <p style="display:inline">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</p>
                    <input type="password" name="userPwd" value="${userPwd}" /><br/>
                </div>
                <div style="margin-top:20px;margin-left: 10px">
                    <button onclick="return check1(this.form)" class="btn">注册</button><font color="red" style="float: inherit">${error1}</font><font color="green" style="float: inherit">${resule1}</font>
                </div>
            </form>
            <form action="${pageContext.request.contextPath }/edu/edu_to_login.action">
                <button class="btn">返回登陆页面</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
