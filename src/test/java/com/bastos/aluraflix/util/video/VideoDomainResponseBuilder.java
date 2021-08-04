package com.bastos.aluraflix.util.video;

import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;

public class VideoDomainResponseBuilder {

    private Long id;
    private String titulo;
    private String descricao;
    private String url;
    private CategoriaDomainResponse categoria;

    public VideoDomainResponseBuilder comId(Long id) {
        this.id = id;
        return this;
    }

    public VideoDomainResponseBuilder comTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public VideoDomainResponseBuilder comDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public VideoDomainResponseBuilder comUrl(String url) {
        this.url = url;
        return this;
    }

    public VideoDomainResponseBuilder comCategoria(CategoriaDomainResponse categoria) {
        this.categoria = categoria;
        return this;
    }

    public VideoDomainResponse criar() {
        return new VideoDomainResponse(id, titulo, descricao, url, categoria);
    }
}
