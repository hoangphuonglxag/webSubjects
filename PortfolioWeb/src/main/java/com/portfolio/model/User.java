package com.portfolio.model;

/**
 * Model class chứa thông tin cá nhân
 */
public class User {
    private String name;
    private String title;
    private String email;
    private String phone;
    private String location;
    private String website;
    private String facebookUrl;
    private String githubUrl;
    private String avatar;
    private String description;

    // Constructor mặc định

    public User() {
        // Thông tin mặc định - có thể load từ database
        this.name = "Đinh Hoàng Phương";
        this.title = "Web Dev & Data Engineering Student";
        this.email = "phuongdinh@gmail.com";
        this.phone = "+84 346 295 422";
        this.location = "Hồ Chí Minh, Việt Nam";
        this.website = "hoangphuonglxag.dev";
        this.facebookUrl = "https://www.facebook.com/hoang.phuong.081025";
        this.githubUrl = "https://github.com/hoangphuonglxag";
        this.avatar = "👨‍💻";
        this.description = "Sinh viên ngành Kỹ thuật Dữ liệu với hiểu biết về web development và big data analytics. Có khả năng sử dụng Java ecosystem (Spring Boot, JSP/Servlet), database management (PostgreSQL, MySQL, SQL Server), và big data technologies (Hadoop, Spark, Hive). Có kinh nghiệm thực tế với Docker, Maven.";
    }

    // Getters và Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public String getFacebookUrl() { return facebookUrl; }
    public void setFacebookUrl(String facebookUrl) { this.facebookUrl = facebookUrl; }

    public String getGithubUrl() { return githubUrl; }
    public void setGithubUrl(String githubUrl) { this.githubUrl = githubUrl; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}