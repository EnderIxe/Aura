package com.example.clientesreviews.e2e;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
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
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc; 

    @Test
    void testGetClientes() throws Exception {
        // Simulamos la petición al endpoint que creamos antes
        mockMvc.perform(get("/api/clientes")) 
               .andExpect(status().isOk()) 
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}