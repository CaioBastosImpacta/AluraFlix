package com.bastos.aluraflix.dataprovider.implementation;

import com.bastos.aluraflix.dataprovider.mapper.VideoMapperDomain;
import com.bastos.aluraflix.dataprovider.repository.VideoRepository;
import com.bastos.aluraflix.dataprovider.repository.entity.VideoEntity;
import com.bastos.aluraflix.exception.NenhumConteudoException;
import com.bastos.aluraflix.exception.RegistradoNaoEncontradoException;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import com.bastos.aluraflix.usecase.gateway.VideoGateway;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Component
public class VideoImplementation implements VideoGateway {

    private final VideoRepository videoRepository;
    private final VideoMapperDomain videoMapperDomain;
    @Override
    public Page<VideoDomainResponse> getAll(Pageable pageRequest) {
        Page<VideoEntity> videosEntities = videoRepository.findAll(pageRequest);
        validaRetornoListaVazia(videosEntities);

        return videoMapperDomain.toDomain(videosEntities);
    }

    @Override
    public VideoDomainResponse getById(Long id) {
        VideoEntity videoEntity = videoRepository.findById(id)
                .orElseThrow(() -> new RegistradoNaoEncontradoException(
                        String.format("O video com o código '%s' não foi encontrado, nos registros.", id)));

        return videoMapperDomain.toDomain(videoEntity);
    }

    @Transactional
    @Override
    public VideoDomainResponse save(VideoDomainRequest videoDomainRequest) {
        VideoEntity videoEntityRequest = videoMapperDomain.toEntity(videoDomainRequest);
        VideoEntity videoEntity = videoRepository.save(videoEntityRequest);

        return videoMapperDomain.toDomain(videoEntity);
    }

    @Transactional
    @Override
    public VideoDomainResponse update(VideoDomainResponse videoDomainResponse) {
        VideoEntity videoEntityRequest = videoMapperDomain.toEntity(videoDomainResponse);
        VideoEntity videoEntity = videoRepository.save(videoEntityRequest);

        return videoMapperDomain.toDomain(videoEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        videoRepository.deleteById(id);
    }

    @Override
    public List<VideoDomainResponse> findByCategoriaId(Long id) {
        List<VideoEntity> videoEntities = videoRepository.findByCategoriaId(id)
                .orElseThrow(() -> new RegistradoNaoEncontradoException(
                        String.format("Não existe video relacionado a categoria '%s'.", id)));

        return videoMapperDomain.toDomain(videoEntities);
    }

    @Override
    public Page<VideoDomainResponse> findByTitulo(String search, Pageable pageRequest) {
        Page<VideoEntity> videoEntities = videoRepository.findByTitulo(search, pageRequest);
        validaRetornoListaVazia(videoEntities);

        return videoMapperDomain.toDomain(videoEntities);
    }

    @Override
    public Page<VideoDomainResponse> getVideoFree(Pageable pageable) {
        Page<VideoEntity> videosEntites = videoRepository.findAll(pageable);
        validaRetornoListaVazia(videosEntites);

        return videoMapperDomain.toDomain(videosEntites);
    }

    private void validaRetornoListaVazia(Page<VideoEntity> videoEntities) {
        if (videoEntities.isEmpty()) {
            throw new NenhumConteudoException();
        }
    }
}
