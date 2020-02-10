<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${faults}" var="f">
    ${f.name}<br/>
</c:forEach>