<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<% String pattern = "EEEEE dd MMMMM yyyy";
    SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat(pattern, new Locale("pl", "PL"));

    String date = simpleDateFormat.format(new Date());%>

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
    <title>${title} admin</title>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Order System</a>
    <div class="collapse navbar-collapse" id="navbarsExample03">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Utwórz</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="/employees/findOrder">Zlecenie</a>
                    <a class="dropdown-item" href="/employees/showOpen">Klienta</a>
                    <a class="dropdown-item" href="/employees/showOpen">Usterka</a>
                    <a class="dropdown-item" href="/employees/showOpen">Cześć/Usługę</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Lista zleceń</a>
                <div class="dropdown-menu" aria-labelledby="dropdown02">
                    <a class="dropdown-item" href="/employees/showMonthly">Otwarte</a>
                    <a class="dropdown-item" href="/employees/showMonthly">Wszystkie</a>
                    <a class="dropdown-item" href="/employees/setDataRange">Z okresu</a>
                    <a class="dropdown-item" href="/employees/setDataRange">Pracownika</a>
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

        <h1 id="welcome-text">Witaj admin</h1><br/>
        <p id="welcome-date">Dzisiaj jest <%=date%></p>

    </div>
</div>
</body>
</html>