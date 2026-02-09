package br.com.alura.forumhub.dto;

import java.time.LocalDateTime;

public class TopicResponseDTO {

    private Long id;
    private String title;
    private String message;
    private String author;
    private LocalDateTime createdAt;
    private String status;
    private String course;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}