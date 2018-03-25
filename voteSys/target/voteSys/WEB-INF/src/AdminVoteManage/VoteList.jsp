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
        .table-striped{
            margin-left:160px;
            width:1000px;
        }
        .input-group{
            margin-left:160px;
            width:200px;
        }
        .query{
            position:fixed;
            margin-left:-157px;
            margin-top:64px;
        }
        a{
            text-decoration:none;
            color:white;
        }
        .formDel,.divModiify{
            margin:0px;
            display: inline;
        }
        .btn-primary{
            position:fixed;
            margin-left:2px;
            margin-top:135px;
            width:202px;
        }
    </style>
</head>

<body>
<form action="${pageContext.request.contextPath }/vote/list.do" method="post" accept-charset="utf-8" class="query">
    <div class="input-group">
        <input name="keyword" type="text" class="form-control" placeholder="关键字查询">
        <input type="submit" value="查询" class="btn btn-info" style="width:100%">
    </div>
</form>
<h2>投票管理<span class="glyphicon glyphicon-briefcase"></span></h2>

<a class="divModiify" href="${pageContext.request.contextPath }/vote/addVoteOne.do">
    <input type="button" value="新增投票" class="btn btn-primary">
</a>

<br>
<div class="container">
    <div class="row clearfix">
        <table class="table table-striped">

            <thead>
            <tr>
                <th>标题</th>
                <th>选项</th>
                <th>时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list }" var="item">
                <tr>
                    <td style="display:table-cell; vertical-align:middle" ><strong>${item.title }</strong></td>
                    <td>
                        <c:forEach items="${item.subs }" var="sub">
                        选项：${sub.content }      &nbsp;&nbsp;
                            数量：${sub.quantity }
                            <a class="divModiify" href="${pageContext.request.contextPath }/vote/modifyVote.do?id=${sub.id }&">
                                <input type="button" value="修改" class="btn btn-success">
                            </a>
                        <hr>
                        </c:forEach>

                    </td>
                    <td style="display:table-cell; vertical-align:middle">${item.date }</td>
                    <td style="display:table-cell; vertical-align:middle">
                        <form class="formDel" action="${pageContext.request.contextPath }/vote/deleteVote.do" method="post" accept-charset="utf-8" >
                            <input type="hidden" name="id" value="${item.id }">

                            <input type="submit" value="删除" class="btn btn-danger">
                        </form>
                        <a class="divModiify" href="${pageContext.request.contextPath }/vote/modifyVoteTitle.do?id=${item.id }">
                            <input type="button" value="修改" class="btn btn-success">
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>

</body>

</html>