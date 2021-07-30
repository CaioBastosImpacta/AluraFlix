package com.bastos.aluraflix.entrypoint.mapper;

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
}
