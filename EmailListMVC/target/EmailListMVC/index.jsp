<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>23133059 - Hoang Phuong</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Join our email list</h1>
    <p>To join our email list, enter your name and email address below.</p>

    <form action="emailList" method="post">
        <input type="hidden" name="action" value="add">

        <div class="form-row">
            <label for="email">Email:</label>   
            <input type="email" name="email" id="email" required>
        </div>

        <div class="form-row">
            <label for="firstName">First Name:</label>
            <input type="text" name="firstName" id="firstName" required>
        </div>

        <div class="form-row">
            <label for="lastName">Last Name:</label>
            <input type="text" name="lastName" id="lastName" required>
        </div>

        <div class="form-row">
            <label>&nbsp;</label>
            <input type="submit" value="Join Now" id="submit">
        </div>
    </form>
</body>
</html>
<%@ include file="footer.jsp" %>