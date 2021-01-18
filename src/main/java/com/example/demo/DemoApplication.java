package com.example.demo;

import io.github.biezhi.anima.Anima;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args)
    {
        Anima.open("jdbc:mysql://121.0.0.1:3306/students", "root", "root");

        SpringApplication.run(DemoApplication.class, args);
    }

}
