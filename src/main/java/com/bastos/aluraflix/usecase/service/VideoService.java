package com.bastos.aluraflix.usecase.service;

import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import com.bastos.aluraflix.usecase.gateway.VideoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class VideoService {

    VideoGateway videoGateway;

    @Autowired
    public VideoService(VideoGateway videoGateway) {
        this.videoGateway = videoGateway;
    }

    public List<VideoDomainResponse> getAllVideos() {
        return videoGateway.getAll();
    }

    public VideoDomainResponse getByIdVideo(Long id) {
        return videoGateway.getById(id);
    }

    public VideoDomainResponse save(VideoDomainRequest videoDomainRequest) {
        return videoGateway.save(videoDomainRequest);
    }

    @Transactional
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

    @Transactional
    public void deleteById(Long id) {
        getByIdVideo(id);
        videoGateway.deleteById(id);
    }
}