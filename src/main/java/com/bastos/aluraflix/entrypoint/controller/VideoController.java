package com.bastos.aluraflix.entrypoint.controller;

import com.bastos.aluraflix.commons.DataModelMapper;
import com.bastos.aluraflix.commons.DataModelResponse;
import com.bastos.aluraflix.entrypoint.mapper.VideoMapperModel;
import com.bastos.aluraflix.entrypoint.model.request.VideoModelRequest;
import com.bastos.aluraflix.entrypoint.model.request.VideoPartialModelRequest;
import com.bastos.aluraflix.entrypoint.model.response.VideoModelResponse;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import com.bastos.aluraflix.usecase.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/videos")
public class VideoController {

    VideoService videoService;
    DataModelMapper dataModelMapper;

    @GetMapping
    public ResponseEntity<DataModelResponse<List<VideoModelResponse>>> getAll() {

        List<VideoDomainResponse> videosDomainsResponses = videoService.getAllVideos();
        List<VideoModelResponse> videosModelsResponses = VideoMapperModel.toModelResponse(videosDomainsResponses);
        DataModelResponse dataModelResponseVideo = dataModelMapper.setDataModel(videosModelsResponses);

        return ResponseEntity.ok(dataModelResponseVideo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataModelResponse<VideoModelResponse>> getById(@PathVariable Long id) {

        VideoDomainResponse videoDomainResponse = videoService.getByIdVideo(id);
        VideoModelResponse videoModelResponse = VideoMapperModel.toModelResponse(videoDomainResponse);
        DataModelResponse dataModelResponseVideo = dataModelMapper.setDataModel(videoModelResponse);

        return ResponseEntity.ok(dataModelResponseVideo);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<DataModelResponse<VideoModelResponse>> save(@RequestBody @Validated VideoModelRequest videoModelRequest) {

        VideoDomainRequest videoDomainRequest = VideoMapperModel.toDomain(videoModelRequest);
        VideoDomainResponse videoDomainResponse = videoService.save(videoDomainRequest);
        VideoModelResponse videoModelResponse = VideoMapperModel.toModelResponse(videoDomainResponse);
        DataModelResponse dataModelResponseVideo = dataModelMapper.setDataModel(videoModelResponse);

        return new ResponseEntity<>(dataModelResponseVideo, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DataModelResponse<VideoModelResponse>> updatePartial(@PathVariable Long id,
                                                                               @RequestBody VideoPartialModelRequest videoPartialModelRequest) {

        VideoDomainRequest videoDomainRequest = VideoMapperModel.toDomain(videoPartialModelRequest);
        VideoDomainResponse videoDomainResponse = videoService.update(id, videoDomainRequest);
        VideoModelResponse videoModelResponse = VideoMapperModel.toModelResponse(videoDomainResponse);
        DataModelResponse dataModelResponseVideo = dataModelMapper.setDataModel(videoModelResponse);

        return ResponseEntity.ok(dataModelResponseVideo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        videoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
