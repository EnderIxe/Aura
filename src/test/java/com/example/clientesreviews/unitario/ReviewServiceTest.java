package com.example.clientesreviews.unitario;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.clientesreviews.model.Review;
import com.example.clientesreviews.repository.ReviewRepository;
import com.example.clientesreviews.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class) // Habilita Mockito
class ReviewServiceTest {

    @Mock
    private ReviewRepository repository; // Doble de la DB 

    @InjectMocks
    private ReviewService service;

    @Test
    void testGuardarReview() {
        Review r = new Review();
        r.setComentario("Excelente servicio");
        r.setPuntuacion(5);
        
        when(repository.save(any(Review.class))).thenReturn(r);
        
        Review resultado = service.guardar(new Review());
        
        assertEquals(5, resultado.getPuntuacion());
        verify(repository, times(1)).save(any());
    }
}