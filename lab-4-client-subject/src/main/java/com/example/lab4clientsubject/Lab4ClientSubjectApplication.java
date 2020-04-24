package com.example.lab4clientsubject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Lab4ClientSubjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4ClientSubjectApplication.class, args);
    }

}
