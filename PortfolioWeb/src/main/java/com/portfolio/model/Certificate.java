package com.portfolio.model;

/**
 * Model class cho chứng chỉ/bằng cấp
 */
public class Certificate {
    private String title;
    private String institution;
    private String year;
    private String description;
    private String icon;
    private String credentialUrl;

    public Certificate() {}

    public Certificate(String title, String institution, String year, String description, String icon) {
        this.title = title;
        this.institution = institution;
        this.year = year;
        this.description = description;
        this.icon = icon;
    }

    // Getters và Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getInstitution() { return institution; }
    public void setInstitution(String institution) { this.institution = institution; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public String getCredentialUrl() { return credentialUrl; }
    public void setCredentialUrl(String credentialUrl) { this.credentialUrl = credentialUrl; }

    @Override
    public String toString() {
        return "Certificate{" +
                "title='" + title + '\'' +
                ", institution='" + institution + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}