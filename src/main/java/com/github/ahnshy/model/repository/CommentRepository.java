package com.github.ahnshy.model.repository;

import com.github.ahnshy.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
