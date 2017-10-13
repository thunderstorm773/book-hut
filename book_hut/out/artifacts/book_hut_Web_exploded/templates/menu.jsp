<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css">
    </head>
    <body>
        <c:set var="login_model" value="${sessionScope.get('LOGIN_MODEL')}"/>
    <nav class="navbar navbar-inverse navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle"
                        data-toggle="collapse" data-target="#library-menu">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">Library</a>
            </div>
            <div class="collapse navbar-collapse" id="library-menu">
                <ul class="nav navbar-nav">
                    <c:if test="${login_model != null}">
                        <li><a href="${pageContext.request.contextPath}/add">Add Book</a></li>
                    </c:if>
                    <li><a href="${pageContext.request.contextPath}/shelves">Shelves</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:choose>
                        <c:when test="${login_model != null}">
                        <li><a href="${pageContext.request.contextPath}/sign-out">
                            <span class="glyphicon glyphicon-log-out"></span>
                            Sign Out(<c:out value="${login_model.username}"/>)</a></li>
                    </c:when>
                        <c:otherwise>
                            <li><a href="${pageContext.request.contextPath}/sign-up">
                                <span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                            <li><a href="${pageContext.request.contextPath}/sign-in">
                                <span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
        <script src="${pageContext.request.contextPath}/jquery/jquery-3.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
