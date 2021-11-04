<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages"/>
<html lang="${lang}">
<head>
    <title><fmt:message key="user.order.page.title"/></title>
</head>
<body>

<form action="/user" method="get">
    <button type="submit" ><fmt:message key="admin.cars.page.back"/></button>
</form>
<form action="/user/save_order" method="POST">
    <div>
        <input type="hidden" id="carId" name="carId" value="${carId}">
    </div>
    <div>
        <input type="hidden" id="userId" name="userId" value="${userId}">
    </div>
    <div>
        <label><fmt:message key="user.order.page.passport"/></label>
        <input type="text" id="passport" name="passport"  required/>
    </div>
    <div>
        <label><fmt:message key="user.order.page.driver"/></label>
        <input type="checkbox" id="isWithDriver" name="isWithDriver"/>
    </div>
    <div>
        <label><fmt:message key="user.order.page.start.date"/></label>
        <input type="date" id="startDate" name="startDate" required/>
    </div>
    <div>
        <label><fmt:message key="user.order.page.end.date"/></label>
        <input type="date" id="endDate" name="endDate" required/>
    </div>
    <button type="submit"><fmt:message key="registration.page.user.submit"/></button>
</form>

</body>
</html>