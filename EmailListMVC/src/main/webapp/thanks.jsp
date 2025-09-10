<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Thanks for Joining</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css" type="text/css" />
</head>
<body>
    <h1>Thanks for joining our email list</h1>

    <p>Here is the information that you entered:</p>
    <div class="user-info">
        <p><strong>Email:</strong> ${requestScope.user.email}</p>
        <p><strong>First Name:</strong> ${requestScope.user.firstName}</p>
        <p><strong>Last Name:</strong> ${requestScope.user.lastName}</p>
    </div>

    <p>Current Year: ${requestScope.currentYear}</p>
    <p>Customer Service Email: ${applicationScope.custServEmail}</p>

    <h2>First two users in the system:</h2>
    <c:if test="${not empty users}">
        <c:forEach var="u" items="${users}" varStatus="status">
            <c:if test="${status.index lt 2}">
                <p>${u.firstName} ${u.lastName} (${u.email})</p>
            </c:if>
        </c:forEach>
    </c:if>

    <form action="index.jsp" method="get">
        <input type="submit" value="Return" id="submit" />
    </form>
</body>
</html>

<%@ include file="footer.jsp" %>