<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js">
    </script>
    <meta charset="utf-8">
    <style type="text/css">
        body{
            background:url('${pageContext.request.contextPath }/asset/bg.jpg');
        }
        .btn-primary{
            width:334px;
        }
        .input-group-addon{
            width:100px;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/addUserDo.do" method="post" accept-charset="utf-8">
    <center>
        <div class="input-group input-group-lg">
            <span class="input-group-addon">用户名</span>
            <input name="username"
                   type="text" class="form-control" placeholder="请输入用户名">
            <br>
        </div>
        <div class="input-group input-group-lg">
            <span class="input-group-addon">密码</span>
            <input name="password"
                   type="text" class="form-control" placeholder="请输入密码">
        </div>
        <input type="submit" value="新增" class="btn btn-primary">
    </center>
</form>
</body>
</html>

