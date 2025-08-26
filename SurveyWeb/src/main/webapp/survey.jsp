<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kết quả khảo sát</title>
    <style>
        /* Toàn trang */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #c8d6e5, #f1f3f6);
            padding: 40px 15px;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }

        /* Hộp kết quả */
        .result-box {
            background-color: #ffffff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(44, 62, 80, 0.15);
            max-width: 420px;
            width: 100%;
            text-align: center;
            animation: fadeIn 0.8s ease forwards;
        }

        /* Tiêu đề */
        h2 {
            color: #2c3e50;
            font-weight: 700;
            font-size: 1.8rem;
            margin-bottom: 1em;
            position: relative;
            padding-bottom: 10px;
        }
        h2::after {
            content: "✅";
            position: absolute;
            right: -30px;
            top: 50%;
            transform: translateY(-50%);
            font-size: 1.8rem;
        }

        /* Nội dung */
        p {
            font-size: 1.1rem;
            color: #34495e;
            margin: 0.6em 0;
        }
        p strong {
            color: #2c3e50;
        }

        /* Hiệu ứng mờ dần */
        @keyframes fadeIn {
            from {opacity: 0; transform: translateY(20px);}
            to {opacity: 1; transform: translateY(0);}
        }

        /* Responsive nhẹ */
        @media (max-width: 480px) {
            .result-box {
                padding: 20px 25px;
            }
            h2 {
                font-size: 1.5rem;
            }
            p {
                font-size: 1rem;
            }
        }
    </style>
</head>
<body>
    <div class="result-box">
        <h2>Kết quả khảo sát</h2>
        <p><strong>Email:</strong> ${email}</p>
    </div>
</body>
</html>