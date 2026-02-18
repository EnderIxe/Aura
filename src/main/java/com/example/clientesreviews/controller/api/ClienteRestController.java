package com.example.clientesreviews.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientesreviews.model.Cliente;
import com.example.clientesreviews.repository.ClienteRepository;

@RestController // Definimos un RestController
@RequestMapping("/api/clientes") // Ruta base de la API
public class ClienteRestController {
	
	@Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes (Equivalente al GET del PDF )
    @GetMapping
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por ID (Útil para tus rutas hijas en Angular)
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
