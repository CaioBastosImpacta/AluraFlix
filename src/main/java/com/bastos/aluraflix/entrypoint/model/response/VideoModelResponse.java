package com.bastos.aluraflix.entrypoint.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VideoModelResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private String url;
}
