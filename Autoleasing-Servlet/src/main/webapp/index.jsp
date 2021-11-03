<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages"/>
<html lang="${lang}">
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2 ><fmt:message key="main.page.header"/></h2>
    <a href="?lang=en"><fmt:message key="english.button.text"/></a>
    <a href="?lang=ua"><fmt:message key="ukrainian.button.text"/></a>
    <br/>
    <a href="${pageContext.request.contextPath}/login"><fmt:message key="main.page.login"/></a>

</body>
</html>