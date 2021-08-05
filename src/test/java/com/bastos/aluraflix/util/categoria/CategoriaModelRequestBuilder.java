package com.bastos.aluraflix.util.categoria;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.entrypoint.model.request.CategoriaModelRequest;

public class CategoriaModelRequestBuilder {

    private Long id;
    private String titulo;
    private String cor;

    public CategoriaModelRequestBuilder comId(Long id) {
        this.id = id;
        return this;
    }


    public CategoriaModelRequestBuilder comTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public CategoriaModelRequestBuilder comCor(String cor) {
        this.cor = cor;
        return this;
    }

    public CategoriaModelRequest criar() {
        return new CategoriaModelRequest(id, titulo, cor);
    }
}
