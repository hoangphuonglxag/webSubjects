<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Thanks for Joining</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Thanks for joining our email list</h1>

    <p>Here is the information that you entered:</p>
    <div class="user-info">
        <p><strong>Email:</strong> ${user.email}</p>
        <p><strong>First Name:</strong> ${user.firstName}</p>
        <p><strong>Last Name:</strong> ${user.lastName}</p>
    </div>

    <p>To enter another email address, click the Back button in your browser or the Return button below.</p>

    <form action="index.jsp" method="get">
        <input type="submit" value="Return" id="submit">
    </form>
</body>
</html>
<%@ include file="footer.jsp" %>