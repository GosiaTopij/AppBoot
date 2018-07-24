<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Cache-Control" content="no-cache">
        <meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
        <title>Register </title>
        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/css/style.css" rel="stylesheet">
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    </head>

    <body>
        <div role="navigation">
            <div class="navbar navbar-inverse">
                <a href="/welcome" class="navbar-brand">Home</a>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/login">Login</a></li>
                        <li><a href="/register">New Registration</a></li>
                        <li><a href="/all-users">All Users</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <c:choose>
            <c:when test="${mode=='MODE_HOME'}">

        <div class="container" id="homediv">
            <div class="jumbotron text-center">
                <h1>Welcome to My Website</h1>
                <h3>Sign in or Register</h3>
            </div>
        </div>
            </c:when>

            <c:when test="${mode=='MODE_REGISTER' }">
                <div class="container text-center">
                    <h3>New Registration</h3>
                    <hr>
                    <form class="form-horizontal" method="POST" action="save-user">
                        <input type="hidden" name="id" value="${user.id }" />
                        <div class="form-group">
                            <label class="control-label col-md-3">Username</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="username"
                                       value="${user.username }" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">First Name</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="firstname"
                                       value="${user.firstname }" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Last Name</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="lastname"
                                       value="${user.lastname }" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Age </label>
                            <div class="col-md-3">
                                <input type="text" class="form-control" name="age"
                                       value="${user.age }" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Password</label>
                            <div class="col-md-7">
                                <input type="password" class="form-control" name="password"
                                       value="${user.password }" />
                            </div>
                        </div>
                        <div class="form-group ">
                            <input type="submit" class="btn btn-primary" value="Register" />
                        </div>
                    </form>
                </div>
            </c:when>

            <c:when test="${mode=='ALL_USERS' }">
                <div class="container text-center" id="tasksDiv">
                    <h3>All Users</h3>
                    <hr>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>UserName</th>
                                <th>First Name</th>
                                <th>LastName</th>
                                <th>Age</th>
                                <th>Delete</th>
                                <th>Edit</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${users }">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.username}</td>
                                    <td>${user.firstname}</td>
                                    <td>${user.lastname}</td>
                                    <td>${user.age}</td>
                                    <td><a href="/delete-user?id=${user.id }"><span
                                        class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
                                    <td><a href="/edit-user?id=${user.id }"><span
                                        class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>


            <c:when test="${mode=='MODE_UPDATE' }">
                <div class="container text-center">
                    <h3>Update User</h3>
                    <hr>
                    <form class="form-horizontal" method="POST" action="save-user">
                        <input type="hidden" name="id" value="${user.id }" />
                        <div class="form-group">
                            <label class="control-label col-md-3">Username</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="username"
                                       value="${user.username }" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">First Name</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="firstname"
                                       value="${user.firstname }" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Last Name</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="lastname"
                                       value="${user.lastname }" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Age </label>
                            <div class="col-md-3">
                                <input type="text" class="form-control" name="age"
                                       value="${user.age }" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Password</label>
                            <div class="col-md-7">
                                <input type="password" class="form-control" name="password"
                                       value="${user.password }" />
                            </div>
                        </div>
                        <div class="form-group ">
                            <input type="submit" class="btn btn-primary" value="Update" />
                        </div>
                    </form>
                </div>
            </c:when>

        </c:choose>

        <script src="static/js/jquery-1.11.1.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>
    </body>
</html>