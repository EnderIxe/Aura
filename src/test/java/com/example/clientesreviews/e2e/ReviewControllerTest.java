package com.example.clientesreviews.e2e;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.clientesreviews.model.Review;
import com.example.clientesreviews.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReviewRepository reviewRepository; // Inyectamos el repo para crear datos de prueba

    @Test
    void testListarReviewsApi() throws Exception {	
        mockMvc.perform(get("/api/reviews")) 
               .andExpect(status().isOk()); 
    }

    @Test
    void testObtenerReviewPorId() throws Exception {
        // 1. CREAMOS una review manualmente para que el ID exista de verdad
        Review r = new Review();
        r.setComentario("Prueba de ID");
        r.setPuntuacion(5);
        Review guardada = reviewRepository.save(r); // Se guarda y genera un ID (podría no ser el 1)

        // 2. BUSCAMOS usando el ID que nos ha dado la base de datos
        mockMvc.perform(get("/api/reviews/" + guardada.getId())) 
               .andExpect(status().isOk()) 
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.comentario").value("Prueba de ID"));
    }
}