package com.github.ahnshy.model.repository;

import com.github.ahnshy.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
