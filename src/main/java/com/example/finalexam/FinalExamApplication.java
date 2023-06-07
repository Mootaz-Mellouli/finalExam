package com.example.finalexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FinalExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalExamApplication.class, args);
    }

}
