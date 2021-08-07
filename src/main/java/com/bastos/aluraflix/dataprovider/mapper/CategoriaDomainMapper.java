package com.bastos.aluraflix.dataprovider.mapper;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CategoriaDomainMapper {

    private static final String LIVRE = "LIVRE";

    public Page<CategoriaDomainResponse> toDomain(Page<CategoriaEntity> categoriasEntities) {
        return categoriasEntities.map(categoriaEntity -> CategoriaDomainResponse.builder()
                        .id(categoriaEntity.getId())
                        .titulo(categoriaEntity.getTitulo())
                        .cor(categoriaEntity.getCor())
                        .build());
    }

    public CategoriaDomainResponse toDomain(CategoriaEntity categoriaEntity) {
        return CategoriaDomainResponse.builder()
                .id(categoriaEntity.getId())
                .titulo(categoriaEntity.getTitulo())
                .cor(categoriaEntity.getCor())
                .build();
    }

    public CategoriaEntity toEntity(CategoriaDomainRequest categoriaDomainRequest) {
        return CategoriaEntity.builder()
                .titulo(Objects.isNull(categoriaDomainRequest.getTitulo()) ? LIVRE : categoriaDomainRequest.getTitulo())
                .cor(categoriaDomainRequest.getCor())
                .build();
    }

    public CategoriaEntity toEntity(CategoriaDomainResponse categoriaDomainResponse) {
        return CategoriaEntity.builder()
                .id(categoriaDomainResponse.getId())
                .titulo(categoriaDomainResponse.getTitulo())
                .cor(categoriaDomainResponse.getCor())
                .build();
    }
}
