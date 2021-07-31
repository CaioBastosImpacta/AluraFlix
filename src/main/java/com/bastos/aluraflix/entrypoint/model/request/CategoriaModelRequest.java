package com.bastos.aluraflix.entrypoint.model.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CategoriaModelRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String cor;
}
