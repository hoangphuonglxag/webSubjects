<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Checkout - Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css" />
</head>
<body>
    <h1>Your Shopping Cart</h1>

    <c:choose>
        <c:when test="${not empty sessionScope.cart and sessionScope.cart.count > 0}">
            <table class="cart-table" border="1" cellpadding="5" cellspacing="0">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Description</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Subtotal</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${sessionScope.cart.items}">
                        <tr>
                            <td>${item.product.code}</td>
                            <td>${item.product.description}</td>
                            <td>${item.quantity}</td>
                            <td>${item.product.priceCurrencyFormat}</td>
                            <td>${item.totalCurrencyFormat}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <h3>Total: ${sessionScope.cart.totalCurrencyFormat}</h3>
        </c:when>
        <c:otherwise>
            <p>Your cart is empty.</p>
        </c:otherwise>
    </c:choose>

    <form action="index.jsp" method="get">
        <input type="submit" value="Back" />
    </form>
</body>
</html>