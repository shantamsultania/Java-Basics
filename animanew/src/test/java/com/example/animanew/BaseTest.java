package com.example.animanew;

import io.github.biezhi.anima.Anima;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest{
    @BeforeAll
    public static void setup()

    {
        mysql();
    }

    public static void mysql() {
        Anima.open("jdbc:mysql://localhost:3306/students?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "root");
    }
}
