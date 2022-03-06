package com.delivery.foody.geocoordenadas.service.impl;

import com.delivery.foody.geocoordenadas.service.GeoCoordenadaCalculaDistancia;
import com.delivery.foody.geocoordenadas.util.GeoCoodernadaUtil;
import org.springframework.stereotype.Service;

@Service
public class GeoCoordenadaCalculaDistanciaImpl implements GeoCoordenadaCalculaDistancia {

    @Override
    public double calculaDistancia(double lat1, double lon1, double lat2, double lon2) {
        return GeoCoodernadaUtil.haversine(lat1, lon1, lat2, lon2);
    }
}
