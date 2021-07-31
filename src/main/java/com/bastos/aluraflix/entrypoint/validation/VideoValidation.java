package com.bastos.aluraflix.entrypoint.validation;

import com.bastos.aluraflix.entrypoint.model.request.CategoriaModelRequest;
import com.bastos.aluraflix.entrypoint.model.request.VideoModelRequest;
import com.bastos.aluraflix.exception.BadRequestException;

import java.util.Objects;

public class VideoValidation {

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

        if (Objects.isNull(idCategoria)) {
            categoriaModelRequest.setId(1L);
        }
    }
}
