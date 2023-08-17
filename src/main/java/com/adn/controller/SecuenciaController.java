package com.adn.controller;

import com.adn.model.request.SecuenciaRequest;
import com.adn.model.response.SecuenciaResponse;
import com.adn.service.ConsultaService;
import com.adn.service.SecuenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/secuencia")
public class SecuenciaController {

    @Autowired
    private SecuenciaService secuenciaService;

    @Autowired
    private ConsultaService consultaService;

    @PostMapping("/validar")
    public ResponseEntity<SecuenciaResponse> validarSecuencia(@RequestBody SecuenciaRequest secuenciaRequest) {
        SecuenciaResponse secuenciaResponse= consultaService.consulta();

        secuenciaResponse = secuenciaService.isValidacionSecuencia(secuenciaRequest.getAdn());
        return secuenciaResponse.getIsValidacion() ? new ResponseEntity<SecuenciaResponse>(secuenciaResponse, HttpStatus.OK) : new ResponseEntity<SecuenciaResponse>(secuenciaResponse, HttpStatus.FORBIDDEN);
    }
}
