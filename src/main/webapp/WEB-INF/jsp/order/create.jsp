<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" action="create" modelAttribute="order">
    Klient: <form:select path="customer" items="${customerList}" itemLabel="name"/><br/>
    Kateogria: <form:select path="category" items="${categoryList}" itemLabel="name"/><br/>
    Usterki: <form:checkboxes path="faultSet" items="${faultList}" itemLabel="name"/><br/>
    Pracownik: <form:select path="worker" items="${userList}" itemLabel="name"/><br/>
    Numer części: <form:input path="partNumber"/><br/>
    Numer seryjny: <form:input path="serialNumber"/><br/>
    Dodatkowy opis: <form:input path="description"/><br/>
    <button type="submit">Utwórz</button>
</form:form>