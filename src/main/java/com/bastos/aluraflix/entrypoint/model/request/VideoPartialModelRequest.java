package com.bastos.aluraflix.entrypoint.model.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VideoPartialModelRequest {

    private String titulo;
    private String descricao;
    private String url;
}
