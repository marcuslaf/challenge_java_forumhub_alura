CREATE INDEX idx_topics_course_status ON topics(course, status);

CREATE INDEX idx_topics_created_desc ON topics(created_at DESC);