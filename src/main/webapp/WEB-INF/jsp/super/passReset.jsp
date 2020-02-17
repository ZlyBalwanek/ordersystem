<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <title>Resetowanie hasła dla ${user.name}</title>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <a class="navbar-brand" style="color: deepskyblue">Order System</a>
    <div class="collapse navbar-collapse" id="navbarsExample03">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/master/of/order/create">Dodaj użytkowika<span
                        class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/master/of/order/show">Użytkownicy<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <form class="form-inline mt-2 mt-md-0">
                <button class="btn btn-primary my-2 my-sm-0" type="submit" formaction="/logout">Log out</button>
            </form>
        </ul>
    </div>
</nav>
<div class="container-fluid">
    <div id="resetPassword-div">

        <form:form modelAttribute="user" action="/master/of/order/passReset" method="post">
            Nowe hasło: <form:password path="password"/><br/>
            <form:hidden path="id" value="${user.id}"/>
            <button type="submit">Ustaw</button>
        </form:form>

    </div>
</div>
</body>
</html>