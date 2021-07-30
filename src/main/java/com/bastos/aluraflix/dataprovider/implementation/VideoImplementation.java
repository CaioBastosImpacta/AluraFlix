package com.bastos.aluraflix.dataprovider.implementation;

import com.bastos.aluraflix.dataprovider.mapper.VideoMapperDomain;
import com.bastos.aluraflix.dataprovider.repository.VideoRepository;
import com.bastos.aluraflix.dataprovider.repository.entity.VideoEntity;
import com.bastos.aluraflix.exception.NenhumConteudoException;
import com.bastos.aluraflix.exception.VideoNaoRegistradoException;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import com.bastos.aluraflix.usecase.gateway.VideoGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class VideoImplementation implements VideoGateway {

    VideoRepository videoRepository;

    @Override
    public List<VideoDomainResponse> getAll() {
        List<VideoEntity> videosEntities = videoRepository.findAll();

        if (videosEntities.isEmpty()) {
            throw new NenhumConteudoException();
        }

        return VideoMapperDomain.toDomain(videosEntities);
    }

    @Override
    public VideoDomainResponse getById(Long id) {
        VideoEntity videoEntity = videoRepository.findById(id)
                .orElseThrow(() -> new VideoNaoRegistradoException(
                        String.format("O video com o código '%s' não foi encontrado, nos registros.", id)));

        return VideoMapperDomain.toDomain(videoEntity);
    }

    @Override
    public VideoDomainResponse save(VideoDomainRequest videoDomainRequest) {
        VideoEntity videoEntityRequest = VideoMapperDomain.toEntity(videoDomainRequest);
        VideoEntity videoEntity = videoRepository.save(videoEntityRequest);

        return VideoMapperDomain.toDomain(videoEntity);
    }

    @Override
    public VideoDomainResponse update(VideoDomainResponse videoDomainResponse) {
        VideoEntity videoEntityRequest = VideoMapperDomain.toEntity(videoDomainResponse);
        VideoEntity videoEntity = videoRepository.save(videoEntityRequest);

        return VideoMapperDomain.toDomain(videoEntity);
    }

    @Override
    public void deleteById(Long id) {
        videoRepository.deleteById(id);
    }
}
