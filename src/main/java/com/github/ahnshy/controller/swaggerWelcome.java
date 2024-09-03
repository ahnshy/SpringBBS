package com.github.ahnshy.controller;

import com.github.ahnshy.model.entity.User;
import com.github.ahnshy.model.entity.UserEntity;
import com.github.ahnshy.model.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@EnableWebMvc
@RequestMapping("/api") // localhost:8080/api
public class swaggerWelcome {

    @Autowired // Dependency Injection (DI) = Singleton Pattern
    private UserRepository userRepository;

    @GetMapping(value = "/swagger_welcome") // localhost:8080/api/swagger_test
    @ApiOperation(value="swagger api test", notes="swagger api welcome page")
    public ResponseEntity<List<User>> swaggerWelcomePage() {
        List<User> items = new ArrayList<>();
        return new ResponseEntity<List<User>>(items, HttpStatus.OK);
    }

    @GetMapping("/find") // http://localhost:8080/api/getParameter?id=1234&password=YYYYMMDD
    public ResponseEntity<List<UserEntity>> findUser(@RequestParam String name, @RequestParam(name= "birth") String birth) {
        System.out.println("name : " + name);
        System.out.println("Birth : " + birth);
        return ResponseEntity.ok(userRepository.findAll());
    }
}
