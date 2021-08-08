package com.bastos.aluraflix.entrypoint.controller;

import com.bastos.aluraflix.commons.DataModelMapper;
import com.bastos.aluraflix.commons.DataModelResponse;
import com.bastos.aluraflix.entrypoint.mapper.VideoMapperModel;
import com.bastos.aluraflix.entrypoint.model.request.VideoModelRequest;
import com.bastos.aluraflix.entrypoint.model.request.VideoPartialModelRequest;
import com.bastos.aluraflix.entrypoint.model.response.VideoModelResponse;
import com.bastos.aluraflix.entrypoint.validation.VideoValidation;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import com.bastos.aluraflix.usecase.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/videos")
public class VideoController {

    private final VideoService videoService;
    private final VideoMapperModel videoMapperModel;
    private final DataModelMapper dataModelMapper;

    @GetMapping
    public ResponseEntity<DataModelResponse<Page<VideoModelResponse>>> getAll(@RequestParam(required = false) String search,
                    @PageableDefault(page = 0, size = 5, sort = "titulo", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<VideoDomainResponse> videosDomainsResponses = videoService.getAllVideos(search, pageable);
        Page<VideoModelResponse> videosModelsResponses = videoMapperModel.toModelResponse(videosDomainsResponses);
        DataModelResponse dataModelResponseVideo = dataModelMapper.setDataModel(videosModelsResponses);

        return ResponseEntity.ok(dataModelResponseVideo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataModelResponse<VideoModelResponse>> getById(@PathVariable Long id) {

        VideoDomainResponse videoDomainResponse = videoService.getByIdVideo(id);
        VideoModelResponse videoModelResponse = videoMapperModel.toModelResponse(videoDomainResponse);
        DataModelResponse dataModelResponseVideo = dataModelMapper.setDataModel(videoModelResponse);

        return ResponseEntity.ok(dataModelResponseVideo);
    }

    @GetMapping("/free")
    public ResponseEntity<?> getVideosFree() {
        Page<VideoDomainResponse> videoDomainResponse = videoService.getVideoFree();
        Page<VideoModelResponse> videoModelResponse = videoMapperModel.toModelResponse(videoDomainResponse);
        DataModelResponse dataModelResponseVideo = dataModelMapper.setDataModel(videoModelResponse);

        return ResponseEntity.ok(dataModelResponseVideo);
    }

    @PostMapping
    public ResponseEntity<DataModelResponse<VideoModelResponse>> save(@RequestBody @Validated VideoModelRequest videoModelRequest) {

        VideoValidation.validate(videoModelRequest);
        VideoDomainRequest videoDomainRequest = videoMapperModel.toDomain(videoModelRequest);
        VideoDomainResponse videoDomainResponse = videoService.save(videoDomainRequest);
        VideoModelResponse videoModelResponse = videoMapperModel.toModelResponse(videoDomainResponse);
        DataModelResponse dataModelResponseVideo = dataModelMapper.setDataModel(videoModelResponse);

        return new ResponseEntity<>(dataModelResponseVideo, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DataModelResponse<VideoModelResponse>> updatePartial(@PathVariable Long id,
                                                                               @RequestBody VideoPartialModelRequest videoPartialModelRequest) {

        VideoDomainRequest videoDomainRequest = videoMapperModel.toDomain(videoPartialModelRequest);
        VideoDomainResponse videoDomainResponse = videoService.update(id, videoDomainRequest);
        VideoModelResponse videoModelResponse = videoMapperModel.toModelResponse(videoDomainResponse);
        DataModelResponse dataModelResponseVideo = dataModelMapper.setDataModel(videoModelResponse);

        return ResponseEntity.ok(dataModelResponseVideo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        videoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
