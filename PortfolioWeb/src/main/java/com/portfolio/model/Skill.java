package com.portfolio.model;

/**
 * Model class cho kỹ năng
 */
public class Skill {
    private String name;
    private String level;
    private String icon;
    private String description;

    public Skill() {}

    public Skill(String name, String level, String icon, String description) {
        this.name = name;
        this.level = level;
        this.icon = icon;
        this.description = description;
    }

    // Getters và Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}