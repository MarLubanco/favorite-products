package com.favoriteservice.service;


import com.favoriteservice.FavoriteServiceApplication;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FavoriteServiceApplication.class)
public class ClientServiceTest {

    @Autowired
    private ClienteService clienteService;
    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void save_saveNewClient_ok() {

    }

    @Test
    public void save_saveNewClientWithEmailExisting_erro() {

    }

    @Test
    public void findById_findClient_ok() {

    }

    @Test
    public void findById_findClientButIdDontExist_error() {

    }

    @Test
    public void deleteById_deleteClientExisting_ok() {

    }

    @Test
    public void deleteById_deleteClientDontExist_error() {

    }

    @Test
    public void findAll_findAllClients_ok() {

    }

}
