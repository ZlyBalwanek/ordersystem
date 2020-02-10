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
    <title>${order.id}/${order.created.year}</title>
</head>
<body>
<div class="container-fluid">
    <div id="order-status">
        <c:forEach items="${order.operationSet}" var="status" begin="${order.operationSet}.size()-1">
            Status: ${status}
        </c:forEach>
    </div>
    <div id="order-id">
        Zlecenie: ${order.id}/${order.created.year}
    </div>
    <div id="order-partNumber">
        Numer części: ${order.partNumber}
    </div>
    <div id="order-partAndServices">
        <c:forEach items="${order.orderPartAndServiceSet}" var="opas">
            ${opas.name}-${opas.cost}<br/>
        </c:forEach>
    </div>
</div>
</body>
</html>