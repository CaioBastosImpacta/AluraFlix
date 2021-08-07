package com.bastos.aluraflix.dataprovider.mapper;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.dataprovider.repository.entity.VideoEntity;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class VideoMapperDomain {

    public Page<VideoDomainResponse> toDomain(Page<VideoEntity> videosEntities) {
        return videosEntities.map(videoEntity ->
                        VideoDomainResponse.builder()
                                .id(videoEntity.getId())
                                .titulo(videoEntity.getTitulo())
                                .descricao(videoEntity.getDescricao())
                                .url(videoEntity.getUrl())
                                .categoria(toDomainCategoria(videoEntity))
                                .build());
    }

    public List<VideoDomainResponse> toDomain(List<VideoEntity> videosEntities) {
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

    private CategoriaDomainResponse toDomainCategoria(VideoEntity videoEntity) {
        if (Objects.nonNull(videoEntity.getCategoria())) {
            return CategoriaDomainResponse.builder()
                    .id(videoEntity.getCategoria().getId())
                    .titulo(videoEntity.getCategoria().getTitulo())
                    .build();
        }

        return CategoriaDomainResponse.builder().build();
    }

    public VideoDomainResponse toDomain(VideoEntity videoEntity) {
        return VideoDomainResponse.builder()
                .id(videoEntity.getId())
                .titulo(videoEntity.getTitulo())
                .descricao(videoEntity.getDescricao())
                .url(videoEntity.getUrl())
                .categoria(toDomainCategoria(videoEntity))
                .build();
    }

    public VideoEntity toEntity(VideoDomainRequest videoDomainRequest) {
        return VideoEntity.builder()
                .titulo(videoDomainRequest.getTitulo())
                .descricao(videoDomainRequest.getDescricao())
                .url(videoDomainRequest.getUrl())
                .categoria(toEntityCategoria(videoDomainRequest.getCategoria()))
                .build();
    }

    private CategoriaEntity toEntityCategoria(CategoriaDomainRequest categoria) {
        return CategoriaEntity.builder()
                .id(categoria.getId())
                .build();
    }

    public VideoEntity toEntity(VideoDomainResponse videoDomainResponse) {
        return VideoEntity.builder()
                .id(videoDomainResponse.getId())
                .titulo(videoDomainResponse.getTitulo())
                .descricao(videoDomainResponse.getDescricao())
                .url(videoDomainResponse.getUrl())
                .categoria(toEntityCategoriaId(videoDomainResponse))
                .build();
    }

    private CategoriaEntity toEntityCategoriaId(VideoDomainResponse videoDomainResponse) {
        return CategoriaEntity.builder()
                .id(videoDomainResponse.getCategoria().getId())
                .build();
    }
}
