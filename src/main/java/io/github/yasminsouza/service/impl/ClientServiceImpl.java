package io.github.yasminsouza.service.impl;

import io.github.yasminsouza.exception.NotFoundException;
import io.github.yasminsouza.model.Client;
import io.github.yasminsouza.repository.ClientRepository;
import io.github.yasminsouza.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findById(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado."));
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Integer id) {
        clientRepository.findById(id)
                .map(client -> {
                    clientRepository.delete(client);
                    return client;
                })
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado."));
    }

    @Override
    public void update(Integer id, Client client) {
        clientRepository.findById(id)
                .map(clientExist -> {
                    client.setId(clientExist.getId());
                    clientRepository.save(client);
                    return client;
                })
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado."));
    }

    @Override
    public List<Client> getAll(Client filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filter, matcher);
        return clientRepository.findAll(example);
    }
}
