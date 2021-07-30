package com.bastos.aluraflix.dataprovider.mapper;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDomainMapper {

    public static List<CategoriaDomainResponse> toDomain(List<CategoriaEntity> categoriasEntities) {
        return categoriasEntities.stream()
                .map(categoriaEntity -> CategoriaDomainResponse.builder()
                        .id(categoriaEntity.getId())
                        .titulo(categoriaEntity.getTitulo())
                        .cor(categoriaEntity.getCor())
                        .build()).collect(Collectors.toList());
    }
}
