package com.bastos.aluraflix.usecase.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum CategoriaEnum {

    LIVRE(1L, "LIVRE");

    private Long id;
    private String titulo;

    public static Optional<String> buscarTituloCategoriaById(Long id) {
        if (Objects.nonNull(id)) {
            Arrays.stream(values())
                    .filter(categoriaEnum -> categoriaEnum.getId().equals(id))
                    .map(CategoriaEnum::getTitulo);
        }
        return Optional.empty();
    }
}
