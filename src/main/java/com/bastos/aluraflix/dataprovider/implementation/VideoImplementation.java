package com.bastos.aluraflix.dataprovider.implementation;

import com.bastos.aluraflix.dataprovider.mapper.VideoMapperDomain;
import com.bastos.aluraflix.dataprovider.repository.VideoRepository;
import com.bastos.aluraflix.dataprovider.repository.entity.VideoEntity;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import com.bastos.aluraflix.usecase.gateway.VideoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VideoImplementation implements VideoGateway {

    @Autowired
    VideoRepository videoRepository;

    @Override
    public List<VideoDomainResponse> getAll() {
        List<VideoEntity> videosEntities = videoRepository.findAll();

        if (videosEntities.isEmpty()) {
            return null;
        }

        return VideoMapperDomain.toDomain(videosEntities);
    }

    @Override
    public VideoDomainResponse getById(Long id) {
        Optional<VideoEntity> videoEntity = videoRepository.findById(id);

        if (videoEntity.isEmpty()) {
            return null;
        }

        return VideoMapperDomain.toDomain(videoEntity.get());
    }

    @Override
    public VideoDomainResponse save(VideoDomainRequest videoDomainRequest) {
        VideoEntity videoEntityRequest = VideoMapperDomain.toEntity(videoDomainRequest);
        VideoEntity videoEntity = videoRepository.save(videoEntityRequest);

        return VideoMapperDomain.toDomain(videoEntity);
    }
}
