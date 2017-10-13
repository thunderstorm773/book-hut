<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Book</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container">
            <div class="jumbotron">
                <form class="form-horizontal" method="post">
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="title">Title:</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="title"
                                   id="title" placeholder="Title"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="author">Author:</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="author"
                                   id="author" placeholder="Author"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="pages">Pages:</label>
                        <div class="col-sm-4">
                            <input type="number" class="form-control" name="pages" id="pages"
                                   min="1" placeholder="Pages"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-4">
                            <input type="submit" class="btn btn-success" name="add"
                                   value="Add"/>
                        </div>
                    </div>
                </form>
        </div>
        </div>
    </body>
</html>
