package com.example.clientesreviews.integracion;

import static org.junit.jupiter.api.Assertions.*;
import com.example.clientesreviews.model.Cliente;
import com.example.clientesreviews.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
@ActiveProfiles("test")
@DataJpaTest 
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // <--- AÑADE ESTO
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository repository;

    @Test
    void testFindById() {
        // Configuramos el cliente según tu modelo
        Cliente p = new Cliente();
        p.setNombre("Juan");
        p.setEdad(30);
        p.setGenero("Hombre");
        p.setIntolerancia(0);
        
        Cliente guardado = repository.save(p); 
        
        Optional<Cliente> encontrado = repository.findById(guardado.getId()); 
        
        assertTrue(encontrado.isPresent()); 
        assertEquals("Juan", encontrado.get().getNombre()); 
    }
}