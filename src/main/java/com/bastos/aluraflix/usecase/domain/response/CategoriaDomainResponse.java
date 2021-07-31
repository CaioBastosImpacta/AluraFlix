package com.bastos.aluraflix.usecase.domain.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@Setter
public class CategoriaDomainResponse {

    private Long id;
    private String titulo;
    private String cor;
    private List<VideoDomainResponse> videos;
}
