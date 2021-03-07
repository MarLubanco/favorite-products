package com.favoriteservice.integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.favoriteservice.FavoriteServiceApplication;
import com.favoriteservice.model.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@SpringBootTest(classes = FavoriteServiceApplication.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mvc;

    Client client = Client.builder()
            .name("Marcelo")
            .email("marcelo.thome@gmail.com")
            .build();

    Client clientOther = Client.builder()
            .name("Joao")
            .email("joao.thome@gmail.com")
            .build();

    Client clientUpdate = Client.builder()
            .id(1)
            .name("Marcelo Thomé")
            .email("marceloo.thome@gmail.com")
            .build();

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void save_returnIsCreated() throws Exception {
        this.mvc.perform(
                post("/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(client))
                        .header("Content-Type", "application/json"))
                .andExpect(status().isCreated());
    }

    @Test
    public void update_returnOk() throws Exception {
        this.mvc.perform(
                put("/clients/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(clientUpdate))
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_returnOk() throws Exception {
        this.mvc.perform(
                get("/clients/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void findAll_returnAll() throws Exception {
        this.mvc.perform(
                get("/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteById_returnAll() throws Exception {
        this.mvc.perform(
                post("/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(clientOther))
                        .header("Content-Type", "application/json"));
        this.mvc.perform(
                delete("/clients/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }


}
