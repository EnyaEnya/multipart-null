package com.example.multipartnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;

@SpringBootApplication
@EnableWebMvc
@RestController
@RequestMapping("/")
public class MultipartNullApplication {

    private static final Logger log = LoggerFactory.getLogger(MultipartNullApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MultipartNullApplication.class, args);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void create(@ModelAttribute MultipartFile file) {
        log.info("name, {}", file.getName());
        log.info("size, {}", file.getSize());
    }

}
