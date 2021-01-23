package com.example.animanew.animal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "root", password = "root")
class AnimalControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAnimal() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/getanimal"))
                .andExpect(status().isOk());
    }

    @Test
    public void addAnimal() throws Exception {
        String jsonString = "{\n" +
                "\"animalId\":100,\n" +
                "\"animalName\":\"horse\",\n" +
                "\"animalGender\":\"male\",\n" +
                "\"animalType\":\"grass\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/addanimal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void updateAnimal() throws Exception {
        String jsonString = "{\n" +
                "\"animalId\":100,\n" +
                "\"animalName\":\"horse\",\n" +
                "\"animalGender\":\"male\",\n" +
                "\"animalType\":\"grass\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.put("/updateanimal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void deleteAnimal() throws Exception {
        String jsonString = "{\n" +
                "\"animalId\":100,\n" +
                "\"animalName\":\"horse\",\n" +
                "\"animalGender\":\"male\",\n" +
                "\"animalType\":\"grass\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteanimal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}