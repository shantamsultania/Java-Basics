package com.example.animanew.school;

import com.example.animanew.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "root",password = "root")
class schoolControllerTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students1"))
                .andExpect(status().isOk());
    }

    @Test
    void addStudent() throws Exception {
        String jsonString = "{\n" +
                "\"ssection\":120,\n" +
                "\"sname\":\"shantam\",\n" +
                "\"sid\":\"cse1\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/students1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateStudent() throws Exception
    {
        String jsonString = "{\n" +
                "\"ssection\":12,\n" +
                "\"sname\":\"shantam\",\n" +
                "\"sid\":\"cse1\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.put("/students1/{id}",100)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void deleteStudent() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.delete("/students1/{id}",100))
                .andExpect(status().isOk());
    }

    @Test
    void getTeacher() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/teacher"))
                .andExpect(status().isOk());
    }

    @Test
    void addTeacher() throws Exception {

        String jsonString = "{\n" +
                "\"tsection\":120,\n" +
                "\"tname\":\"shantam\",\n" +
                "\"tid\":\"cse1\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/teacher")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateTeacher() throws Exception
    {
        String jsonString = "{\n" +
                "\"ssection\":12,\n" +
                "\"sname\":\"shantam\",\n" +
                "\"sid\":\"cse1\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.put("/teacher/{id}",100)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteTeacher() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.delete("/teacher/{id}",100))
                .andExpect(status().isOk());
    }


    @Test
    void innerJoin() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/innerJoin/{id}",100))
                .andExpect(status().isOk());
    }

    @Test
    void  filterByID() throws Exception{
        ///filterById/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/filterById/{id}",100))
                .andExpect(status().isOk());
    }

    @Test
    void filterBySidAndSName() throws Exception{
        //
        mockMvc.perform(MockMvcRequestBuilders.get("/filterBySidAndSName/{id}/{name}",100,"shantam"))
                .andExpect(status().isOk());
    }




}