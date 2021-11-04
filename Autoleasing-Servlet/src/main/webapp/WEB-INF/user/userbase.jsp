<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages"/>
<html lang="${lang}">
<head>
    <title><fmt:message key="cabinet.page.title"/></title>
</head>
<body>
<h1><fmt:message key="cabinet.page.header"/></h1>

<a href="${pageContext.request.contextPath}/logout"><fmt:message key="cabinet.page.logout.button"/></a>

<h2><fmt:message key="cabinet.page.cars.table.name"/></h2>

<form  action="/user/filter-by-brand" method="GET">
    <table>
        <tr>
            <td><fmt:message key="cabinet.page.filter.by.brand.name"/></td>
            <td>
                <select name="brand">
                    <option value="">--</option>
                    <c:forEach items="${cars}" var="car">
                        <option value="${car.brand}">${car.brand}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <button type="submit" ><fmt:message key="cabinet.page.filter.button"/></button>
            </td>
        </tr>
    </table>
</form>
<form  action="/user/filter-by-class" method="GET">
    <table>
        <tr>
            <td><fmt:message key="cabinet.page.filter.by.class.name"/></td>
            <td>
                <select name="carClass">
                    <option value="">--</option>
                    <c:forEach items="${cars}" var="car">
                        <option value="${car.carClass}">${car.carClass}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <button type="submit"><fmt:message key="cabinet.page.filter.button"/></button>
            </td>
        </tr>
    </table>
</form>
<form action="/user" method="get">
    <button type="submit"><fmt:message key="cabinet.page.filter.reset"/></button>
</form>
<table border="1">
    <tr>
        <th>
            <a href="<c:url value="/user/sort"><c:param name="sort_by" value="model"/><c:param name="dir" value="${direction}"/></c:url>">
                <fmt:message key="admin.cars.page.cars.table.car.model"/>
            </a>
        </th>
        <th><fmt:message key="admin.cars.page.cars.table.car.brand"/></th>
        <th><fmt:message key="admin.cars.page.cars.table.car.class"/></th>
        <th>
            <a href="<c:url value="/user/sort"><c:param name="sort_by" value="price"/><c:param name="dir" value="${direction}"/></c:url>">
                <fmt:message key="admin.cars.page.cars.table.car.price"/>
            </a>
        </th>
        <th><fmt:message key="admin.cars.page.cars.table.car.action"/></th>
    </tr>
    <c:forEach items="${cars}" var="car" >
    <tr>
        <td><c:out value="${car.model}" /></td>
        <td><c:out value="${car.brand}" /></td>
        <td><c:out value="${car.carClass}" /></td>
        <td><c:out value="${car.price}" /></td>
        <td>
            <a type="submit" href="<c:url value="/user/order"><c:param name="id" value="${car.id}"/></c:url>"><fmt:message key="cabinet.page.cars.table.select"/></a>
        </td>
    </tr>
    </c:forEach>
</table>


</body>
</html>