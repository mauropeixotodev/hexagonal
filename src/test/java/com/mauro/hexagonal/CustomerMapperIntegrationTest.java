package com.mauro.hexagonal;

import org.springframework.beans.factory.annotation.Autowired; // Para injeção de dependência
import org.springframework.boot.test.context.SpringBootTest;     // Para configuração de teste de integração
import org.junit.jupiter.api.Test;                           // Para anotação de métodos de teste (JUnit 5)
import static org.junit.jupiter.api.Assertions.assertNotNull; // Para a assertiva
import com.mauro.hexagonal.adapters.in.controller.mapper.CustomerMapper; // Importação do CustomerMapper


@SpringBootTest
public class CustomerMapperIntegrationTest {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    void testCustomerMapperNotNull() {
        assertNotNull(customerMapper);
    }
}
