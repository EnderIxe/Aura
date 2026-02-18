package com.example.clientesreviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.clientesreviews.model.Cliente;
import com.example.clientesreviews.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes") // Ruta base para todas las operaciones de clientes
public class ClienteController {

    // Repositorio que permite acceder a la base de datos de clientes
    private final ClienteRepository clienteRepository;

    // Inyección del repositorio mediante el constructor
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // -----------------------------
    // LISTAR CLIENTES
    // -----------------------------
    // Muestra el listado completo de clientes en la vista clientes/lista.html
    @GetMapping
    public String listar(Model model) {
        // Se añaden todos los clientes al modelo para mostrarlos en la tabla
        model.addAttribute("clientes", clienteRepository.findAll());
        return "clientes/lista";
    }

    // -----------------------------
    // FORMULARIO NUEVO CLIENTE
    // -----------------------------
    // Muestra el formulario vacío para crear un nuevo cliente
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        // Se envía un objeto Cliente vacío para que Thymeleaf rellene el formulario
        model.addAttribute("cliente", new Cliente());
        return "clientes/form";
    }

    // -----------------------------
    // GUARDAR CLIENTE (CREAR O EDITAR)
    // -----------------------------
    // Recibe los datos del formulario y guarda el cliente en la base de datos
    @PostMapping
    public String guardar(@ModelAttribute Cliente cliente) {
        // save() sirve tanto para crear como para actualizar
        clienteRepository.save(cliente);
        // Redirige al listado después de guardar
        return "redirect:/clientes";
    }

    // -----------------------------
    // EDITAR CLIENTE
    // -----------------------------
    // Carga los datos de un cliente existente y los muestra en el formulario
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        // Busca el cliente por ID o lanza excepción si no existe
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        // Se envía el cliente encontrado al formulario para editarlo
        model.addAttribute("cliente", cliente);
        return "clientes/form";
    }

    // -----------------------------
    // ELIMINAR CLIENTE
    // -----------------------------
    // Elimina un cliente por su ID
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        // Redirige al listado después de eliminar
        return "redirect:/clientes";
    }
}
