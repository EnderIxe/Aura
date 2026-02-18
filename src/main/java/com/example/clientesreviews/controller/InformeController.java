package com.example.clientesreviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.clientesreviews.repository.ClienteRepository;
import com.example.clientesreviews.repository.ReviewRepository;

@Controller
public class InformeController {

    // Repositorios necesarios para obtener datos de clientes y reviews
    private final ClienteRepository clienteRepository;
    private final ReviewRepository reviewRepository;

    // Inyección de dependencias mediante el constructor
    public InformeController(ClienteRepository clienteRepository, ReviewRepository reviewRepository) {
        this.clienteRepository = clienteRepository;
        this.reviewRepository = reviewRepository;
    }

    // Ruta que muestra el informe con los gráficos
    @GetMapping("/informe")
    public String informe(Model model) {

        // Se obtienen todos los clientes y reviews de la base de datos
        var clientes = clienteRepository.findAll();
        var reviews = reviewRepository.findAll();

        // ---------------------------------------------------------
        // 1) GRÁFICO: Clientes por género
        // ---------------------------------------------------------
        // Se cuentan los clientes según su género
        long hombres = clientes.stream().filter(c -> "Hombre".equalsIgnoreCase(c.getGenero())).count();
        long mujeres = clientes.stream().filter(c -> "Mujer".equalsIgnoreCase(c.getGenero())).count();
        long otros   = clientes.stream().filter(c -> "Otro".equalsIgnoreCase(c.getGenero())).count();

        // Se envían los datos a la vista
        model.addAttribute("hombres", hombres);
        model.addAttribute("mujeres", mujeres);
        model.addAttribute("otros", otros);

        // ---------------------------------------------------------
        // 2) GRÁFICO: Reviews por número de estrellas (1–5)
        // ---------------------------------------------------------
        // Se cuentan cuántas reviews tienen cada puntuación
        long estrellas1 = reviews.stream().filter(r -> r.getPuntuacion() == 1).count();
        long estrellas2 = reviews.stream().filter(r -> r.getPuntuacion() == 2).count();
        long estrellas3 = reviews.stream().filter(r -> r.getPuntuacion() == 3).count();
        long estrellas4 = reviews.stream().filter(r -> r.getPuntuacion() == 4).count();
        long estrellas5 = reviews.stream().filter(r -> r.getPuntuacion() == 5).count();

        // Se envían los datos a la vista
        model.addAttribute("e1", estrellas1);
        model.addAttribute("e2", estrellas2);
        model.addAttribute("e3", estrellas3);
        model.addAttribute("e4", estrellas4);
        model.addAttribute("e5", estrellas5);

        // ---------------------------------------------------------
        // 3) GRÁFICO: Clientes por franjas de edad
        // ---------------------------------------------------------
        // Se agrupan los clientes en rangos de edad
        long f0_15   = clientes.stream().filter(c -> c.getEdad() >= 0  && c.getEdad() <= 15).count();
        long f16_24  = clientes.stream().filter(c -> c.getEdad() >= 16 && c.getEdad() <= 24).count();
        long f25_35  = clientes.stream().filter(c -> c.getEdad() >= 25 && c.getEdad() <= 35).count();
        long f36_50  = clientes.stream().filter(c -> c.getEdad() >= 36 && c.getEdad() <= 50).count();
        long f51plus = clientes.stream().filter(c -> c.getEdad() >= 51).count();

        // Se envían los datos a la vista
        model.addAttribute("f0_15", f0_15);
        model.addAttribute("f16_24", f16_24);
        model.addAttribute("f25_35", f25_35);
        model.addAttribute("f36_50", f36_50);
        model.addAttribute("f51plus", f51plus);

        // ---------------------------------------------------------
        // 4) GRÁFICO LIBRE: Clientes con y sin intolerancia
        // ---------------------------------------------------------
        // Se cuentan los clientes según si tienen intolerancia o no
        long conIntolerancia = clientes.stream().filter(c -> Boolean.TRUE.equals(c.getIntolerancia())).count();
        long sinIntolerancia = clientes.stream().filter(c -> !Boolean.TRUE.equals(c.getIntolerancia())).count();

        // Se envían los datos a la vista
        model.addAttribute("conIntolerancia", conIntolerancia);
        model.addAttribute("sinIntolerancia", sinIntolerancia);

        // Se devuelve la plantilla informe.html
        return "informe";
    }

}
