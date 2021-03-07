package com.favoriteservice.service;

import com.favoriteservice.model.Client;
import com.favoriteservice.repository.ClientRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Persist a new Client
     * @param client
     * @return
     */
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    /**
     * Find a Client by ID
     * @param clientId
     * @return
     * @throws NotFoundException
     */
    public Client findById(Integer clientId) throws NotFoundException {
        return clientRepository.findById(clientId).orElseThrow(() -> new NotFoundException("Client dont exist"));
    }

    /**
     * Update a Client's data
     * @param id
     * @param clientNew
     * @return
     * @throws NotFoundException
     */
    public Client update(Integer id, Client clientNew) throws NotFoundException {
        Client client = findById(id);
        client.setEmail(clientNew.getEmail());
        client.setName(clientNew.getName());
        return clientRepository.save(client);
    }

    /**
     * Remove a Client by ID
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(Integer id) throws NotFoundException {
        Client client = clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client not exist!"));
        if(!ObjectUtils.isEmpty(client)) {
            clientRepository.deleteById(id);
        }
    }

    /**
     * Get all Clients
     *
     * @return
     */
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

}
