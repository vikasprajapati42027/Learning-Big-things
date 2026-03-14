package com.example.annotations.model;

public class AnnotationDetail {
    private String name;
    private String category;
    private String description;
    private String exampleCode;

    public AnnotationDetail(String name, String category, String description, String exampleCode) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.exampleCode = exampleCode;
    }

    // Getters
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getExampleCode() { return exampleCode; }
}
