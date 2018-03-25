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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
        textarea{
            width:234px;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath }/vote/modifyVoteDo.do" method="post" accept-charset="utf-8">
    <center>
        <div class="input-group input-group-lg">
            <span class="input-group-addon">内容</span>
            <input name="content"
                   type="text" class="form-control" placeholder="${votesub.content}" >
            <br>
        </div>
        <div class="input-group input-group-lg">
            <span class="input-group-addon">数量</span>
            <input name="quantity"
                   type="text" class="form-control" placeholder="${votesub.quantity}" >
        </div>
        <input type="hidden" name="id" value="${votesub.id}">
        <input type="submit" value="修改" class="btn btn-primary">
    </center>
</form>
</body>
</html>

