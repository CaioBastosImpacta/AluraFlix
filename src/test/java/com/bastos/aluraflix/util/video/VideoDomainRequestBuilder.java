package com.bastos.aluraflix.util.video;

import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;

public class VideoDomainRequestBuilder {

    private String titulo;
    private String descricao;
    private String url;
    private CategoriaDomainRequest categoria;

    public VideoDomainRequestBuilder comTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public VideoDomainRequestBuilder comDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public VideoDomainRequestBuilder comUrl(String url) {
        this.url = url;
        return this;
    }

    public VideoDomainRequestBuilder comCategoria(CategoriaDomainRequest categoria) {
        this.categoria = categoria;
        return this;
    }

    public VideoDomainRequest criar() {
        return new VideoDomainRequest(titulo, descricao, url, categoria);
    }
}
