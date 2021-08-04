package com.bastos.aluraflix.util.categoria;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;

public class CategoriaEntityBuilder {

    private Long id;
    private String nome;
    private String titulo;
    private String cor;

    public CategoriaEntityBuilder comId(Long id) {
        this.id = id;
        return this;
    }

    public CategoriaEntityBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public CategoriaEntityBuilder comTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public CategoriaEntityBuilder comCor(String cor) {
        this.cor = cor;
        return this;
    }

    public CategoriaEntity criar() {
        return new CategoriaEntity(id, nome, titulo, cor);
    }
}
