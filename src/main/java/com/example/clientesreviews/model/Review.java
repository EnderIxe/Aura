package com.example.clientesreviews.model;

import jakarta.persistence.*;

@Entity
public class Review {

    // Identificador único de la review, generado automáticamente por la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Comentario o descripción escrita por el cliente
    private String comentario;

    // Valoración numérica entre 1 y 5
    private Integer puntuacion;

    // Relación ManyToOne: muchas reviews pueden pertenecer al mismo cliente
    // Se crea una columna cliente_id en la tabla Review
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Getters y setters necesarios para que Spring pueda acceder y modificar los datos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
