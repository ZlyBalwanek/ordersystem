<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <title>Edycja ${order.id}/${order.created.year}</title>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <a class="navbar-brand" style="color: deepskyblue" href="/employees/index">Order System</a>
    <div class="collapse navbar-collapse" id="navbarsExample03">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Otwórz zlecenie</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="#">Po numerze</a>
                    <a class="dropdown-item" href="#">Otwarte</a>
                    <a class="dropdown-item" href="/employees/showOpenEmployee">Twoje otwarte</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Lista zleceń</a>
                <div class="dropdown-menu" aria-labelledby="dropdown02">
                    <a class="dropdown-item" href="#">Z bierzącego miesiąca</a>
                    <a class="dropdown-item" href="#">Z okresu</a>
                </div>
            </li>
            <form class="form-inline mt-2 mt-md-0">
                <button class="btn btn-primary my-2 my-sm-0" type="submit">Log out</button>
            </form>
        </ul>
    </div>
</nav>
<div class="container-fluid">

    <form id="order-accept">
        <p id="order-info">
            Czy chcesz przypisać sobie zlecenie?<br/>
            O numerze: ${order.id}/${order.created.year}<br/>
            Dla klienta: ${order.customer.name}<br/>
            P/N: ${order.partNumber}<br/>
            O usterkach:
            <c:forEach items="${order.faultSet}" var="fault">
                - ${fault}<br/>
            </c:forEach>
        </p>
        <button type="submit" formmethod="get" formaction="/employees/editOrder" style="background-color: limegreen">
            TAK
        </button>
        <button type="submit" formmethod="get" formaction="/employees/index" style="background-color: red">NIE</button>
    </form>

</div>
</body>
</html>