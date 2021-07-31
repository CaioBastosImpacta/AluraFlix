package com.bastos.aluraflix.usecase.domain.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VideoDomainRequest {

    private String titulo;
    private String descricao;
    private String url;
    private CategoriaDomainRequest categoria;
}
