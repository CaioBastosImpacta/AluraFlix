package com.bastos.aluraflix.entrypoint.mapper;

import com.bastos.aluraflix.entrypoint.model.request.CategoriaPartialModelRequest;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.entrypoint.model.request.CategoriaModelRequest;
import com.bastos.aluraflix.entrypoint.model.response.CategetoriaModelResponse;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaModelMapper {

    public static List<CategetoriaModelResponse> toModelResponse(List<CategoriaDomainResponse> categoriasDomainResponse) {
        return categoriasDomainResponse.stream()
                .map(categoriaDomainResponse -> CategetoriaModelResponse.builder()
                        .id(categoriaDomainResponse.getId())
                        .titulo(categoriaDomainResponse.getTitulo())
                        .cor(categoriaDomainResponse.getCor())
                        .build()).collect(Collectors.toList());
    }

    public static CategetoriaModelResponse toModelResponse(CategoriaDomainResponse categoriaDomainResponse) {
        return CategetoriaModelResponse.builder()
                .id(categoriaDomainResponse.getId())
                .titulo(categoriaDomainResponse.getTitulo())
                .cor(categoriaDomainResponse.getCor())
                .build();
    }

    public static CategoriaDomainRequest toDomain(CategoriaModelRequest categoriaModelRequest) {
        return CategoriaDomainRequest.builder()
                .titulo(categoriaModelRequest.getTitulo())
                .cor(categoriaModelRequest.getCor())
                .build();
    }

    public static CategoriaDomainRequest toDomain(CategoriaPartialModelRequest categoriaPartialModelRequest) {
        return CategoriaDomainRequest.builder()
                .titulo(categoriaPartialModelRequest.getTitulo())
                .cor(categoriaPartialModelRequest.getCor())
                .build();
    }
}
