package com.example.demo.joins.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.joins.models.student;
import com.example.demo.joins.models.teacher;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class JoinControllerTestNew {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JoinController joinController;

    private ObjectMapper objectMapper = new ObjectMapper();


    @Test
    public void testGetAllStudents() throws Exception
    {

    }





}