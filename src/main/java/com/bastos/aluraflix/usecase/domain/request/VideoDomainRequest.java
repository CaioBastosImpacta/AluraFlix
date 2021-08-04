package com.bastos.aluraflix.usecase.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoDomainRequest {

    private String titulo;
    private String descricao;
    private String url;
    private CategoriaDomainRequest categoria;
}
