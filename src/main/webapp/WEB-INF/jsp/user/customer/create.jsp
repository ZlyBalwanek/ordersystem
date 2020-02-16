<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" action="createCustomer" modelAttribute="customer">
    Nazwa: <form:input path="name"/><br/>
    E-mail: <form:input path="emial"/><br/>
    Warsztat: <form:select path="workshop">
    <option value="true">Tak</option>
    <option value="false">Nie</option>
</form:select><br/>
    Numer tel 1:<input type="number" name="phone1"/><br/>
    Numer tel 2:<input type="number" name="phone2" value="-1"/><br/>
    <button type="submit">Utwórz</button>
</form:form>