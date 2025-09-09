<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<h1>Cookies</h1>

<p>Here's a table with all of the cookies that this 
browser is sending to the current server.</p>

<table class="cookie-table">
  <tr>
    <th>Name</th>
    <th>Value</th>
  </tr>
  <c:forEach var="c" items="${cookie}">
  <tr>
    <td><c:out value='${c.key}'/></td>
    <td><c:out value='${c.value.value}'/></td>
  </tr>
</c:forEach>
  
</table>

<div class="links">
  <p><a class="btn-link" href="download?action=viewAlbums">View list of albums</a></p>
  <p><a class="btn-link" href="download?action=deleteCookies">Delete all persistent cookies</a></p>
</div>

</body>
</html>