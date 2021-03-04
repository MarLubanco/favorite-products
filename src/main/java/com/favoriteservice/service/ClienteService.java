package com.favoriteservice.service;

import com.favoriteservice.model.Client;
import com.favoriteservice.repository.ClientRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client findById(Integer clientId) throws NotFoundException {
        return clientRepository.findById(clientId).orElseThrow(() -> new NotFoundException("Client dont exist"));
    }

    public Client update(Integer id, Client clientNew) throws NotFoundException {
        Client client = findById(id);
        client.setEmail(clientNew.getEmail());
        client.setName(clientNew.getName());
        return clientRepository.save(client);
    }

    public void deleteById(Integer id) {
        clientRepository.deleteById(id);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
