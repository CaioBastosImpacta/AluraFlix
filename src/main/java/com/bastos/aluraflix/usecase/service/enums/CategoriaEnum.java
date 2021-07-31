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
    private String nome;

    public static Optional<String> buscarNomeCategoriaById(Long id) {
        if (Objects.nonNull(id)) {
            Arrays.stream(values())
                    .filter(categoriaEnum -> categoriaEnum.getId().equals(id))
                    .map(CategoriaEnum::getNome);
        }
        return Optional.empty();
    }
}
