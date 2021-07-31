package com.bastos.aluraflix.usecase.domain.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoriaDomainRequest {

    private String titulo;
    private String cor;
}
