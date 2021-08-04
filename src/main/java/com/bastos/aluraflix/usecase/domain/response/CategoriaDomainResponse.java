package com.bastos.aluraflix.usecase.domain.response;

import lombok.*;

import java.util.List;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDomainResponse {

    private Long id;
    private String nome;
    private String titulo;
    private String cor;
    private List<VideoDomainResponse> videos;
}
