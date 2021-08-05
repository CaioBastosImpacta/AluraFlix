package com.bastos.aluraflix.util.video;

import com.bastos.aluraflix.entrypoint.model.request.CategoriaModelRequest;
import com.bastos.aluraflix.entrypoint.model.request.VideoModelRequest;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;

public class VideoModelRequestBuilder {

    private String titulo;
    private String descricao;
    private String url;
    private CategoriaModelRequest categoria;

    public VideoModelRequestBuilder comTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public VideoModelRequestBuilder comDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public VideoModelRequestBuilder comUrl(String url) {
        this.url = url;
        return this;
    }

    public VideoModelRequestBuilder comCategoria(CategoriaModelRequest categoria) {
        this.categoria = categoria;
        return this;
    }

    public VideoModelRequest criar() {
        return new VideoModelRequest(titulo, descricao, url, categoria);
    }
}
