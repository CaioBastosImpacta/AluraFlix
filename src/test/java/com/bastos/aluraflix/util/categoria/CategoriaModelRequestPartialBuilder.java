package com.bastos.aluraflix.util.categoria;

import com.bastos.aluraflix.entrypoint.model.request.CategoriaPartialModelRequest;

public class CategoriaModelRequestPartialBuilder {

    private String titulo;
    private String cor;

    public CategoriaModelRequestPartialBuilder comTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public CategoriaModelRequestPartialBuilder comCor(String cor) {
        this.cor = cor;
        return this;
    }

    public CategoriaPartialModelRequest criar() {
        return new CategoriaPartialModelRequest(titulo, cor);
    }
}
