package com.bastos.aluraflix.usecase.gateway;

import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VideoGateway {

    Page<VideoDomainResponse> getAll(Pageable pageRequest);
    VideoDomainResponse getById(Long id);
    VideoDomainResponse save(VideoDomainRequest videoDomainRequest);
    VideoDomainResponse update(VideoDomainResponse videoDomainResponse);
    void deleteById(Long id);
    List<VideoDomainResponse> findByCategoriaId(Long id);
    Page<VideoDomainResponse> findByTitulo(String search, Pageable pageRequest);
    Page<VideoDomainResponse> getVideoFree(Pageable pageable);
}
