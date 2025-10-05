package com.portfolio.controller;

import com.portfolio.model.*;
import com.portfolio.service.PortfolioService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Main Controller Servlet xử lý tất cả request của Portfolio
 */
@WebServlet(name = "PortfolioController", urlPatterns = {"/", "/portfolio", "/api/*"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1,    // 1 MB
    maxFileSize = 1024 * 1024 * 10,         // 10 MB
    maxRequestSize = 1024 * 1024 * 100      // 100 MB
)
public class PortfolioController extends HttpServlet {
    
    private PortfolioService portfolioService;
    private ObjectMapper objectMapper;
    
    @Override
    public void init() throws ServletException {
        portfolioService = PortfolioService.getInstance();
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules(); // Support for Java 8+ time types
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String pathInfo = request.getPathInfo();
        String action = request.getParameter("action");
        
        // API endpoints
        if (pathInfo != null && pathInfo.startsWith("/api")) {
            handleApiRequest(request, response);
            return;
        }
        
        // Check if requesting index page
        if ("index".equals(action) || pathInfo != null && pathInfo.contains("index")) {
            loadIndexData(request, response);
            return;
        }
        
        // Default: Load trang chính với tất cả dữ liệu
        loadPortfolioData(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String pathInfo = request.getPathInfo();
        
        if (pathInfo != null && pathInfo.contains("authenticate")) {
            handleAuthentication(request, response);
        } else if (pathInfo != null && pathInfo.contains("upload")) {
            handleFileUpload(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
    /**
     * Load dữ liệu portfolio và forward tới JSP
     */
    private void loadPortfolioData(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Load tất cả dữ liệu từ service
        User user = portfolioService.getUserInfo();
        List<Skill> skills = portfolioService.getSkills();
        List<Project> projects = portfolioService.getProjects();
        List<Certificate> certificates = portfolioService.getCertificates();
        List<Assignment> assignments = portfolioService.getAssignments();
        
        // Set attributes để JSP có thể sử dụng
        request.setAttribute("user", user);
        request.setAttribute("skills", skills);
        request.setAttribute("projects", projects);
        request.setAttribute("certificates", certificates);
        request.setAttribute("assignments", assignments);
        
        // Check authentication status
        HttpSession session = request.getSession();
        Boolean isAuthenticated = (Boolean) session.getAttribute("isAuthenticated");
        request.setAttribute("isAuthenticated", isAuthenticated != null ? isAuthenticated : false);
        
        // Forward tới JSP
        request.getRequestDispatcher("/WEB-INF/views/portfolio.jsp").forward(request, response);
    }
    
    /**
     * Load dữ liệu cho index page và forward tới JSP
     */
    private void loadIndexData(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Load user info cho index page
        User user = portfolioService.getUserInfo();
        List<Skill> skills = portfolioService.getSkills();
        
        // Set attributes cho index JSP
        request.setAttribute("user", user);
        request.setAttribute("skillsCount", skills.size());
        request.setAttribute("currentTime", new java.util.Date());
        request.setAttribute("redirectDelay", 3000); // 3 seconds delay
        request.setAttribute("welcomeMessage", "Chào mừng bạn đến với Portfolio của " + user.getName() + "!");
        
        // Forward tới index JSP
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
    
    /**
     * Xử lý API requests (trả về JSON)
     */
    private void handleApiRequest(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        
        String pathInfo = request.getPathInfo();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        
        try {
            if (pathInfo.equals("/api/user")) {
                out.println(objectMapper.writeValueAsString(portfolioService.getUserInfo()));
            } else if (pathInfo.equals("/api/skills")) {
                out.println(objectMapper.writeValueAsString(portfolioService.getSkills()));
            } else if (pathInfo.equals("/api/projects")) {
                out.println(objectMapper.writeValueAsString(portfolioService.getProjects()));
            } else if (pathInfo.equals("/api/certificates")) {
                out.println(objectMapper.writeValueAsString(portfolioService.getCertificates()));
            } else if (pathInfo.equals("/api/assignments")) {
                out.println(objectMapper.writeValueAsString(portfolioService.getAssignments()));
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                out.println("{\"error\": \"API endpoint not found\"}");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
    
    /**
     * Xử lý xác thực mật khẩu
     */
    private void handleAuthentication(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        
        String password = request.getParameter("password");
        boolean isValid = portfolioService.authenticateAdmin(password);
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        if (isValid) {
            HttpSession session = request.getSession();
            session.setAttribute("isAuthenticated", true);
            session.setMaxInactiveInterval(30 * 60); // 30 phút
            
            out.println("{\"success\": true, \"message\": \"Xác thực thành công!\"}");
        } else {
            out.println("{\"success\": false, \"message\": \"Mật khẩu không đúng!\"}");
        }
    }
    
    /**
     * Xử lý upload file bài tập
     */
    private void handleFileUpload(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        
        HttpSession session = request.getSession();
        Boolean isAuthenticated = (Boolean) session.getAttribute("isAuthenticated");
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        if (isAuthenticated == null || !isAuthenticated) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            out.println("{\"success\": false, \"message\": \"Chưa xác thực!\"}");
            return;
        }
        
        try {
            // Lấy thông tin từ request
            String assignmentName = request.getParameter("assignmentName");
            if (assignmentName == null || assignmentName.trim().isEmpty()) {
                assignmentName = "Bài tập mới";
            }
            
            // Xử lý file upload
            Part filePart = request.getPart("file");
            if (filePart != null && filePart.getSize() > 0) {
                String fileName = getFileName(filePart);
                
                // Giả lập lưu file (trong thực tế sẽ lưu vào server hoặc cloud)
                boolean success = portfolioService.submitAssignment(assignmentName, fileName, "Student");
                
                if (success) {
                    out.println("{\"success\": true, \"message\": \"Upload thành công: " + fileName + "\"}");
                } else {
                    out.println("{\"success\": false, \"message\": \"Lỗi khi lưu file!\"}");
                }
            } else {
                out.println("{\"success\": false, \"message\": \"Không có file được chọn!\"}");
            }
            
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{\"success\": false, \"message\": \"Lỗi server: " + e.getMessage() + "\"}");
        }
    }
    
    /**
     * Lấy tên file từ Part
     */
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "unknown";
    }
}