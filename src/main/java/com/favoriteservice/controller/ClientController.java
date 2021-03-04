package com.favoriteservice.controller;

import com.favoriteservice.model.Client;
import com.favoriteservice.service.ClienteService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return clienteService.save(client);
    }

    @PutMapping("/update/{id}")
    public Client update(@PathVariable Integer id, @RequestBody Client client) throws NotFoundException {
        return clienteService.update(id, client);
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Integer id) throws NotFoundException {
        return clienteService.findById(id);
    }

    @GetMapping
    public List<Client> findAlL() {
        return clienteService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) throws NotFoundException {
        clienteService.deleteById(id);
    }
}
