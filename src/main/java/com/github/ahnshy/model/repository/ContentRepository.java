package com.github.ahnshy.model.repository;

import com.github.ahnshy.model.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
