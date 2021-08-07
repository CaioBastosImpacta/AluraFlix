package com.bastos.aluraflix.entrypoint.mapper;

import com.bastos.aluraflix.entrypoint.model.request.CategoriaModelRequest;
import com.bastos.aluraflix.entrypoint.model.request.CategoriaPartialModelRequest;
import com.bastos.aluraflix.entrypoint.model.response.CategoriaModelResponse;
import com.bastos.aluraflix.entrypoint.model.response.VideoModelResponse;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaModelMapper {

    public Page<CategoriaModelResponse> toModelResponse(Page<CategoriaDomainResponse> categoriasDomainResponse) {
        return categoriasDomainResponse.map(categoriaDomainResponse -> CategoriaModelResponse.builder()
                        .id(categoriaDomainResponse.getId())
                        .titulo(categoriaDomainResponse.getTitulo())
                        .cor(categoriaDomainResponse.getCor())
                        .build());
    }

    public CategoriaModelResponse toModelResponse(CategoriaDomainResponse categoriaDomainResponse) {
        return CategoriaModelResponse.builder()
                .id(categoriaDomainResponse.getId())
                .titulo(categoriaDomainResponse.getTitulo())
                .cor(categoriaDomainResponse.getCor())
                .videos(toModelResponseVideo(categoriaDomainResponse))
                .build();
    }

    private List<VideoModelResponse> toModelResponseVideo(CategoriaDomainResponse categoriaDomainResponse) {
        if (CollectionUtils.isEmpty(categoriaDomainResponse.getVideos())) {
            return Collections.emptyList();
        }

        return categoriaDomainResponse.getVideos().stream()
                .map(video -> VideoModelResponse.builder()
                        .id(video.getId())
                        .titulo(video.getTitulo())
                        .descricao(video.getDescricao())
                        .url(video.getUrl())
                        .build()).collect(Collectors.toList());
    }

    public CategoriaDomainRequest toDomain(CategoriaModelRequest categoriaModelRequest) {
        return CategoriaDomainRequest.builder()
                .titulo(categoriaModelRequest.getTitulo())
                .cor(categoriaModelRequest.getCor())
                .build();
    }

    public CategoriaDomainRequest toDomain(CategoriaPartialModelRequest categoriaPartialModelRequest) {
        return CategoriaDomainRequest.builder()
                .titulo(categoriaPartialModelRequest.getTitulo())
                .cor(categoriaPartialModelRequest.getCor())
                .build();
    }
}
