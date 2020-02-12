<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<table>
    <tr>
        <th>Numer zlecenia</th>
        <th>Klient</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id}/${order.created.year}</td>
            <td>${order.customer.name}</td>
            <td>
                <form>
                <button type="submit" formaction="/order/show/${order.id}" formmethod="get">Show</button>
                <button type="submit" formaction="/order/edit/${order.id}" formmethod="get">Update</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>