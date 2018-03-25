<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>投票系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js">
    </script>
    <script type="text/javascript">
        function goPublic(){
            document.getElementById("iframeID").src="${pageContext.request.contextPath }/notice/index.do";
            var publicEle = document.getElementById('public');
            publicEle.setAttribute("class", "active");
            var message = document.getElementById('message');
            message.setAttribute("class", "active1");
            var vote = document.getElementById('vote');
            vote.setAttribute("class", "active1");
        }
        function goMessage(){
            document.getElementById("iframeID").src="${pageContext.request.contextPath }/message/index.do";
            var publicEle = document.getElementById('public');
            publicEle.setAttribute("class", "active1");
            var message = document.getElementById('message');
            message.setAttribute("class", "active");
            var vote = document.getElementById('vote');
            vote.setAttribute("class", "active1");
        }
        function goVote(){
            document.getElementById("iframeID").src="${pageContext.request.contextPath }/vote/index.do";
            var publicEle = document.getElementById('public');
            publicEle.setAttribute("class", "active1");
            var message = document.getElementById('message');
            message.setAttribute("class", "active1");
            var vote = document.getElementById('vote');
            vote.setAttribute("class", "active");
        }

    </script>
    <style type="text/css">
        body{
            margin:0;
            padding: 0;
            background:url('${pageContext.request.contextPath }/asset/bg.jpg');
        }
        hr{
            margin-top:50px;
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
<center>
    <h4><span class="glyphicon glyphicon-home"></span>投票系统</h4></center>
<div>

    <ul class="nav navbar-nav navbar-right">
        <li><span class="glyphicon glyphicon-user"></span> ${username }</li>
        <li><a href="${pageContext.request.contextPath }/user/loginOut.do"><span class="glyphicon glyphicon-log-in"></span>  退出</a></li>
    </ul>
</div>


<div class="row clearfix">
    <div class="col-md-12 column">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" ><span class="glyphicon glyphicon-plane"></span>导航栏</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav ">
                    <li id="public">
                        <a href="#" onclick="goPublic()">系统公告</a>
                    </li>
                    <li id="message">
                        <a href="#" onclick="goMessage()">留言板</a>
                    </li>
                    <li id="vote">
                        <a href="#" onclick="goVote()">投票面板</a>
                    </li>
                </ul>
            </div>

        </nav>

        <iframe id="iframeID" src="${pageContext.request.contextPath }/Welcome.html" width="100%" height="400px"></iframe>


    </div>
</div>
</body>

</html>