package com.bastos.aluraflix.entrypoint.mapper;

import com.bastos.aluraflix.entrypoint.model.request.CategoriaModelRequest;
import com.bastos.aluraflix.entrypoint.model.request.VideoModelRequest;
import com.bastos.aluraflix.entrypoint.model.request.VideoPartialModelRequest;
import com.bastos.aluraflix.entrypoint.model.response.VideoModelResponse;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;

import java.util.List;
import java.util.stream.Collectors;

public class VideoMapperModel {

    public static List<VideoModelResponse> toModelResponse(List<VideoDomainResponse> videosDomainsResponses) {
        return videosDomainsResponses.stream()
                .map(videoDomainResponse ->
                        VideoModelResponse.builder()
                            .id(videoDomainResponse.getId())
                            .titulo(videoDomainResponse.getTitulo())
                            .descricao(videoDomainResponse.getDescricao())
                            .url(videoDomainResponse.getUrl())
                        .build()
                ).collect(Collectors.toList());
    }

    public static VideoModelResponse toModelResponse(VideoDomainResponse videoDomainResponse) {
        return VideoModelResponse.builder()
                .id(videoDomainResponse.getId())
                .titulo(videoDomainResponse.getTitulo())
                .descricao(videoDomainResponse.getDescricao())
                .url(videoDomainResponse.getUrl())
                .categoriaId(videoDomainResponse.getCategoriaId())
                .build();
    }

    public static VideoDomainRequest toDomain(VideoModelRequest videoModelRequest) {
        return VideoDomainRequest.builder()
                .titulo(videoModelRequest.getTitulo())
                .descricao(videoModelRequest.getDescricao())
                .url(videoModelRequest.getUrl())
                .categoria(toDomainCategoria(videoModelRequest.getCategoria()))
                .build();
    }

    private static CategoriaDomainRequest toDomainCategoria(CategoriaModelRequest categoria) {
        return CategoriaDomainRequest.builder()
                .id(categoria.getId())
                .build();
    }

    public static VideoDomainRequest toDomain(VideoPartialModelRequest videoPartialModelRequest) {
        return VideoDomainRequest.builder()
                .titulo(videoPartialModelRequest.getTitulo())
                .descricao(videoPartialModelRequest.getDescricao())
                .url(videoPartialModelRequest.getUrl())
                .build();
    }
}
