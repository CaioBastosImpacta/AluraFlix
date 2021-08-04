package com.bastos.aluraflix.util.video;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.dataprovider.repository.entity.VideoEntity;

public class VideoEntityBuilder {

    private Long id;
    private String titulo;
    private String descricao;
    private String url;
    private CategoriaEntity categoria;

    public VideoEntityBuilder comId(Long id) {
        this.id = id;
        return this;
    }

    public VideoEntityBuilder comTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public VideoEntityBuilder comDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public VideoEntityBuilder comUrl(String url) {
        this.url = url;
        return this;
    }

    public VideoEntityBuilder comCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
        return this;
    }

    public VideoEntity criar() {
        return new VideoEntity(id, titulo, descricao, url, categoria);
    }
}
