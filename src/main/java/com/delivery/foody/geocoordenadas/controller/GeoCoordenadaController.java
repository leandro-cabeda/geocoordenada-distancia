package com.delivery.foody.geocoordenadas.controller;

import com.delivery.foody.geocoordenadas.controller.dto.ResponseDTO;
import com.delivery.foody.geocoordenadas.dto.GeoCoodernadaDTO;
import com.delivery.foody.geocoordenadas.service.GeoCoordenadaCalculaDistancia;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/geocoordenada")
public class GeoCoordenadaController {

    @Autowired
    private GeoCoordenadaCalculaDistancia service;

    @GetMapping
    public ResponseEntity welcome() {
        return ResponseEntity.ok("Welcome Api!");
    }

    @GetMapping("/distance")
    public ResponseEntity<ResponseDTO<?>> calculaDistance(GeoCoodernadaDTO dto) {

        ResponseDTO res = new ResponseDTO();

        log.info("Calculado a distância entre dois pontos geocordenadas com sucesso!");

        res.setMessage("Calculado a distância entre dois pontos geocordenadas com sucesso!");
        // Chama o serviço de calcular distância entre dois pontos de geocoordenadas e retorna o valor da distância dos dois.
        res.setData(service.calculaDistancia(dto.getLatitude1(), dto.getLongitude1(),
                dto.getLatitude2(), dto.getLongitude2()) + " K.M.");
        return ResponseEntity.ok(res);
    }

}
