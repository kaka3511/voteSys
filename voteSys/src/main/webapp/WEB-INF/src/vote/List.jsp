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
<h2>投票面板<span class="glyphicon glyphicon-volume-up"></span></h2>
<img src="${pageContext.request.contextPath }/asset/vote.jpg" >
<div class="container">
    <div class="row clearfix">

        <ul>
            <c:forEach items="${list }" var="item">

                <h4>${item.title }</h4>
                <li style="list-style-type:none;">
                    <div class="col-md-12 column">
                        <p>
                            <c:forEach items="${item.subs }" var="sub">
                        <div class="radio">

                                <strong>${sub.content }</strong>
                               (当前票数${sub.quantity  })<br>
                        </div>
                            </c:forEach>
                            <label class="dateLabel"> ${item.date }</label>
                        </p>
                                    <c:if test="${userid != null}">
                                            <form action=${pageContext.request.contextPath }/vote/detail.do" method="post" accept-charset="utf-8">
                                    <li>
                                            <input type="hidden" name="id" value="${item.id }">
                                            <input type="submit" value="进入投票 >>">
                                    </li>
                                    </form>
                                    </c:if>
                        <hr>
                    </div>

                </li>
            </c:forEach>

        </ul>

    </div>
</div>

</body>

</html>