package io.github.yasminsouza.service;

import io.github.yasminsouza.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    Client findById(Integer id);
    Client save(Client client);
    void delete(Integer id);
    void update(Integer id, Client client);
    List<Client> getAll(Client filter);
}
