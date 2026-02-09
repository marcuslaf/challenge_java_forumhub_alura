package br.com.alura.forumhub.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import br.com.alura.forumhub.dto.TopicDTO;
import br.com.alura.forumhub.dto.TopicResponseDTO;
import br.com.alura.forumhub.dto.TopicUpdateDTO;
import br.com.alura.forumhub.entity.Topic;
import br.com.alura.forumhub.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/topics")
@Tag(name = "Tópicos", description = "Operações CRUD para tópicos do fórum")
@SecurityRequirement(name = "Bearer Authentication")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Operation(summary = "Criar novo tópico")
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<TopicResponseDTO> createTopic(@RequestBody TopicDTO topicDTO) {
        Topic createdTopic = topicService.createTopic(topicDTO);
        return new ResponseEntity<>(convertToResponseDTO(createdTopic), HttpStatus.CREATED);
    }

    @Operation(summary = "Listar todos os tópicos")
    @GetMapping
    public ResponseEntity<List<TopicResponseDTO>> getAllTopics() {
        List<Topic> topics = topicService.getAllTopics();
        List<TopicResponseDTO> response = topics.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Buscar tópico por ID")
    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseDTO> getTopicById(@PathVariable Long id) {
        Topic topic = topicService.getTopicById(id);
        return ResponseEntity.ok(convertToResponseDTO(topic));
    }

    @Operation(summary = "Atualizar tópico")
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<TopicResponseDTO> updateTopic(
            @PathVariable Long id,
            @RequestBody TopicUpdateDTO updateDTO) {
        Topic updatedTopic = topicService.updateTopic(id, updateDTO);
        return ResponseEntity.ok(convertToResponseDTO(updatedTopic));
    }

    @Operation(summary = "Deletar tópico")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    private TopicResponseDTO convertToResponseDTO(Topic topic) {
        TopicResponseDTO dto = new TopicResponseDTO();
        dto.setId(topic.getId());
        dto.setTitle(topic.getTitle());
        dto.setMessage(topic.getMessage());
        dto.setAuthor(topic.getAuthor().getUsername());
        dto.setCreatedAt(topic.getCreatedAt());
        dto.setStatus(topic.getStatus());
        return dto;
    }
}