package com.example.clientesreviews.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    // Identificador único del cliente, generado automáticamente por la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del cliente
    private String nombre;

    // Edad del cliente
    private int edad;

    // Género del cliente (Hombre, Mujer, Otro)
    private String genero;

    // Indica si el cliente tiene intolerancia (1 = Sí, 0 = No)
    // Se usa Integer en lugar de boolean para permitir valores nulos si fuera necesario
    private Integer intolerancia;

    // Detalle de la intolerancia en caso de que exista
    private String detalleIntolerancia;

    // Getters y setters necesarios para que Spring pueda acceder y modificar los datos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getIntolerancia() {
        return intolerancia;
    }

    public void setIntolerancia(int intolerancia) {
        this.intolerancia = intolerancia;
    }

    public String getDetalleIntolerancia() {
        return detalleIntolerancia;
    }

    public void setDetalleIntolerancia(String detalleIntolerancia) {
        this.detalleIntolerancia = detalleIntolerancia;
    }
}
