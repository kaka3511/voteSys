<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js">
    </script>
    <style type="text/css">
        body{
            background:url('${pageContext.request.contextPath }/asset/bg.jpg');
        }
        .dateLabel{
            margin-left:900px;
        }
        h2,img{
            position:fixed;
        }
        ul{
            margin-left:120px;
        }
        img{
            margin-top:70px;
        }
        hr{
            background-color:black;
            height:1px;
        }
    </style>
</head>

<body>
<h2>系统公告<span class="glyphicon glyphicon-volume-up"></span></h2>
<img src="${pageContext.request.contextPath }/asset/notice.png" >
<div class="container">
    <div class="row clearfix">

        <ul>
            <c:forEach items="${list }" var="item">


            <li style="list-style-type:none;">
                <div class="col-md-12 column">
                    <h4 style="color: blue;">
                        ${item.title }
                    </h4>
                    <p>
                            ${item.content }
                        <label class="dateLabel"> ${item.date }</label>
                    </p>
                    <p>
                        <a class="btn" href="${pageContext.request.contextPath }/notice/detail.do?id=${item.id }">查看详情 »</a>
                    </p>
                    <hr>
                </div>
            </li>
            </c:forEach>
        </ul>

    </div>
</div>

</body>

</html>