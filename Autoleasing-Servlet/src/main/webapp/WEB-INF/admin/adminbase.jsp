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

<h1><fmt:message key="admin.page.header"/></h1>
<br>
<a href="${pageContext.request.contextPath}/logout"><fmt:message key="cabinet.page.logout.button"/></a>
<form action="/admin/cars" method="get">
    <button type="submit" ><fmt:message key="admin.page.cars.menu.button"/></button>
</form>
<h2><fmt:message key="admin.page.users.table.name"/></h2>
<table border="1">
    <tr>
        <th><fmt:message key="admin.page.users.table.user.name"/></th>
        <th><fmt:message key="admin.page.users.table.user.surname"/></th>
        <th><fmt:message key="admin.page.users.table.user.email"/></th>
        <th><fmt:message key="admin.page.users.table.user.password"/></th>
        <th><fmt:message key="admin.page.users.table.user.role"/></th>
        <th><fmt:message key="admin.page.users.table.user.status"/></th>
        <th><fmt:message key="admin.page.users.table.user.status.table.action"/></th>
    </tr>
    <c:forEach items="${users}" var="user" >
        <tr>
            <td><c:out value="${user.firstName}" /></td>
            <td><c:out value="${user.lastName}" /></td>
            <td><c:out value="${user.email}" /></td>
            <td><c:out value="${user.password}" /></td>
            <td><c:out value="${user.role}" /></td>
            <td><c:out value="${user.status}" /></td>
            <td>
                        <a type="submit" href="<c:url value="/admin/ban"><c:param name="id" value="${user.id}"/></c:url>">
                                                    <fmt:message key="admin.page.users.table.user.status.button.action"/></a>
                        <a type="submit" href="<c:url value="/admin/unblock"><c:param name="id" value="${user.id}"/></c:url>">
                                    <fmt:message key="admin.page.users.table.user.status.button.action.unblock"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="/admin/add_manager" method="get">
    <button type="submit"><fmt:message key="admin.page.add.manager.button"/></button>
</form>

</body>
</html>