package br.com.alura.forumhub.exception;

public class TopicNotFoundException extends RuntimeException {
    public TopicNotFoundException(Long id) {
        super("Tópico com ID " + id + " não encontrado");
    }
}