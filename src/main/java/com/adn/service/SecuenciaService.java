package com.adn.service;

import com.adn.model.response.SecuenciaResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class SecuenciaService {

    public SecuenciaResponse isValidacionSecuencia(String[] secuencia) {
        //validar secuencia

        List<String> adn = Arrays.asList("AAAA", "TTTT", "CCCC", "GGGG");
        List<String> resultado = new ArrayList<>();

        // add all horizontal
        resultado.addAll(Arrays.asList(secuencia));

        // add all vertical

        // add all diagonals and contradiagonals
        AtomicReference<String> cadena = new AtomicReference<>("");
        long validado = resultado.stream()
                .filter(r -> adn.stream().filter(a -> r.contains(a)).count() > 0)
                .peek(a -> {
                    cadena.set(a);
                    System.out.printf("cadena adn %s\n", a);
                })
                .count();
        SecuenciaResponse secuenciaResponse = SecuenciaResponse.builder()
                .isValidacion(validado >= 1 ? true : false)
                .cadena(cadena.get()).build();

        return secuenciaResponse;
    }
}
