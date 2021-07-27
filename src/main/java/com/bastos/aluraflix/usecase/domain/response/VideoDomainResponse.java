package com.bastos.aluraflix.usecase.domain.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VideoDomainResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private String url;
}
