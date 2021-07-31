package com.bastos.aluraflix.entrypoint.validation;

import com.bastos.aluraflix.entrypoint.model.request.CategoriaModelRequest;
import com.bastos.aluraflix.entrypoint.model.request.VideoModelRequest;
import com.bastos.aluraflix.exception.BadRequestException;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class VideoValidation {

    private static final String CAMPO_ID = "categoria.id";

    public static void validate(VideoModelRequest videoModelRequest) {
        validateObjectVideo(videoModelRequest);
        validateIdCategoria(videoModelRequest.getCategoria());
    }

    private static void validateObjectVideo(VideoModelRequest videoModelRequest) {
        if (Objects.isNull(videoModelRequest)) {
            throw new BadRequestException("O objeto de entrada para o cadastro do video está inválido.");
        }
    }

    private static void validateIdCategoria(CategoriaModelRequest categoriaModelRequest) {
        Long idCategoria = categoriaModelRequest.getId();

        validateObjectCategoria(categoriaModelRequest);

        if (Objects.isNull(idCategoria)) {
            throw new BadRequestException(String.format("O campo '%s' não pode ser nulo e nem vazio.", CAMPO_ID));
        }
    }

    private static void validateObjectCategoria(CategoriaModelRequest categoriaModelRequest) {
        if (Objects.isNull(categoriaModelRequest)) {
            throw new BadRequestException("O objeto de entrada para o cadastro do video relacionado a categoria está inválido.");
        }
    }
}
