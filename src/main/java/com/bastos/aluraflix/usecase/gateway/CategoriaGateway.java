package com.bastos.aluraflix.usecase.gateway;

import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;

import java.util.List;

public interface CategoriaGateway {
    List<CategoriaDomainResponse> getAll();
}
