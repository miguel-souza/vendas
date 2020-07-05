package io.github.yasminsouza.service;

import io.github.yasminsouza.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {
    Cliente findById(Integer id);
    Cliente save(Cliente cliente);
    void delete(Integer id);
    void update(Integer id, Cliente cliente);
    List<Cliente> getAll(Cliente filter);
}
