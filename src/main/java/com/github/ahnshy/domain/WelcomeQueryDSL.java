package com.github.ahnshy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WelcomeQueryDSL {
    @Id
    @GeneratedValue
    private Long id;
}
