<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages"/>
<html lang="${lang}">
<head>
    <title><fmt:message key="login.page.header"/></title>
    <meta charset="UTF-8">
</head>
<body>
    <h2><fmt:message key="login.page.header"/></h2>
    <form method="POST" action="${pageContext.request.contextPath}/login">
         <label for="username"><fmt:message key="login.page.username.input"/></label>
         <input type="text" name="username">
         <br/>
         <label for="password"><fmt:message key="login.page.password.input"/></label>
         <input type="password" name="password">
         <br/><br/>
         <fmt:message key="login.page.signin.button" var="submitButton"/>
         <input class="button" type="submit" value="${submitButton}">
    </form>
    <br/>
    <a href="${pageContext.request.contextPath}/logout"><fmt:message key="admin.cars.page.back"/></a>

</body>
</html>