package com.example.demo.joins;

import io.github.biezhi.anima.Anima;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication2 {

    public static void main(String[] args) {
        Anima.open("jdbc:mysql://localhost:3306/students", "root", "root");
        SpringApplication.run(DemoApplication2.class, args);
    }

}
