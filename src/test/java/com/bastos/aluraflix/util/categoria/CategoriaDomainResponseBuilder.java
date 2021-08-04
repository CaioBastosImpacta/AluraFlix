package com.bastos.aluraflix.util.categoria;

import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;

import java.util.List;

public class CategoriaDomainResponseBuilder {

    private Long id;
    private String nome;
    private String titulo;
    private String cor;
    private List<VideoDomainResponse> videos;

    public CategoriaDomainResponseBuilder comId(Long id) {
        this.id = id;
        return this;
    }

    public CategoriaDomainResponseBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public CategoriaDomainResponseBuilder comTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public CategoriaDomainResponseBuilder comCor(String cor) {
        this.cor = cor;
        return this;
    }

    public CategoriaDomainResponseBuilder comVideos(List<VideoDomainResponse> videos) {
        this.videos = videos;
        return this;
    }

    public CategoriaDomainResponse criar() {
        return new CategoriaDomainResponse(id, nome, titulo, cor, videos);
    }
}

