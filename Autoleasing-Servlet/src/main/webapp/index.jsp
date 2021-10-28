<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages"/>
<html lang="${lang}">
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2 ><fmt:message key="first.message"/></h2>
    <a href="?lang=en">English</a>
    <a href="?lang=ua">Українська</a>
    <a href="servlet">See servlet</a>

</body>
</html>