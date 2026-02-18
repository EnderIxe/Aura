package com.example.clientesreviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotación principal que habilita la configuración automática de Spring Boot
// y marca esta clase como punto de entrada de la aplicación.
@SpringBootApplication
public class ClientesreviewsApplication {

    // Método main: punto de inicio de la aplicación.
    // SpringApplication.run() arranca el servidor embebido (Tomcat)
    // y carga todo el contexto de Spring (controladores, repositorios, etc.)
    public static void main(String[] args) {
        SpringApplication.run(ClientesreviewsApplication.class, args);
    }

}
