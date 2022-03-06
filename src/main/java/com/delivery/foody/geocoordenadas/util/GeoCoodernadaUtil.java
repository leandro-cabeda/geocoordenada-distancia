package com.delivery.foody.geocoordenadas.util;


public class GeoCoodernadaUtil {

    // Função que calcula a distancia entre duas geo-coordenadas
    public static double haversine(double lat1, double lon1,
                                   double lat2, double lon2) {
        // Distancia entre duas latitudades e longitudes
        double lat = Math.toRadians(lat2 - lat1);
        double lon = Math.toRadians(lon2 - lon1);

        // Converte para radians.
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Formula de calculo
        double a = Math.pow(Math.sin(lat / 2), 2) +
                Math.pow(Math.sin(lon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);

        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        double d = rad * c;
        return (Math.round(d * 10.0) / 10.0);
    }
}
