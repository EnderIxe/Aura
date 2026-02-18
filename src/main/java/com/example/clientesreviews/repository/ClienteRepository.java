package com.example.clientesreviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clientesreviews.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
