package com.bastos.aluraflix.dataprovider.mapper;

import com.bastos.aluraflix.dataprovider.repository.entity.VideoEntity;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;

import java.util.List;
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
                        .build()
                ).collect(Collectors.toList());
    }

    public static VideoDomainResponse toDomain(VideoEntity videoEntity) {
        return VideoDomainResponse.builder()
                .id(videoEntity.getId())
                .titulo(videoEntity.getTitulo())
                .descricao(videoEntity.getDescricao())
                .url(videoEntity.getUrl())
                .build();
    }

    public static VideoEntity toEntity(VideoDomainRequest videoDomainRequest) {
        return VideoEntity.builder()
                .titulo(videoDomainRequest.getTitulo())
                .descricao(videoDomainRequest.getDescricao())
                .url(videoDomainRequest.getUrl())
                .build();
    }
}
