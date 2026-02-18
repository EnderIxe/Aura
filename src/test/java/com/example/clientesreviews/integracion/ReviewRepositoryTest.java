package com.example.clientesreviews.integracion;

import static org.junit.jupiter.api.Assertions.*;
import com.example.clientesreviews.model.Review;
import com.example.clientesreviews.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
@ActiveProfiles("test")
@DataJpaTest // Configura la DB en memoria para el test
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // <--- AÑADE ESTO
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository repository;

    @Test
    void testPersistirReview() {
        Review r = new Review();
        r.setComentario("Comida fría");
        r.setPuntuacion(2);
        
        Review guardada = repository.save(r);
        
        assertNotNull(guardada.getId());
        assertEquals("Comida fría", guardada.getComentario());
    }
}