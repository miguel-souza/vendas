package io.github.yasminsouza.controller;

import io.github.yasminsouza.model.Client;
import io.github.yasminsouza.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public Client findById(@PathVariable Integer id){
       return clientService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody @Valid Client client){
        return clientService.save(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        clientService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid Client client){
        clientService.update(id, client);
    }

    @GetMapping
    public List<Client> getAll(Client filter){
        return clientService.getAll(filter);
    }
}
