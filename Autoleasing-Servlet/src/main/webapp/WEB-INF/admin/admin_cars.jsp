<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages"/>
<html lang="${lang}">
<head>
    <title><fmt:message key="admin.page.title"/></title>
</head>
<body>

<form action="/admin" method="get">
    <button type="submit"><fmt:message key="admin.cars.page.back"/></button>
</form>
<h2><fmt:message key="admin.cars.page.cars.table.name"/></h2>
<table border="1">
    <tr>
        <th><fmt:message key="admin.cars.page.cars.table.car.model"/></th>
        <th><fmt:message key="admin.cars.page.cars.table.car.brand"/></th>
        <th><fmt:message key="admin.cars.page.cars.table.car.class"/></th>
        <th><fmt:message key="admin.cars.page.cars.table.car.price"/></th>
        <th><fmt:message key="admin.cars.page.cars.table.car.action"/></th>
    </tr>
    <c:forEach items="${cars}" var="car" >
    <tr>
        <td><c:out value="${car.model}" /></td>
        <td><c:out value="${car.brand}" /></td>
        <td><c:out value="${car.carClass}" /></td>
        <td><c:out value="${car.price}" /></td>
        <td>
            <a type="submit" href="<c:url value="/admin/cars/edit"><c:param name="id" value="${car.id}"/></c:url>"><fmt:message key="admin.cars.page.cars.table.car.action.edit"/></a>
            <a type="submit" href="<c:url value="/admin/cars/delete"><c:param name="id" value="${car.id}"/></c:url>"><fmt:message key="admin.cars.page.cars.table.car.action.delete"/></a>
        </td>
    </tr>
    </c:forEach>

</table>
<form action="/auth/admin/addcar" method="get">
    <button type="submit"><fmt:message key="admin.cars.page.cars.table.car.add.car"/></button>
</form>

</body>
</html>