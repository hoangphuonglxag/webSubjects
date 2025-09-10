<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<h1>List of albums</h1>

<c:if test="${cookie.firstNameCookie.value != null}">
    <p class="welcome-message">Welcome back, <c:out value='${cookie.firstNameCookie.value}'/></p>
</c:if>

<table class="album-table">
    <thead>
        <tr>
            <th>#</th>
            <th>Album Title</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>86 (the band) - True Life Songs and Pictures</td>
            <td><a class="btn-link" href="download?action=checkUser&productCode=8601">Download</a></td>
        </tr>
        <tr>
            <td>2</td>
            <td>Paddlefoot - The First CD</td>
            <td><a class="btn-link" href="download?action=checkUser&productCode=pf01">Download</a></td>
        </tr>
        <tr>
            <td>3</td>
            <td>Paddlefoot - The Second CD</td>
            <td><a class="btn-link" href="download?action=checkUser&productCode=pf02">Download</a></td>
        </tr>
        <tr>
            <td>4</td>
            <td>Joe Rut - Genuine Wood Grained Finish</td>
            <td><a class="btn-link" href="download?action=checkUser&productCode=jr01">Download</a></td>
        </tr>
    </tbody>
</table>

</body>
</html>