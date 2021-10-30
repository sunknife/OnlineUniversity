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
<a href="${pageContext.request.contextPath}/logout"><fmt:message key="cabinet.page.logout.button"/></a>
</body>
</html>