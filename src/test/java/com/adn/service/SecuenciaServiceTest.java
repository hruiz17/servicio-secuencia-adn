package com.adn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SecuenciaServiceTest {

    @InjectMocks
    private SecuenciaService secuenciaService;


    @Test
    @DisplayName("Validacion exitosa de la secuencia")
    void isValidacionSecuencia_exitoso() {
        // Give
        String[] secuencia = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};

        // When
        Boolean isValidacion = secuenciaService.isValidacionSecuencia(secuencia);

        // Then
        Assertions.assertTrue(isValidacion);
    }

    @Test
    @DisplayName("Validacion no contiene la secuencia")
    void isValidacionSecuencia_no_contiene() {
        // Give
        String[] secuencia = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "ACCCTA", "TCACTG"};

        // When
        Boolean isValidacion = secuenciaService.isValidacionSecuencia(secuencia);

        // Then
        Assertions.assertFalse(isValidacion);
    }
}