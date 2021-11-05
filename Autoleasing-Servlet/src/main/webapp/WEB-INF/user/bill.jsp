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

<form action="/user/bill" method="POST">
    <div>
        <label><fmt:message key="bill.page.car.name"/></label>
        ${carName}
    </div>
    <div>
        <label><fmt:message key="bill.page.car.price"/></label>
        ${carPrice}
    </div>
    <div>
        <label><fmt:message key="bill.page.is.with.driver"/></label>
        ${driverOption}
    </div>
    <div>
        <label><fmt:message key="bill.page.order.duration"/></label>
        ${orderDuration}
    </div>
    <br>
    <div>
        <strong><fmt:message key="bill.page.order.price"/></strong>
        <strong>${totalPrice}$</strong>
    </div>
    <button type="submit"><fmt:message key="bill.page.pay"/></button>
</form>

</body>
</html>