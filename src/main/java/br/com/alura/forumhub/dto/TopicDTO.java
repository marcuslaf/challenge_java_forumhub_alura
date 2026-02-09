package br.com.alura.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TopicDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 5, max = 200, message = "O título deve ter entre 5 e 200 caracteres")
    private String title;

    @NotBlank(message = "A mensagem é obrigatória")
    @Size(min = 10, message = "A mensagem deve ter pelo menos 10 caracteres")
    private String message;

    @NotBlank(message = "O curso é obrigatório")
    private String course;

    // Getters e Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}