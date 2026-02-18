package com.example.clientesreviews.unitario;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.clientesreviews.model.Cliente;
import com.example.clientesreviews.repository.ClienteRepository;
import com.example.clientesreviews.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class) 
class ClienteServiceTest {

    @Mock
    private ClienteRepository repository; 

    @InjectMocks
    private ClienteService service; 

    @Test
    void testGuardarCliente() {
        // Creamos un cliente con tus campos reales
        Cliente p = new Cliente();
        p.setId(1L);
        p.setNombre("Carlos");
        p.setEdad(25);
        
        when(repository.save(any(Cliente.class))).thenReturn(p);
        
        Cliente resultado = service.guardar(new Cliente()); 
        
        assertEquals("Carlos", resultado.getNombre()); 
        verify(repository, times(1)).save(any()); 
    }
}