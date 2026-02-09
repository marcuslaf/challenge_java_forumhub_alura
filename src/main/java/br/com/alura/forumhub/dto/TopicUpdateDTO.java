package br.com.alura.forumhub.dto;

import jakarta.validation.constraints.Size;

public class TopicUpdateDTO {

    @Size(min = 5, max = 200, message = "O título deve ter entre 5 e 200 caracteres")
    private String title;

    @Size(min = 10, message = "A mensagem deve ter pelo menos 10 caracteres")
    private String message;

    private String status;

    // Getters e Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}