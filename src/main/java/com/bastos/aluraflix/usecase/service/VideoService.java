package com.bastos.aluraflix.usecase.service;

import com.bastos.aluraflix.exception.ErroInternoServidor;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import com.bastos.aluraflix.usecase.gateway.VideoGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class VideoService {

    VideoGateway videoGateway;

    public List<VideoDomainResponse> getAllVideos() {
        return videoGateway.getAll();
    }

    public VideoDomainResponse getByIdVideo(Long id) {
        return videoGateway.getById(id);
    }

    public VideoDomainResponse save(VideoDomainRequest videoDomainRequest) {
        try {
            return videoGateway.save(videoDomainRequest);
        } catch (Exception exception) {
            throw new ErroInternoServidor("Houve um erro ao salvar os dados do vídeo na base.");
        }
    }

    public VideoDomainResponse update(Long id, VideoDomainRequest videoDomainRequest) {
        VideoDomainResponse videoDomainResponse = getByIdVideo(id);

        if (Objects.nonNull(videoDomainRequest.getTitulo())) {
            videoDomainResponse.setTitulo(videoDomainRequest.getTitulo());
        }

        if (Objects.nonNull(videoDomainRequest.getDescricao())) {
            videoDomainResponse.setDescricao(videoDomainRequest.getDescricao());
        }

        if (Objects.nonNull(videoDomainRequest.getUrl())) {
            videoDomainResponse.setUrl(videoDomainRequest.getUrl());
        }

        return videoGateway.update(videoDomainResponse);
    }

    public void deleteById(Long id) {
        getByIdVideo(id);
        videoGateway.deleteById(id);
    }
}
