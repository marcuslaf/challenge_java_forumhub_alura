package br.com.alura.forumhub.repository;

import br.com.alura.forumhub.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findByStatus(String status);
    List<Topic> findByCourse(String course);
    List<Topic> findByAuthorId(Long authorId);
}