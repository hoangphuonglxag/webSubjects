<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio - ${user.name}</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #0d1117;
            color: #f0f6fc;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            margin: 0;
        }
        .redirect-box {
            text-align: center;
            padding: 2rem;
            background: #161b22;
            border-radius: 8px;
            border: 1px solid #30363d;
            max-width: 500px;
        }
        .spinner {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #30363d;
            border-top: 2px solid #58a6ff;
            border-radius: 50%;
            animation: spin 1s linear infinite;
            margin-right: 0.5rem;
        }
        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
        .btn {
            color: #58a6ff;
            text-decoration: none;
            padding: 0.5rem 1rem;
            border: 1px solid #58a6ff;
            border-radius: 4px;
            display: inline-block;
            margin-top: 1rem;
            transition: all 0.3s ease;
        }
        .btn:hover {
            background: #58a6ff;
            color: white;
        }
        .dynamic-info {
            margin: 1rem 0;
            padding: 1rem;
            background: #21262d;
            border-radius: 6px;
            border-left: 3px solid #58a6ff;
        }
        .user-info {
            display: flex;
            align-items: center;
            gap: 0.5rem;
            margin-bottom: 0.5rem;
        }
        .user-avatar {
            width: 32px;
            height: 32px;
            border-radius: 50%;
            background: #58a6ff;
            display: flex;
            align-items: center;
            justify-content: center;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="redirect-box">
        <!-- Dynamic content từ Java -->
        <c:if test="${not empty user}">
            <div class="dynamic-info">
                <div class="user-info">
                    <div class="user-avatar">${user.name.substring(0,1).toUpperCase()}</div>
                    <div>
                        <strong>${user.name}</strong><br>
                        <small style="color: #8b949e;">${user.title}</small>
                    </div>
                </div>
                <p style="font-size: 0.9rem; color: #8b949e;">
                    📧 ${user.email} | 📱 ${user.phone}
                </p>
            </div>
        </c:if>
        
        <div style="font-size: 1.2rem; margin-bottom: 1rem;">
            <div class="spinner"></div>
            Đang chuyển hướng đến Portfolio...
        </div>
        
        <p>Chào mừng bạn đến với Portfolio của 
            <strong style="color: #58a6ff;">
                <c:choose>
                    <c:when test="${not empty user}">
                        ${user.name}
                    </c:when>
                    <c:otherwise>
                        Developer
                    </c:otherwise>
                </c:choose>
            </strong>
        </p>
        
        <p>Nếu không tự động chuyển hướng:</p>
        <a href="./" class="btn">🚀 Mở Portfolio</a>
        
        <hr style="margin: 2rem 0; border: none; border-top: 1px solid #30363d;">
        
        <h3>📋 Thông tin dự án</h3>
        <div style="display: grid; grid-template-columns: repeat(2, 1fr); gap: 1rem; text-align: left;">
            <div>
                <strong>Framework:</strong> Java MVC<br>
                <strong>Server:</strong> Jetty 11.0.15<br>
                <strong>View:</strong> JSP + JSTL
            </div>
            <div>
                <strong>API:</strong> RESTful<br>
                <strong>Auth:</strong> Session-based<br>
                <strong>Upload:</strong> Multipart
            </div>
        </div>
        
        <!-- Dynamic skills count -->
        <c:if test="${not empty skillsCount}">
            <div class="dynamic-info">
                <p>💻 <strong>${skillsCount}</strong> kỹ năng lập trình được tích hợp</p>
            </div>
        </c:if>
        
        <div style="margin-top: 1.5rem; font-size: 0.9rem; color: #8b949e;">
            <p>💡 <strong>URL:</strong> http://localhost:8080/portfolio</p>
            <p>📅 Khởi tạo: <fmt:formatDate value="${currentTime}" pattern="dd/MM/yyyy HH:mm"/></p>
        </div>
    </div>
    
    <script>
        // Dynamic redirect delay từ server
        var redirectDelay = <c:out value="${not empty redirectDelay ? redirectDelay : 2000}"/>;
        
        setTimeout(function() {
            window.location.href = './';
        }, redirectDelay);
        
        // Show dynamic message
        <c:if test="${not empty welcomeMessage}">
            console.log('<c:out value="${welcomeMessage}" escapeXml="false"/>');
        </c:if>
    </script>
</body>
</html>