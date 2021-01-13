package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class studentServiceHandlerTest {


    @Test
    void test()
    {
        student stu = new student("100","new student","cse","active");

        studentServiceHandler studentServiceHandler = new studentServiceHandler();

        assertEquals("table created",studentServiceHandler.create());


    }

}