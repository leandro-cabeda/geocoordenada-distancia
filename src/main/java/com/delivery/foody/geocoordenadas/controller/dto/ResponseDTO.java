package com.delivery.foody.geocoordenadas.controller.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO<T> {

    private T data;
    private String message;

}
