package com.example.clientesreviews.service;

import com.example.clientesreviews.model.Cliente;
import com.example.clientesreviews.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente guardar(Cliente cliente) {
        return repository.save(cliente);
    }
}