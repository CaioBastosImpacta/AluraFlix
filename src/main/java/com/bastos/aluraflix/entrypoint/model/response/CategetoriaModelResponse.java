package com.bastos.aluraflix.entrypoint.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategetoriaModelResponse {

    private Long id;
    private String titulo;
    private String cor;
}
