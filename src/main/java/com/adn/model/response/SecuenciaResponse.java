package com.adn.model.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecuenciaResponse {
    private Boolean isValidacion;
    private String cadena;
}
