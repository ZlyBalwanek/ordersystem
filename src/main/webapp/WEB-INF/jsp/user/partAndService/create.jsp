<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" action="createPas" modelAttribute="pas">
    Nazwa: <form:input path="name"/><br/>
    Część: <form:select path="part">
    <option value="true">Tak</option>
    <option value="false">Nie</option>
</form:select>
    Cena: <form:input path="price" value="0"/>
    <button type="submit">Utwórz</button>
</form:form>