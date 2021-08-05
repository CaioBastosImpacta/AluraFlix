package com.bastos.aluraflix.util.video;

import com.bastos.aluraflix.entrypoint.model.request.VideoPartialModelRequest;

public class VideoPartialModelRequestBuilder {

    private String titulo;
    private String descricao;
    private String url;

    public VideoPartialModelRequestBuilder comTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public VideoPartialModelRequestBuilder comDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public VideoPartialModelRequestBuilder comUrl(String url) {
        this.url = url;
        return this;
    }

    public VideoPartialModelRequest criar() {
        return new VideoPartialModelRequest(titulo, descricao, url);
    }
}
