package com.bastos.aluraflix.usecase.servide;

import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import com.bastos.aluraflix.usecase.gateway.VideoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
