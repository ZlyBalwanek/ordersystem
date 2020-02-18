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
    <title>Tworzenie zlecenia</title>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <a class="navbar-brand" style="color: deepskyblue">Order System</a>
    <div class="collapse navbar-collapse" id="navbarsExample03">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Utwórz</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="/order/create">Zlecenie</a>
                    <a class="dropdown-item" href="/customer/create">Klienta</a>
                    <a class="dropdown-item" href="/fault/create">Usterka</a>
                    <a class="dropdown-item" href="/pas/create">Cześć/Usługę</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Lista zleceń</a>
                <div class="dropdown-menu" aria-labelledby="dropdown02">
                    <a class="dropdown-item" href="/order/showOpen">Otwarte</a>
                    <a class="dropdown-item" href="/order/showAll">Wszystkie</a>
                    <a class="dropdown-item" href="/order/setDataRange">Z okresu</a>
                    <a class="dropdown-item" href="/order/setEmployee">Pracownika</a>
                </div>
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
    <div id="welcome-div">

        <form:form method="post" action="create" modelAttribute="order">
            Klient: <form:select path="customer" items="${customerList}" itemLabel="name"/><br/>
            Kategoria: <form:select path="category" items="${categories}" itemLabel="category"/><br/>
            Usterki: <form:checkboxes path="faultSet" items="${faultList}" itemLabel="name"/><br/>
            Pracownik: <form:select path="employee" items="${userList}" itemLabel="name"/><br/>
            Numer części: <form:input path="partNumber"/><br/>
            Numer seryjny: <form:input path="serialNumber"/><br/>
            Dodatkowy opis: <form:input path="description"/><br/>
            <button type="submit">Utwórz</button>
        </form:form>

    </div>
</div>
</body>
</html>