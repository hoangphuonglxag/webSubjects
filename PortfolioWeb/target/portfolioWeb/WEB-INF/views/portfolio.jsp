<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Portfolio - ${user.name}</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
  <meta name="description" content="Portfolio của ${user.name} - ${user.title}">
  <meta name="keywords" content="${user.name}, ${user.title}, Portfolio, Java, Web Development">
  <meta name="author" content="${user.name}">
</head>
<body>
  <div class="main-bg"></div>
  <div class="bg-pattern"></div>

  <div class="container">
    <aside class="sidebar">
      <div class="profile-section">
        <div class="profile-avatar">
          <img src="${pageContext.request.contextPath}/images/twentyYearsAGO.png" alt="${user.name}">
        </div>
        <div class="profile-name">${user.name}</div>
        <div class="profile-title">${user.title}</div>
        
        <div class="social-links">
          <a href="${user.facebookUrl}" class="social-link external-link" title="Facebook" target="_blank">
            <svg width="20" height="20" fill="currentColor" viewBox="0 0 24 24">
              <path d="M24 12.073c0-6.627-5.373-12-12-12s-12 5.373-12 12c0 5.99 4.388 10.954 10.125 11.854v-8.385H7.078v-3.47h3.047V9.43c0-3.007 1.792-4.669 4.533-4.669 1.312 0 2.686.235 2.686.235v2.953H15.83c-1.491 0-1.956.925-1.956 1.874v2.25h3.328l-.532 3.47h-2.796v8.385C19.612 23.027 24 18.062 24 12.073z"/>
            </svg>
          </a>
          <a href="${user.githubUrl}" class="social-link external-link" title="GitHub" target="_blank">
            <svg width="20" height="20" fill="currentColor" viewBox="0 0 24 24">
              <path d="M12 0c-6.626 0-12 5.373-12 12 0 5.302 3.438 9.8 8.207 11.387.599.111.793-.261.793-.577v-2.234c-3.338.726-4.033-1.416-4.033-1.416-.546-1.387-1.333-1.756-1.333-1.756-1.089-.745.083-.729.083-.729 1.205.084 1.839 1.237 1.839 1.237 1.07 1.834 2.807 1.304 3.492.997.107-.775.418-1.305.762-1.604-2.665-.305-5.467-1.334-5.467-5.931 0-1.311.469-2.381 1.236-3.221-.124-.303-.535-1.524.117-3.176 0 0 1.008-.322 3.301 1.23.957-.266 1.983-.399 3.003-.404 1.02.005 2.047.138 3.006.404 2.291-1.552 3.297-1.23 3.297-1.23.653 1.653.242 2.874.118 3.176.77.84 1.235 1.911 1.235 3.221 0 4.609-2.807 5.624-5.479 5.921.43.372.823 1.102.823 2.222v3.293c0 .319.192.694.801.576 4.765-1.589 8.199-6.086 8.199-11.386 0-6.627-5.373-12-12-12z"/>
            </svg>
          </a>
          <a href="mailto:${user.email}" class="social-link external-link" title="Gmail" target="_blank">
            <svg width="20" height="20" fill="currentColor" viewBox="0 0 24 24">
              <path d="M24 5.457v13.909c0 .904-.732 1.636-1.636 1.636h-3.819V11.73L12 16.64l-6.545-4.91v9.273H1.636A1.636 1.636 0 0 1 0 19.366V5.457c0-2.023 2.309-3.178 3.927-1.964L5.455 4.64 12 9.548l6.545-4.91 1.528-1.145C21.69 2.28 24 3.434 24 5.457z"/>
            </svg>
          </a>
        </div>
      </div>

      <div class="contact-info">
        <h4>Thông tin liên hệ</h4>
        <div class="contact-item">📧 ${user.email}</div>
        <div class="contact-item">📱 ${user.phone}</div>
        <div class="contact-item">📍 ${user.location}</div>
        <div class="contact-item">🌐 ${user.website}</div>
      </div>

      <nav class="nav-menu">
        <div class="menu-item active" data-section="about">
          <div class="menu-icon">👤</div>
          <span>About Me</span>
        </div>
        <div class="menu-item" data-section="skills">
          <div class="menu-icon">⚡</div>
          <span>Kỹ năng</span>
        </div>
        <div class="menu-item" data-section="certificates">
          <div class="menu-icon">🏆</div>
          <span>Bằng cấp</span>
        </div>
        <div class="menu-item" data-section="projects">
          <div class="menu-icon">🚀</div>
          <span>Dự án</span>
        </div>
        <div class="menu-item" data-section="assignments">
          <div class="menu-icon">📝</div>
          <span>Bài tập</span>
        </div>
      </nav>
    </aside>

    <main class="main-content">
      <section class="content-section active" id="about">
        <div class="section-header">
          <div class="icon">👤</div>
          <h2>About Me</h2>
        </div>
        <div class="cards-grid">
          <div class="card">
            <h3>🎯 Giới thiệu</h3>
            <p>${user.description}</p>
          </div>
          <div class="card">
            <h3>💼 Kinh nghiệm công nghệ</h3>
            <p>Phát triển ứng dụng web với Java ecosystem (Spring Boot, JSP/Servlet), quản lý cơ sở dữ liệu (PostgreSQL, MySQL, SQL Server), và xử lý big data với Apache Hadoop, Spark, Hive. Thành thạo containerization với Docker, CI/CD, và version control với Git/GitHub.</p>
          </div>
          <div class="card">
            <h3>🎓 Học vấn & chuyên môn</h3>
            <p>Sinh viên năm cuối ngành Kỹ thuật Dữ liệu với focus vào big data analytics và web development. Học tập và thực hành các công nghệ: Hadoop ecosystem, Apache Spark, data warehousing, cùng với modern web technologies và cloud deployment.</p>
          </div>
        </div>
      </section>

      <section class="content-section" id="skills">
        <div class="section-header">
          <div class="icon">⚡</div>
          <h2>Kỹ năng</h2>
        </div>
        <div class="skills-grid">
          <c:forEach var="skill" items="${skills}">
            <div class="skill-item">
              <div class="skill-icon">${skill.icon}</div>
              <h4>${skill.name}</h4>
              <p>${skill.level}</p>
            </div>
          </c:forEach>
        </div>
      </section>

      <section class="content-section" id="certificates">
        <div class="section-header">
          <div class="icon">🏆</div>
          <h2>Bằng cấp & Chứng chỉ</h2>
        </div>
        <div class="cards-grid">
          <c:forEach var="cert" items="${certificates}">
            <div class="card">
              <h3>${cert.icon} ${cert.title}</h3>
              <p><strong>${cert.institution}</strong><br>
              ${cert.year}<br>
              ${cert.description}</p>
            </div>
          </c:forEach>
        </div>
      </section>

      <section class="content-section" id="projects">
        <div class="section-header">
          <div class="icon">🚀</div>
          <h2>Dự án nổi bật</h2>
        </div>
        <c:forEach var="project" items="${projects}">
          <div class="project-item">
            <div class="project-header">
              <div>
                <div class="project-title">${project.title}</div>
                <div class="project-description">${project.description}</div>
              </div>
            </div>
            <div class="project-tags">
              <c:forEach var="tag" items="${project.tags}">
                <span class="tag">${tag}</span>
              </c:forEach>
            </div>
          </div>
        </c:forEach>
      </section>

      <section class="content-section" id="assignments">
        <div class="section-header">
          <div class="icon">📝</div>
          <h2>Bài tập đã hoàn thành</h2>
        </div>
        
        <div class="assignment-list">
          <div class="assignment-list-header">
            📚 Danh sách bài tập Web Development
          </div>

          <div class="assignment-item">
            <div class="assignment-info">
              <div class="assignment-name">🛒 Cart Shopping - Giỏ hàng trực tuyến</div>
              <div class="assignment-description">
                Ứng dụng web giỏ hàng với JSP, Servlet và cơ sở dữ liệu. 
                Tính năng: thêm sản phẩm, xem giỏ hàng, checkout.
              </div>
              <div class="assignment-tech">
                <span class="tech-tag">JSP</span>
                <span class="tech-tag">Servlet</span>
                <span class="tech-tag">MySQL</span>
                <span class="tech-tag">HTML/CSS</span>
              </div>
            </div>
            <div class="assignment-actions">
              <a href="https://github.com/hoangphuonglxag/webSubjects/tree/CartShopping" class="btn-link" target="_blank">🔗 Xem Code</a>
              <a href="https://two3133059-cartshopping.onrender.com" class="btn-demo" target="_blank">🚀 Demo</a>
            </div>
          </div>

          <div class="assignment-item">
            <div class="assignment-info">
              <div class="assignment-name">🔗 Connect Web - Kết nối cơ sở dữ liệu</div>
              <div class="assignment-description">
                Ứng dụng demo kết nối và thao tác với cơ sở dữ liệu MySQL.
                Thực hành CRUD operations cơ bản.
              </div>
              <div class="assignment-tech">
                <span class="tech-tag">JDBC</span>
                <span class="tech-tag">MySQL</span>
                <span class="tech-tag">Servlet</span>
                <span class="tech-tag">JSP</span>
              </div>
            </div>
            <div class="assignment-actions">
              <a href="https://github.com/hoangphuonglxag/webSubjects/tree/ConnectWeb" class="btn-link" target="_blank">🔗 Xem Code</a>
              <a href="http://localhost:8080/ConnectWeb" class="btn-demo" target="_blank">🚀 Demo</a>
            </div>
          </div>

          <div class="assignment-item">
            <div class="assignment-info">
              <div class="assignment-name">📥 Download Web - Quản lý tải xuống</div>
              <div class="assignment-description">
                Hệ thống quản lý file download với cookies và session management.
                Tính năng: upload, download, quản lý cookies.
              </div>
              <div class="assignment-tech">
                <span class="tech-tag">File Upload</span>
                <span class="tech-tag">Cookies</span>
                <span class="tech-tag">Session</span>
                <span class="tech-tag">JSP</span>
              </div>
            </div>
            <div class="assignment-actions">
              <a href="https://github.com/hoangphuonglxag/webSubjects/tree/DownloadWeb" class="btn-link" target="_blank">🔗 Xem Code</a>
              <a href="https://hoangphuong-ex9-1.onrender.com" class="btn-demo" target="_blank">🚀 Demo</a>
            </div>
          </div>

          <div class="assignment-item">
            <div class="assignment-info">
              <div class="assignment-name">📧 Email List MVC - Quản lý danh sách email</div>
              <div class="assignment-description">
                Ứng dụng MVC pattern để quản lý danh sách email subscribers.
                Thực hành kiến trúc Model-View-Controller.
              </div>
              <div class="assignment-tech">
                <span class="tech-tag">MVC Pattern</span>
                <span class="tech-tag">Servlet</span>
                <span class="tech-tag">JSP</span>
                <span class="tech-tag">JSTL</span>
              </div>
            </div>
            <div class="assignment-actions">
              <a href="https://github.com/hoangphuonglxag/webSubjects/tree/EmailListMVC" class="btn-link" target="_blank">🔗 Xem Code</a>
              <a href="https://websubjects-1.onrender.com" class="btn-demo" target="_blank">🚀 Demo</a>
            </div>
          </div>

          <div class="assignment-item">
            <div class="assignment-info">
              <div class="assignment-name">📊 Survey Web - Khảo sát trực tuyến</div>
              <div class="assignment-description">
                Hệ thống tạo và quản lý khảo sát trực tuyến với báo cáo thống kê.
                Form validation và data processing.
              </div>
              <div class="assignment-tech">
                <span class="tech-tag">Form Processing</span>
                <span class="tech-tag">Validation</span>
                <span class="tech-tag">Statistics</span>
                <span class="tech-tag">JSP</span>
              </div>
            </div>
            <div class="assignment-actions">
              <a href="https://github.com/hoangphuonglxag/webSubjects/tree/SurveyWeb" class="btn-link" target="_blank">🔗 Xem Code</a>
              <a href="https://websubjects2.onrender.com" class="btn-demo" target="_blank">🚀 Demo</a>
            </div>
          </div>
        </div>
      </section>
    </main>
  </div>

  <script src="${pageContext.request.contextPath}/js/portfolio.js"></script>
</body>
</html>