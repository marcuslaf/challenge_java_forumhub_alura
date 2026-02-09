package br.com.alura.forumhub.service;

import br.com.alura.forumhub.dto.TopicDTO;
import br.com.alura.forumhub.dto.TopicUpdateDTO;
import br.com.alura.forumhub.entity.Topic;
import br.com.alura.forumhub.entity.User;
import br.com.alura.forumhub.exception.TopicNotFoundException;
import br.com.alura.forumhub.repository.TopicRepository;
import br.com.alura.forumhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Topic createTopic(TopicDTO topicDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        User author = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Topic topic = new Topic();
        topic.setTitle(topicDTO.getTitle());
        topic.setMessage(topicDTO.getMessage());
        topic.setCourse(topicDTO.getCourse());
        topic.setAuthor(author);

        return topicRepository.save(topic);
    }

    @Transactional(readOnly = true)
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Topic getTopicById(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException(id));
    }

    @Transactional
    public Topic updateTopic(Long id, TopicUpdateDTO updateDTO) {
        Topic topic = getTopicById(id);

        if (updateDTO.getTitle() != null && !updateDTO.getTitle().isEmpty()) {
            topic.setTitle(updateDTO.getTitle());
        }
        if (updateDTO.getMessage() != null && !updateDTO.getMessage().isEmpty()) {
            topic.setMessage(updateDTO.getMessage());
        }
        if (updateDTO.getStatus() != null && !updateDTO.getStatus().isEmpty()) {
            topic.setStatus(updateDTO.getStatus());
        }

        return topicRepository.save(topic);
    }

    @Transactional
    public void deleteTopic(Long id) {
        Topic topic = getTopicById(id);
        topicRepository.delete(topic);
    }
}