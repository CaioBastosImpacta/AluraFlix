package com.bastos.aluraflix.dataprovider.mapper;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.dataprovider.repository.entity.VideoEntity;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class VideoMapperDomain {

    public static List<VideoDomainResponse> toDomain(List<VideoEntity> videosEntities) {
        return videosEntities.stream()
                .map(videoEntity ->
                        VideoDomainResponse.builder()
                            .id(videoEntity.getId())
                            .titulo(videoEntity.getTitulo())
                            .descricao(videoEntity.getDescricao())
                            .url(videoEntity.getUrl())
                            .categoria(toDomainCategoria(videoEntity))
                        .build()
                ).collect(Collectors.toList());
    }

    private static CategoriaDomainResponse toDomainCategoria(VideoEntity videoEntity) {
        if (Objects.nonNull(videoEntity.getCategoria())) {
            return CategoriaDomainResponse.builder()
                    .id(videoEntity.getCategoria().getId())
                    .build();
        }

        return CategoriaDomainResponse.builder().build();
    }

    public static VideoDomainResponse toDomain(VideoEntity videoEntity) {
        return VideoDomainResponse.builder()
                .id(videoEntity.getId())
                .titulo(videoEntity.getTitulo())
                .descricao(videoEntity.getDescricao())
                .url(videoEntity.getUrl())
                .categoria(toDomainCategoria(videoEntity))
                .build();
    }

    public static VideoEntity toEntity(VideoDomainRequest videoDomainRequest) {
        return VideoEntity.builder()
                .titulo(videoDomainRequest.getTitulo())
                .descricao(videoDomainRequest.getDescricao())
                .url(videoDomainRequest.getUrl())
                .categoria(toEntityCategoria(videoDomainRequest.getCategoria()))
                .build();
    }

    private static CategoriaEntity toEntityCategoria(CategoriaDomainRequest categoria) {
        return CategoriaEntity.builder()
                .id(categoria.getId())
                .build();
    }

    public static VideoEntity toEntity(VideoDomainResponse videoDomainResponse) {
        return VideoEntity.builder()
                .id(videoDomainResponse.getId())
                .titulo(videoDomainResponse.getTitulo())
                .descricao(videoDomainResponse.getDescricao())
                .url(videoDomainResponse.getUrl())
                .categoria(toEntityCategoriaId(videoDomainResponse))
                .build();
    }

    private static CategoriaEntity toEntityCategoriaId(VideoDomainResponse videoDomainResponse) {
        return CategoriaEntity.builder()
                .id(videoDomainResponse.getCategoria().getId())
                .build();
    }
}
