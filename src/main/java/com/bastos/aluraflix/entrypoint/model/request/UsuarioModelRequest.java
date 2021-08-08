package com.bastos.aluraflix.entrypoint.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UsuarioModelRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String senha;
}
