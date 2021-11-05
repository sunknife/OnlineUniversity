<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages"/>
<html lang="${lang}">
<head>
    <title><fmt:message key="manager.page.title"/></title>
</head>
<body>

<h1><fmt:message key="manager.page.header"/></h1>
<a href="${pageContext.request.contextPath}/logout"><fmt:message key="cabinet.page.logout.button"/></a>

<h2><fmt:message key="manager.page.table.header"/></h2>
<table border="1">
    <tr>
        <th><fmt:message key="manager.page.orders.table.user.name"/></th>
        <th><fmt:message key="manager.page.orders.table.car.name"/></th>
        <th><fmt:message key="manager.page.orders.table.user.passport"/></th>
        <th><fmt:message key="manager.page.orders.table.user.withDriver"/></th>
        <th><fmt:message key="manager.page.orders.table.order.start.date"/></th>
        <th><fmt:message key="manager.page.orders.table.order.end.date"/></th>
        <th><fmt:message key="manager.page.orders.table.order.price"/></th>
        <th><fmt:message key="manager.page.orders.table.order.is.paid"/></th>
        <th><fmt:message key="manager.page.orders.table.order.status"/></th>
        <th><fmt:message key="manager.page.orders.table.order.action"/></th>
    </tr>
    <c:forEach items="${orders}" var="order" >
    <tr>
        <td><c:out value="${order.userId}" /></td>
        <td><c:out value="${order.carId}" /></td>
        <td><c:out value="${order.passport}" /></td>
        <td><c:out value="${order.withDriver}" /></td>
        <td><c:out value="${order.startDate}" /></td>
        <td><c:out value="${order.endDate}" /></td>
        <td><c:out value="${order.price}" /></td>
        <td><c:out value="${order.paid}" /></td>
        <td><c:out value="${order.status}" /></td>
        <td>
            <form action="/manager/update" method="GET">

                <input type="hidden" name="orderId" id="orderId" value="<c:out value="${order.id}"/>">

                        <select name="newStatus">
                            <option value="${order.status}">${order.status}</option
                            <c:forEach items="${orderStatus}" var="order">
                                    <option value="${order}">${order}</option>
                            </c:forEach>
                        </select>

                <button type="submit"><fmt:message key="manager.page.orders.table.order.action.button"/></button>
            </form>
        </td>
    </tr>
    </c:forEach>
</table>

</body>
</html>