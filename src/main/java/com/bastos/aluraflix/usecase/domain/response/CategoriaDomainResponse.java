package com.bastos.aluraflix.usecase.domain.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoriaDomainResponse {

    private Long id;
    private String titulo;
    private String cor;
}
