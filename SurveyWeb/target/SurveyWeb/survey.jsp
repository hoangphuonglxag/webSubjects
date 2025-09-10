<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Survey Result</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: #fff5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-size: 85%;
        }

        .result-box {
            background-color: #ffffff;
            padding: 25px 35px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(220, 20, 60, 0.3); /* crimson */
            max-width: 420px;
            width: 100%;
            text-align: left;
            animation: fadeIn 0.8s ease forwards;
        }

        h2 {
            font-size: 160%;
            color: #b22222; /* firebrick */
            margin-bottom: 0.8em;
            text-align: center;
            border-bottom: 2px solid #a52a2a; /* brown */
            padding-bottom: 0.2em;
        }

        p {
            font-size: 1rem;
            color: #333;
            margin: 0.6em 0;
        }

        p strong {
            color: #800000; /* maroon */
        }

        .thank-you {
            margin-top: 20px;
            font-style: italic;
            color: #006400; /* dark green for positive feedback */
            font-weight: bold;
            text-align: center;
        }

        @keyframes fadeIn {
            from {opacity: 0; transform: translateY(20px);}
            to {opacity: 1; transform: translateY(0);}
        }
    </style>
</head>
<body>
    <div class="result-box">
        <h2>Survey result</h2>

        <p><strong>Full name:</strong> ${user.lastName} ${user.firstName}</p>
        <p><strong>Email:</strong> ${user.email}</p>
        <p><strong>Date of birth:</strong> ${user.dob}</p>
        <p><strong>Heard about us From:</strong> ${user.heardFrom}</p>
        
        <p><strong>Wants updates:</strong> 
            <c:choose>
                <c:when test="${not empty user.wantsUpdates}">
                    Yes
                </c:when>
                <c:otherwise>
                    No
                </c:otherwise>
            </c:choose>
        </p>

        <!-- Chỉ hiển thị Contact Via nếu người dùng muốn nhận cập nhật -->
        <c:if test="${not empty user.wantsUpdates}">
            <p><strong>Preferred contact method:</strong> ${user.contactVia}</p>
        </c:if>

        <p><strong>Email consent:</strong> 
            <c:choose>
                <c:when test="${not empty user.agreeEmailContact}">
                    Yes
                </c:when>
                <c:otherwise>
                    No
                </c:otherwise>
            </c:choose>
        </p>

        <p class="thank-you">Thank you for participating in our survey!</p>
        <div style="text-align: center; margin-top: 20px;">
    <form action="index.html" method="get">
        <button type="submit" style="
            background-color: #b22222;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1rem;
        ">
            Return to Survey
        </button>
    </form>
</div>
    </div>
</body>
</html>