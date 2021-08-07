package com.bastos.aluraflix.usecase.domain.response;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDomainResponse {

    private Long id;
    private String titulo;
    private String cor;
    private List<VideoDomainResponse> videos;
}
