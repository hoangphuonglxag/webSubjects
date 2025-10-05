package com.portfolio.model;

import java.time.LocalDate;

/**
 * Model class cho bài tập
 */
public class Assignment {
    private String name;
    private String description;
    private LocalDate submitDate;
    private LocalDate dueDate;
    private String status; // "completed", "pending", "in-progress"
    private String fileUrl;
    private String submittedBy;

    public Assignment() {}

    public Assignment(String name, String description, LocalDate dueDate, String status) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    // Getters và Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getSubmitDate() { return submitDate; }
    public void setSubmitDate(LocalDate submitDate) { this.submitDate = submitDate; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

    public String getSubmittedBy() { return submittedBy; }
    public void setSubmittedBy(String submittedBy) { this.submittedBy = submittedBy; }

    // Helper methods
    public String getStatusIcon() {
        switch (status.toLowerCase()) {
            case "completed": return "✅";
            case "pending": return "⏳";
            case "in-progress": return "📝";
            default: return "❓";
        }
    }

    public String getStatusText() {
        switch (status.toLowerCase()) {
            case "completed": return "Hoàn thành";
            case "pending": return "Chờ chấm";
            case "in-progress": return "Đang làm";
            default: return "Không xác định";
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}