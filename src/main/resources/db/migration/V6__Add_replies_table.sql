CREATE TABLE IF NOT EXISTS replies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    author_id BIGINT NOT NULL,
    topic_id BIGINT NOT NULL,
    solution BOOLEAN DEFAULT FALSE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

ALTER TABLE replies
ADD CONSTRAINT fk_replies_author
FOREIGN KEY (author_id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE replies
ADD CONSTRAINT fk_replies_topic
FOREIGN KEY (topic_id) REFERENCES topics(id) ON DELETE CASCADE;

CREATE INDEX idx_replies_topic ON replies(topic_id);
CREATE INDEX idx_replies_author ON replies(author_id);
CREATE INDEX idx_replies_solution ON replies(solution);