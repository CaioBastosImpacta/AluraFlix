package com.bastos.aluraflix.usecase.domain.response;

import lombok.*;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoDomainResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private String url;
    private CategoriaDomainResponse categoria;
}
