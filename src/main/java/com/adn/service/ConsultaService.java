package com.adn.service;

import com.adn.model.response.SecuenciaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaService {

    @Autowired
    private RestTemplate clienteRest;

    public SecuenciaResponse consulta(){
        SecuenciaResponse secuenciaResponse= clienteRest.getForObject("https://run.mocky.io/v3/5207c458-b155-4940-acaf-f15870d5caa0",SecuenciaResponse.class);
        return secuenciaResponse;
    }

    // clienteRest.exchange("http://servicio-productos/crear", HttpMethod.POST, body, Producto.class);
    // Map<String, String> parametros = new HashMap<String, String>();
	// parametros.put("id", id.toString());
    // clienteRest.exchange("http://servicio-productos/editar/{id}", HttpMethod.PUT, body, Producto.class, parametros);
    // clienteRest.delete("http://servicio-productos/eliminar/{id}", parametros);
}
