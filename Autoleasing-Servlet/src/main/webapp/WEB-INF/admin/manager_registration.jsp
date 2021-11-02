<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages"/>
<html lang="${lang}">
<head>
    <title><fmt:message key="registration.page.title"/></title>
</head>
<body>
<h1><fmt:message key="manager.registration.page.header"/></h1>

<form action="/admin" method="get">
  <button type="submit" ><fmt:message key="admin.cars.page.back"/></button>
</form>
<form action="/admin/save_manager" method="POST">
  <div>
    <label><fmt:message key="registration.page.user.firstName"/></label>
    <input type="text" id="firstName" name="firstName"  required/>
  </div>
  <div>
    <label><fmt:message key="registration.page.user.lastName"/></label>
    <input type="text" id="lastName" name="lastName" required/>
  </div>
  <div>
    <label><fmt:message key="registration.page.user.email"/></label>
    <input type="text" id="email" name="email" required/>
  </div>
  <div>
    <label><fmt:message key="registration.page.user.password"/></label>
    <input type="password" id="password" name="password" required/>
  </div>
  <button type="submit"><fmt:message key="registration.page.user.submit"/></button>
</form>


</body>
</html>