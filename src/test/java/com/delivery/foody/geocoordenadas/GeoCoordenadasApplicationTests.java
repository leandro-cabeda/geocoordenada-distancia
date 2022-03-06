package com.delivery.foody.geocoordenadas;

import com.delivery.foody.geocoordenadas.controller.dto.ResponseDTO;
import com.delivery.foody.geocoordenadas.dto.GeoCoodernadaDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest(classes = GeoCoordenadasApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GeoCoordenadasApplicationTests {

    @Autowired
    protected TestRestTemplate rest;

    @Test
    void welcomeApi() {
        log.info("Bem Vindo a API");

        // Realiza a busca por Get da API padrão.
        ResponseEntity response = rest.getForEntity("/geocoordenada", String.class);

        // Verifica se o resultado não veio nulo.
        assertNotNull(response.getBody());

        // Verifica se o status veio corretamente 200 de ok
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void calculaDistanciaPametros() {
        log.info("Calcula a distância entre dois pontos geocordenadas informados.");

        // Seta as informações das geocoordenadas para enviar depois na requisição da api
        GeoCoodernadaDTO dto = new GeoCoodernadaDTO();
        dto.setLatitude1(51.5007);
        dto.setLongitude1(0.1246);
        dto.setLatitude2(40.6892);
        dto.setLongitude2(74.0445);

        // Realiza a busca pela distancia do calculo das geocoordenadas enviadas por parametros
        ResponseEntity<ResponseDTO> response = rest.getForEntity("/geocoordenada/distance?latitude1="
                        + dto.getLatitude1() +
                        "&longitude1=" + dto.getLongitude1() +
                        "&latitude2=" + dto.getLatitude2() +
                        "&longitude2=" + dto.getLongitude2(),
                ResponseDTO.class);

        // Verifica se o resultado não veio nulo.
        assertNotNull(response.getBody());

        // Verifica se o status veio corretamente 200 de ok
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verifica se o resultado do calculo da distancia bate igual
        ResponseDTO respDTO = response.getBody();
        assertEquals("5574.8 K.M.", respDTO.getData());

    }

    @Test
    void calculaDistanciaSemPametros() {
        log.info("Calcula a distância entre dois pontos geocordenadas sem parametros.");

        // Realiza a busca pela distancia do calculo das geocoordenadas sem envio de informação sem parametro
        ResponseEntity<ResponseDTO> response = rest.getForEntity("/geocoordenada/distance", ResponseDTO.class);

        // Verifica se o resultado não veio nulo.
        assertNotNull(response.getBody());

        // Verifica se o status veio corretamente 200 de ok
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verifica se o resultado do calculo da distancia bate igual
        ResponseDTO respDTO = response.getBody();
        assertEquals("0.0 K.M.", respDTO.getData());

    }


}
