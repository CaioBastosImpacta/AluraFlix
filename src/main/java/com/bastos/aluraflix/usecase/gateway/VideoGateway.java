package com.bastos.aluraflix.usecase.gateway;

import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;

import java.util.List;

public interface VideoGateway {

    List<VideoDomainResponse> getAll();
    VideoDomainResponse getById(Long id);
    VideoDomainResponse save(VideoDomainRequest videoDomainRequest);
    VideoDomainResponse update(VideoDomainResponse videoDomainResponse);
    void deleteById(Long id);
    List<VideoDomainResponse> findByCategoriaId(Long id);
    List<VideoDomainResponse> findByTitulo(String search);
}
