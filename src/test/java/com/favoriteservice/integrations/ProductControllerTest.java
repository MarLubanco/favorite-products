package com.favoriteservice.integrations;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.favoriteservice.FavoriteServiceApplication;
import com.favoriteservice.model.Client;
import com.favoriteservice.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@SpringBootTest(classes = FavoriteServiceApplication.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    Product product = Product.builder()
            .title("Teste")
            .idMagalu("1bf0f365-fbdd-4e21-9786-da459d78dd1f")
            .image("http://challenge-api.luizalabs.com/images/1bf0f365-fbdd-4e21-9786-da459d78dd1f.jpg")
            .price(122.3)
            .build();

    Client client = Client.builder()
            .name("Marcelo Thome")
            .email("mar.thome@gmail.com")
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
    public void findAllProductsByPage_returnIsOk() throws Exception {
        this.mvc.perform(
                get("/products/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void saveFavoriteProduct_returnIsOk() throws Exception {
        this.mvc.perform(
                get("/products/1bf0f365-fbdd-4e21-9786-da459d78dd1f/client/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }
}
