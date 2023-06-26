package com.example.springteste.controller;


import com.example.springteste.model.Cliente;
import com.example.springteste.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
        private ClienteRepository clienteRepository;

    @RequestMapping(path = "/listarClientes", method = RequestMethod.GET)
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @RequestMapping(path = "/adicionarCliente", method = RequestMethod.POST)
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @RequestMapping(path = "/autenticarCliente", method = RequestMethod.GET)
    public ResponseEntity<?> autenticar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteRepository.findByEmailAndSenha(cliente.getEmail(), cliente.getSenha()));
    }

}
