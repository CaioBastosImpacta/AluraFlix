package com.bastos.aluraflix.usecase.domain.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class VideoDomainResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private String url;
    private CategoriaDomainResponse categoria;
}
