<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Edit Book</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
    <jsp:include page="menu.jsp"/>
    <c:set var="book_info" value="${book}"/>
    <div class="container">
        <div class="jumbotron">
            <form class="form-horizontal" method="post">
                <div class="form-group">
                    <label class="control-label col-sm-4" for="title">Title:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="title" id="title"
                               value="<c:out value="${book_info.title}"/>" placeholder="Title"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-4" for="author">Author:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="author" id="author"
                               value="<c:out value="${book_info.author}"/>" placeholder="Author"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-4" for="pages">Pages:</label>
                    <div class="col-sm-4">
                        <input type="number" class="form-control" name="pages" id="pages" min="1"
                               value="<c:out value="${book_info.pages}"/>" placeholder="Pages"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-4">
                        <input type="submit" class="btn btn-warning" name="edit" value="Edit"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
