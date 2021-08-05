package com.bastos.aluraflix.entrypoint.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CategoriaModelResponse {

    private Long id;
    private String titulo;
    private String cor;
    private List<VideoModelResponse> videos;
}
