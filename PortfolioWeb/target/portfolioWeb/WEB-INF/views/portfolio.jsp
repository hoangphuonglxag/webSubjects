<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Portfolio - ${user.name}</title>
  
  <!-- CSS -->
  <link rel="stylesheet" href="/css/styles.css">

  <!-- Meta tags for SEO -->
  <meta name="description" content="Portfolio của ${user.name} - ${user.title}">
  <meta name="keywords" content="${user.name}, ${user.title}, Portfolio, Java, Web Development">
  <meta name="author" content="${user.name}">
  
</head>
<body>
  <!-- Background -->
  <div class="main-bg"></div>
  <div class="bg-pattern"></div>

  <div class="container">
    <!-- Sidebar -->
    <aside class="sidebar">
      <div class="profile-section">
        <div class="profile-avatar">
          ${user.avatar}
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
        <div class="contact-item">
          📧 ${user.email}
        </div>
        <div class="contact-item">
          📱 ${user.phone}
        </div>
        <div class="contact-item">
          📍 ${user.location}
        </div>
        <div class="contact-item">
          🌐 ${user.website}
        </div>
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

    <!-- Main content -->
    <main class="main-content">
      <!-- About Me Section -->
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
            <h3>💼 Kinh nghiệm</h3>
            <p>Tham gia phát triển các dự án web application, API development, database design và system architecture. Có khả năng làm việc nhóm và tự học hỏi công nghệ mới.</p>
          </div>
          <div class="card">
            <h3>🎓 Học vấn</h3>
            <p>Sinh viên ngành Công nghệ Thông tin với chuyên sâu về phát triển phần mềm. Liên tục cập nhật và học hỏi các công nghệ mới trong ngành.</p>
          </div>
        </div>
      </section>

      <!-- Skills Section -->
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

      <!-- Certificates Section -->
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

      <!-- Projects Section -->
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

      <!-- Assignments Section -->
      <section class="content-section" id="assignments">
        <div class="section-header">
          <div class="icon">📝</div>
          <h2>Quản lý Bài tập</h2>
        </div>

        <!-- Authentication Status -->
        <div class="auth-status ${isAuthenticated ? 'authenticated' : 'unauthenticated'}">
          <c:choose>
            <c:when test="${isAuthenticated}">
              🔓 Đã xác thực - Có thể nộp bài tập
            </c:when>
            <c:otherwise>
              🔒 Chưa xác thực - Cần nhập mật khẩu để nộp bài tập
            </c:otherwise>
          </c:choose>
        </div>

        <!-- Upload Section -->
        <div class="assignment-upload ${isAuthenticated ? '' : 'disabled'}">
          <div class="upload-icon">📤</div>
          <h3>Nộp bài tập mới</h3>
          <p><c:choose>
            <c:when test="${isAuthenticated}">Chọn file để upload bài tập</c:when>
            <c:otherwise>Cần xác thực mật khẩu để có thể upload bài tập</c:otherwise>
          </c:choose></p>
          
          <form id="uploadForm" enctype="multipart/form-data" style="display: inline;">
            <input type="file" class="file-input" id="assignmentFile" name="file" multiple accept=".pdf,.doc,.docx,.zip,.rar">
            <input type="hidden" id="assignmentName" name="assignmentName" value="">
          </form>
          
          <button class="upload-button" onclick="handleUpload()">
            <c:choose>
              <c:when test="${isAuthenticated}">📤 Nộp bài tập</c:when>
              <c:otherwise>🔒 Nộp bài tập</c:otherwise>
            </c:choose>
          </button>
        </div>

        <!-- Assignment List -->
        <div class="assignment-list">
          <div class="assignment-list-header">
            📚 Danh sách bài tập đã nộp
          </div>
          
          <c:forEach var="assignment" items="${assignments}">
            <div class="assignment-item">
              <div class="assignment-info">
                <div class="assignment-name">${assignment.name}</div>
                <div class="assignment-date">
                  <c:choose>
                    <c:when test="${assignment.submitDate != null}">
                      <fmt:formatDate value="${assignment.submitDate}" pattern="dd/MM/yyyy" var="submitDateStr"/>
                      Nộp ngày: ${submitDateStr}
                    </c:when>
                    <c:otherwise>
                      <fmt:formatDate value="${assignment.dueDate}" pattern="dd/MM/yyyy" var="dueDateStr"/>
                      Hạn nộp: ${dueDateStr}
                    </c:otherwise>
                  </c:choose>
                </div>
              </div>
              <div class="assignment-status status-${assignment.status}">
                ${assignment.statusIcon} ${assignment.statusText}
              </div>
            </div>
          </c:forEach>
        </div>
      </section>
    </main>
  </div>

  <!-- Password Modal -->
  <div id="passwordModal" class="modal">
    <div class="modal-content">
      <div class="modal-header">
        <div class="icon">🔐</div>
        <h3>Xác thực</h3>
      </div>
      <p>Vui lòng nhập mật khẩu để nộp bài tập:</p>
      <input type="password" id="passwordInput" class="password-input" placeholder="Nhập mật khẩu...">
      <div class="error-message"></div>
      <div class="modal-buttons">
        <button id="submitPassword" class="btn-submit">Xác nhận</button>
        <button id="cancelPassword" class="btn-cancel">Hủy</button>
      </div>
    </div>
  </div>

  <!-- JavaScript với JSP integration -->
  <script>
    // Global variables từ JSP
    window.contextPath = '${pageContext.request.contextPath}';
    window.isAuthenticated = ${isAuthenticated};
  </script>
  <script src="${pageContext.request.contextPath}/js/portfolio.js"></script>
</body>
</html>