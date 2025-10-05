package com.portfolio.service;

import com.portfolio.model.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Service class để quản lý tất cả dữ liệu portfolio
 * Trong thực tế sẽ kết nối database, ở đây dùng dữ liệu hardcode
 */
public class PortfolioService {
    
    private static PortfolioService instance;
    private static final String ADMIN_PASSWORD = "admin123";
    
    private PortfolioService() {}
    
    public static PortfolioService getInstance() {
        if (instance == null) {
            instance = new PortfolioService();
        }
        return instance;
    }
    
    /**
     * Lấy thông tin user
     */
    public User getUserInfo() {
        return new User(); // Sử dụng constructor với dữ liệu mặc định
    }
    
    /**
     * Lấy danh sách kỹ năng
     */
    public List<Skill> getSkills() {
        List<Skill> skills = new ArrayList<>();
        
        skills.add(new Skill("React.js", "Advanced", "⚛️", "JavaScript library for building user interfaces"));
        skills.add(new Skill("Node.js", "Advanced", "📗", "JavaScript runtime for server-side development"));
        skills.add(new Skill("Python", "Intermediate", "🐍", "High-level programming language"));
        skills.add(new Skill("MongoDB", "Intermediate", "🗄️", "NoSQL document database"));
        skills.add(new Skill("AWS", "Intermediate", "☁️", "Amazon Web Services cloud platform"));
        skills.add(new Skill("Docker", "Beginner", "🐳", "Containerization platform"));
        skills.add(new Skill("MySQL", "Intermediate", "💾", "Relational database management system"));
        skills.add(new Skill("Express.js", "Advanced", "🔥", "Web application framework for Node.js"));
        
        return skills;
    }
    
    /**
     * Lấy danh sách dự án
     */
    public List<Project> getProjects() {
        List<Project> projects = new ArrayList<>();
        
        Project ecommerce = new Project();
        ecommerce.setTitle("E-Commerce Platform");
        ecommerce.setDescription("Nền tảng thương mại điện tử full-stack với React frontend và Node.js backend. Tích hợp thanh toán trực tuyến, quản lý sản phẩm và hệ thống đánh giá.");
        ecommerce.setTags(Arrays.asList("React", "Node.js", "MongoDB", "Stripe API"));
        
        Project taskManagement = new Project();
        taskManagement.setTitle("Task Management System");
        taskManagement.setDescription("Ứng dụng quản lý công việc cho nhóm với real-time collaboration. Sử dụng Socket.io cho chat và cập nhật trạng thái live.");
        taskManagement.setTags(Arrays.asList("Vue.js", "Express", "Socket.io", "PostgreSQL"));
        
        Project portfolio = new Project();
        portfolio.setTitle("Portfolio Website");
        portfolio.setDescription("Website portfolio cá nhân với thiết kế hiện đại, responsive và tính năng xác thực. Sử dụng Java Servlet, JSP và MySQL.");
        portfolio.setTags(Arrays.asList("Java", "JSP", "Servlet", "MySQL", "Responsive"));
        
        projects.add(ecommerce);
        projects.add(taskManagement);
        projects.add(portfolio);
        
        return projects;
    }
    
    /**
     * Lấy danh sách chứng chỉ
     */
    public List<Certificate> getCertificates() {
        List<Certificate> certificates = new ArrayList<>();
        
        certificates.add(new Certificate(
            "Sinh viên Công nghệ Thông tin",
            "Đại học ABC (2021-2025)",
            "2021-2025",
            "Chuyên ngành: Phát triển phần mềm",
            "🎓"
        ));
        
        certificates.add(new Certificate(
            "Full-Stack Web Development",
            "Udemy, Coursera (2023)",
            "2023",
            "JavaScript, React, Node.js, Database",
            "💻"
        ));
        
        certificates.add(new Certificate(
            "Responsive Web Design",
            "FreeCodeCamp (2022)",
            "2022",
            "HTML, CSS, JavaScript fundamentals",
            "🌐"
        ));
        
        return certificates;
    }
    
    /**
     * Lấy danh sách bài tập
     */
    public List<Assignment> getAssignments() {
        List<Assignment> assignments = new ArrayList<>();
        
        // Assignment 1: 🌐 DownloadWeb
        Assignment assignment1 = new Assignment(
            "🌐 DownloadWeb", 
            "Ứng dụng web hỗ trợ download file với giao diện thân thiện", 
            LocalDate.of(2024, 3, 15), 
            "completed"
        );
        assignment1.setFileUrl("https://hoangphuong-ex9-1.onrender.com/");
        assignment1.setSubmitDate(LocalDate.of(2024, 3, 15));
        assignment1.setSubmittedBy("Đinh Hoàng Phương");
        assignments.add(assignment1);
        
        // Assignment 2: 🛒 CartShopping
        Assignment assignment2 = new Assignment(
            "🛒 CartShopping", 
            "Hệ thống giỏ hàng trực tuyến với CRUD sản phẩm", 
            LocalDate.of(2024, 3, 22), 
            "completed"
        );
        assignment2.setFileUrl("https://two3133059-cartshopping.onrender.com");
        assignment2.setSubmitDate(LocalDate.of(2024, 3, 22));
        assignment2.setSubmittedBy("Đinh Hoàng Phương");
        assignments.add(assignment2);
        
        // Assignment 3: 📧 EmailList
        Assignment assignment3 = new Assignment(
            "📧 EmailList", 
            "Ứng dụng quản lý danh sách email", 
            LocalDate.of(2024, 3, 28), 
            "completed"
        );
        assignment3.setFileUrl("https://websubjects-1.onrender.com/");
        assignment3.setSubmitDate(LocalDate.of(2024, 3, 28));
        assignment3.setSubmittedBy("Đinh Hoàng Phương");
        assignments.add(assignment3);
        
        // Assignment 4: 📊 SurveyWeb
        Assignment assignment4 = new Assignment(
            "📊 SurveyWeb", 
            "Website khảo sát trực tuyến với form tương tác", 
            LocalDate.of(2024, 4, 5), 
            "completed"
        );
        assignment4.setFileUrl("https://websubjects2.onrender.com");
        assignment4.setSubmitDate(LocalDate.of(2024, 4, 5));
        assignment4.setSubmittedBy("Đinh Hoàng Phương");
        assignments.add(assignment4);
        
        return assignments;
    }
    
    /**
     * Xác thực mật khẩu admin
     */
    public boolean authenticateAdmin(String password) {
        return ADMIN_PASSWORD.equals(password);
    }
    
    /**
     * Thêm bài tập mới (giả lập upload)
     */
    public boolean submitAssignment(String assignmentName, String fileName, String submittedBy) {
        // Trong thực tế sẽ lưu vào database
        System.out.println("Assignment submitted: " + assignmentName + " by " + submittedBy);
        System.out.println("File: " + fileName);
        return true;
    }
    
    /**
     * Cập nhật thông tin user
     */
    public boolean updateUserInfo(User user) {
        // Trong thực tế sẽ lưu vào database
        System.out.println("User info updated: " + user.toString());
        return true;
    }
}