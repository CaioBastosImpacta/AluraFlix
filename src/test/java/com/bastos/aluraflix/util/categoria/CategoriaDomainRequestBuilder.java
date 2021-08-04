package com.bastos.aluraflix.util.categoria;

import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;

public class CategoriaDomainRequestBuilder {

    private Long id;
    private String nome;
    private String titulo;
    private String cor;

    public CategoriaDomainRequestBuilder comId(Long id) {
        this.id = id;
        return this;
    }

    public CategoriaDomainRequestBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public CategoriaDomainRequestBuilder comTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public CategoriaDomainRequestBuilder comCor(String cor) {
        this.cor = cor;
        return this;
    }

    public CategoriaDomainRequest criar() {
        return new CategoriaDomainRequest(id, nome, titulo, cor);
    }
}

