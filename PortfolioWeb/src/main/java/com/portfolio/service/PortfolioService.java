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
        
        // Programming Languages
        skills.add(new Skill("Java", "Advanced", "☕", "Enterprise programming language for backend development"));
        skills.add(new Skill("Python", "Intermediate", "🐍", "Data analysis, machine learning and web development"));
        skills.add(new Skill("R", "Intermediate", "📊", "Statistical computing and data visualization"));
        skills.add(new Skill("HTML/CSS", "Advanced", "🎨", "Frontend markup and responsive styling"));
        skills.add(new Skill("JavaScript", "Intermediate", "⚡", "Client-side programming and DOM manipulation"));
        
        // Web Technologies & Frameworks
        skills.add(new Skill("JSP/Servlet", "Advanced", "🌐", "Java web development technologies"));
        skills.add(new Skill("Spring Boot", "Intermediate", "🍃", "Java framework for rapid application development"));
        
        // Databases
        skills.add(new Skill("PostgreSQL", "Advanced", "🐘", "Advanced relational database management"));
        skills.add(new Skill("MySQL", "Advanced", "🗃️", "Popular relational database system"));
        skills.add(new Skill("SQL Server", "Intermediate", "💾", "Microsoft database management system"));
        
        // Big Data & Analytics
        skills.add(new Skill("Apache Hadoop", "Intermediate", "📈", "Distributed storage and processing framework"));
        skills.add(new Skill("Apache Spark", "Intermediate", "⚡", "Unified analytics engine for big data processing"));
        skills.add(new Skill("Apache Hive", "Intermediate", "🐝", "Data warehouse software for reading and managing datasets"));
        skills.add(new Skill("Apache Sqoop", "Intermediate", "🔄", "Tool for transferring data between Hadoop and databases"));
        skills.add(new Skill("MapReduce", "Intermediate", "🗺️", "Programming model for processing large datasets"));
        
        // DevOps & Tools
        skills.add(new Skill("Docker", "Intermediate", "🐳", "Containerization platform for application deployment"));
        skills.add(new Skill("Maven", "Intermediate", "📦", "Build automation and dependency management"));
        skills.add(new Skill("Git/GitHub", "Advanced", "🔧", "Version control and collaborative development"));
        skills.add(new Skill("Apache Tomcat", "Intermediate", "🚀", "Java application server deployment"));
        
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
        
        Project dataAnalysisIBM = new Project();
        dataAnalysisIBM.setTitle("Phân tích dữ liệu phim IBM (1998-2018)");
        dataAnalysisIBM.setDescription("Dự án phân tích dữ liệu phim của IBM từ 1998 đến 2018 sử dụng Python. Xử lý và visualize dữ liệu để tìm ra xu hướng phát triển của ngành công nghiệp phim ảnh qua 20 năm.");
        dataAnalysisIBM.setTags(Arrays.asList("Python", "Pandas", "NumPy", "Tkinter", "Data Analysis", "Visualization"));
        
        Project heartDiseaseAnalysis = new Project();
        heartDiseaseAnalysis.setTitle("Phân tích dữ liệu bệnh tim mạch");
        heartDiseaseAnalysis.setDescription("Nghiên cứu phân tích dữ liệu bệnh tim mạch sử dụng ngôn ngữ R. Áp dụng các mô hình machine learning như cây quyết định và hồi quy để dự đoán nguy cơ bệnh tim và đưa ra kết luận y học.");
        heartDiseaseAnalysis.setTags(Arrays.asList("R", "Machine Learning", "Decision Tree", "Regression", "Medical Analysis", "Statistical Computing"));
        
        Project dormManagement = new Project();
        dormManagement.setTitle("Phần mềm quản lý ký túc xá");
        dormManagement.setDescription("Ứng dụng desktop quản lý ký túc xá toàn diện với giao diện WinForms. Quản lý sinh viên, phòng ở, thanh toán và báo cáo thống kê. Sử dụng SQL Server để lưu trữ dữ liệu.");
        dormManagement.setTags(Arrays.asList("C#", "WinForms", "SQL Server", "Desktop Application", "Database Management"));

        projects.add(ecommerce);
        projects.add(taskManagement);
        projects.add(portfolio);
        projects.add(dataAnalysisIBM);
        projects.add(heartDiseaseAnalysis);
        projects.add(dormManagement);
        
        return projects;
    }
    
    /**
     * Lấy danh sách chứng chỉ
     */
    public List<Certificate> getCertificates() {
        List<Certificate> certificates = new ArrayList<>();
        
        certificates.add(new Certificate(
            "Sinh viên Công nghệ Thông tin",
            "Đại học Sư phạm kĩ thuật (2023 - hiện tại)",
            "2023-2025",
            "Chuyên ngành: Kĩ thuật Dữ liệu",
            "🎓"
        ));
        
        certificates.add(new Certificate(
            "Data Engineering with Google Cloud",
            "Udemy, Coursera (2024)",
            "2024",
            "Big Data, ETL, Data Pipelines on GCP",
            "💻"
        ));
        
        certificates.add(new Certificate(
            "Responsive Web Design",
            "FreeCodeCamp (2025)",
            "2025",
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