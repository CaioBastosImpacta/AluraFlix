package com.bastos.aluraflix.usecase.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoDomainResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private String url;
    private CategoriaDomainResponse categoria;
}
