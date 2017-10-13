<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Sign In</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
    <jsp:include page="menu.jsp"/>
    <div class="container">
        <div class="jumbotron">
            <form class="form-horizontal" method="post">
                <div class="form-group">
                    <label class="control-label col-sm-4" for="username">Username:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="username"
                               id="username" placeholder="Username"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-4" for="password">Password:</label>
                    <div class="col-sm-4">
                        <input type="password" class="form-control" name="password"
                               id="password" placeholder="Password"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-4">
                        <input type="submit" class="btn btn-success" name="sign-in"
                               value="Sign In"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
    </body>
</html>
