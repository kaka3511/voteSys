<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <style type="text/css">
        body{
            margin:0;
            padding: 0;
            background:url('${pageContext.request.contextPath }/asset/bg.jpg');
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
            background-color:#ccc;
            height:1px;
        }
        iframe{
            margin-top:0px;
            border:0;
            padding:0;
            background:url('${pageContext.request.contextPath }/asset/bg.jpg');
        }
    </style>
</head>
<body>

<h2>系统公告<span class="glyphicon glyphicon-volume-up"></span></h2>
<img src="${pageContext.request.contextPath }/asset/notice.png" >
<div class="container">
    <div class="row clearfix">

        <ul>
            <li style="list-style-type:none;">
                <div class="col-md-12 column">
                    <h4 style="color: blue;">
                        ${notice.title }
                    </h4>
                    <p>
                        ${notice.content }
                        <label class="dateLabel">${notice.date }</label>
                    </p>
                    <hr>
                </div>
            </li>


        </ul>

    </div>
</div>



</body>
</body>

</html>