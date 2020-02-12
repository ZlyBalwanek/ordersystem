<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html >
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <title>Customer</title>
</head>
<body>
<%@include file="../sections/employeerNavBar.jsp"%>
<div class="container-fluid">
    <form:form method="post" action="create" modelAttribute="order">
        Klient: <form:select path="customer" items="${customerList}" itemLabel="name"/><br/>
        Kategoria: <form:select path="category" items="${categories}" itemLabel="category"/><br/>
        Usterki: <form:checkboxes path="faultSet" items="${faultList}" itemLabel="name"/><br/>
        Pracownik: <form:select path="worker" items="${userList}" itemLabel="name"/><br/>
        Numer części: <form:input path="partNumber"/><br/>
        Numer seryjny: <form:input path="serialNumber"/><br/>
        Dodatkowy opis: <form:input path="description"/><br/>
        <button type="submit">Utwórz</button>
    </form:form>
</div>
</body>
</html>