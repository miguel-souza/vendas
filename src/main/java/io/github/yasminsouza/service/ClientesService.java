package io.github.yasminsouza.service;

import io.github.yasminsouza.model.Cliente;
import io.github.yasminsouza.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientesService {

    @Autowired
    private ClientesRepository repository;

    public void save(Cliente cliente){
        validClient(cliente);
        repository.persistir(cliente);
    }

    public void validClient(Cliente cliente){
        //validar cliente
    }
}
