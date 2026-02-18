package com.example.clientesreviews.controller;

import com.example.clientesreviews.model.Review;
import com.example.clientesreviews.model.Cliente;
import com.example.clientesreviews.repository.ReviewRepository;
import com.example.clientesreviews.repository.ClienteRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews") // Ruta base para todas las operaciones relacionadas con reviews
public class ReviewController {

    // Repositorios para acceder a la base de datos de reviews y clientes
    private final ReviewRepository reviewRepository;
    private final ClienteRepository clienteRepository;

    // Inyección de dependencias mediante el constructor
    public ReviewController(ReviewRepository reviewRepository, ClienteRepository clienteRepository) {
        this.reviewRepository = reviewRepository;
        this.clienteRepository = clienteRepository;
    }

    // ---------------------------------------------------------
    // LISTAR REVIEWS
    // ---------------------------------------------------------
    // Muestra el listado completo de reviews en la vista reviews/lista.html
    @GetMapping
    public String listar(Model model) {
        // Se añaden todas las reviews al modelo para mostrarlas en la tabla
        model.addAttribute("reviews", reviewRepository.findAll());
        return "reviews/lista";
    }

    // ---------------------------------------------------------
    // FORMULARIO NUEVA REVIEW
    // ---------------------------------------------------------
    // Muestra el formulario vacío para crear una nueva review
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        // Se envía un objeto Review vacío para que Thymeleaf rellene el formulario
        model.addAttribute("review", new Review());

        // También se envía la lista de clientes para seleccionar uno en el <select>
        model.addAttribute("clientes", clienteRepository.findAll());

        return "reviews/form";
    }

    // ---------------------------------------------------------
    // GUARDAR REVIEW (CREAR O EDITAR)
    // ---------------------------------------------------------
    // Recibe los datos del formulario y guarda la review en la base de datos
    @PostMapping
    public String guardar(@ModelAttribute Review review) {
        // save() sirve tanto para crear como para actualizar
        reviewRepository.save(review);

        // Redirige al listado después de guardar
        return "redirect:/reviews";
    }

    // ---------------------------------------------------------
    // EDITAR REVIEW
    // ---------------------------------------------------------
    // Carga los datos de una review existente y los muestra en el formulario
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        // Busca la review por ID o lanza excepción si no existe
        Review review = reviewRepository.findById(id).orElseThrow();

        // Se envía la review encontrada al formulario
        model.addAttribute("review", review);

        // Se envía la lista de clientes para el <select>
        model.addAttribute("clientes", clienteRepository.findAll());

        return "reviews/form";
    }

    // ---------------------------------------------------------
    // ELIMINAR REVIEW
    // ---------------------------------------------------------
    // Elimina una review por su ID
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        reviewRepository.deleteById(id);

        // Redirige al listado después de eliminar
        return "redirect:/reviews";
    }
}
