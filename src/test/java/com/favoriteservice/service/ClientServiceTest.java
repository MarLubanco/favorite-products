package com.favoriteservice.service;


import com.favoriteservice.FavoriteServiceApplication;
import com.favoriteservice.model.Client;
import javassist.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FavoriteServiceApplication.class)
public class ClientServiceTest {

    @Autowired
    private ClienteService clienteService;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void save_saveNewClient_ok() {
        Client client = Client.builder().name("Viniciues").email("vini@gmail.com").build();
        Client clientSave = clienteService.save(client);
        Assert.assertEquals(client.getEmail(), clientSave.getEmail());
    }

    @Test
    public void save_saveNewClientWithEmailExisting_erro() {

    }

    @Test
    public void findById_findClient_ok() throws NotFoundException {
        Client client = clienteService.findById(1);
        Assert.assertEquals(java.util.Optional.of(1).get(), client.getId());
    }

    @Test
    public void findById_findClientButIdDontExist_error() throws NotFoundException {
        thrown.expect(NotFoundException.class);
        Client client = clienteService.findById(3333);
    }

    @Test
    public void deleteById_deleteClientExisting_ok() throws NotFoundException {
        thrown.expect(javassist.NotFoundException.class);
        clienteService.deleteById(342);
    }

    @Test
    public void deleteById_deleteClientDontExist_error() throws NotFoundException {
        thrown.expect(javassist.NotFoundException.class);
        Client client = Client.builder().id(55).name("Thomes").email("thome@gmail.com").build();
        clienteService.save(client);
        clienteService.deleteById(55);
        clienteService.findById(55);
    }

    @Test
    public void findAll_findAllClients_ok() {
        List<Client> all = clienteService.findAll();
        Assert.assertTrue(all.size() >= 0);
    }

}
