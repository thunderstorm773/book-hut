<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Shelves</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
    <jsp:include page="menu.jsp"/>
    <c:set var="books" value="${books}" />
    <c:set var="loggedInUser" value="${sessionScope.get('LOGIN_MODEL')}"/>
    <div class="container">
        <div class="jumbotron">
        <table class="table table-bordered table-striped table-hover table-responsive">
            <thead>
            <tr>
                <c:choose>
                    <c:when test="${loggedInUser != null}">
                        <th>Id</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Pages</th>
                        <th>Edit Book</th>
                        <th>Delete Book</th>
                    </c:when>
                    <c:otherwise>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Pages</th>
                    </c:otherwise>
                </c:choose>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <c:choose>
                        <c:when test="${loggedInUser != null}">
                            <td>
                                <c:out value="${book.id}"/>
                            </td>
                            <td>
                                <c:out value="${book.title}"/>
                            </td>
                            <td>
                                <c:out value="${book.author}"/>
                            </td>
                            <td>
                                <c:out value="${book.pages}"/>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/shelves/edit/${book.id}">Edit</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/shelves/delete/${book.id}">Delete</a>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <c:out value="${book.title}"/>
                            </td>
                            <td>
                                <c:out value="${book.author}"/>
                            </td>
                            <td>
                                <c:out value="${book.pages}"/>
                            </td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </div>
    </body>
</html>
