package com.bastos.aluraflix.entrypoint.mapper;

import com.bastos.aluraflix.entrypoint.model.request.CategoriaModelRequest;
import com.bastos.aluraflix.entrypoint.model.request.VideoModelRequest;
import com.bastos.aluraflix.entrypoint.model.request.VideoPartialModelRequest;
import com.bastos.aluraflix.entrypoint.model.response.CategoriaModelResponse;
import com.bastos.aluraflix.entrypoint.model.response.VideoModelResponse;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class VideoMapperModel {

    public List<VideoModelResponse> toModelResponse(List<VideoDomainResponse> videosDomainsResponses) {
        return videosDomainsResponses.stream()
                .map(videoDomainResponse ->
                        VideoModelResponse.builder()
                            .id(videoDomainResponse.getId())
                            .titulo(videoDomainResponse.getTitulo())
                            .descricao(videoDomainResponse.getDescricao())
                            .url(videoDomainResponse.getUrl())
                            .categoria(toModelResponseCategoria(videoDomainResponse))
                        .build()
                ).collect(Collectors.toList());
    }

    private CategoriaModelResponse toModelResponseCategoria(VideoDomainResponse videoDomainResponse) {
        if (Objects.nonNull(videoDomainResponse.getCategoria())) {
            return CategoriaModelResponse.builder()
                    .id(videoDomainResponse.getCategoria().getId())
                    .build();
        }

        return CategoriaModelResponse.builder().build();
    }

    public VideoModelResponse toModelResponse(VideoDomainResponse videoDomainResponse) {
        return VideoModelResponse.builder()
                .id(videoDomainResponse.getId())
                .titulo(videoDomainResponse.getTitulo())
                .descricao(videoDomainResponse.getDescricao())
                .url(videoDomainResponse.getUrl())
                .categoria(toModelResponseCategoria(videoDomainResponse))
                .build();
    }

    public VideoDomainRequest toDomain(VideoModelRequest videoModelRequest) {
        return VideoDomainRequest.builder()
                .titulo(videoModelRequest.getTitulo())
                .descricao(videoModelRequest.getDescricao())
                .url(videoModelRequest.getUrl())
                .categoria(toDomainCategoria(videoModelRequest.getCategoria()))
                .build();
    }

    private CategoriaDomainRequest toDomainCategoria(CategoriaModelRequest categoria) {
        return CategoriaDomainRequest.builder()
                .id(categoria.getId())
                .build();
    }

    public VideoDomainRequest toDomain(VideoPartialModelRequest videoPartialModelRequest) {
        return VideoDomainRequest.builder()
                .titulo(videoPartialModelRequest.getTitulo())
                .descricao(videoPartialModelRequest.getDescricao())
                .url(videoPartialModelRequest.getUrl())
                .build();
    }
}
