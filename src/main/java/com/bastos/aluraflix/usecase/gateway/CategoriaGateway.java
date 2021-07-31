package com.bastos.aluraflix.usecase.gateway;

import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;

import java.util.List;

public interface CategoriaGateway {
    List<CategoriaDomainResponse> getAll();
    CategoriaDomainResponse getById(Long id);
    CategoriaDomainResponse save(CategoriaDomainRequest categoriaDomainRequest);
    CategoriaDomainResponse update(CategoriaDomainResponse categoriaDomainResponse);
    void deleteById(Long id);
}
