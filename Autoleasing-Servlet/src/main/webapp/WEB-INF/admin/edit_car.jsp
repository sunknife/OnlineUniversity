<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages"/>
<html lang="${lang}">
<head>
    <title><fmt:message key="edit.car.page.title"/></title>
</head>
<body>

<h1><fmt:message key="edit.car.page.header"/></h1>
<form  action="/admin/cars/save_edit_car" method="POST">
    <div>
        <input type="hidden" id="id" name="id" value="${edit_car.id}">
    </div>
    <div>
        <label><fmt:message key="add.car.page.car.model"/></label>
        <input type="text" id="model" name="model" value="${edit_car.model}"  required/>
    </div>
    <div>
        <label><fmt:message key="add.car.page.car.brand"/></label>
        <input type="text" id="brand" name="brand"  value="${edit_car.brand}" required/>
    </div>
    <div>
        <label><fmt:message key="add.car.page.car.class"/></label>
        <select name="carClass">
                <option>${edit_car.carClass}</option>
        <c:forEach items = "${carClassValues}" var="carClassOpt">
                <option value="${carClassOpt}">${carClassOpt}</option>
        </c:forEach>
        </select>
    </div>
    <div>
        <label><fmt:message key="add.car.page.car.price"/></label>
        <input type="number" step="0.01" min="0" id="price" name="price" value="${edit_car.price}" required/>
    </div>
    <button type="submit"><fmt:message key="registration.page.user.submit"/></button>
</form>
<form action="/admin/cars" method="get">
    <button type="submit" ><fmt:message key="admin.cars.page.back"/></button>
</form>

</body>
</html>