package com.bastos.aluraflix.entrypoint.mapper;

import com.bastos.aluraflix.entrypoint.model.response.CategoriaModelResponse;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.util.categoria.CategoriaMock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriaModelMapperTest {

    @Test
    public void testToModelResponseListSuccess() {
        List<CategoriaModelResponse> categoriaModelResponses =
                CategoriaModelMapper.toModelResponse(CategoriaMock.mockBuilderCategoriasDomainResponse());

        assertAll(
                () -> assertEquals(Long.valueOf(1), categoriaModelResponses.get(0).getId()),
                () -> assertEquals("LIVRE", categoriaModelResponses.get(0).getTitulo()),
                () -> assertEquals("verde", categoriaModelResponses.get(0).getCor()),

                () -> assertEquals(Long.valueOf(2), categoriaModelResponses.get(1).getId()),
                () -> assertEquals("+12", categoriaModelResponses.get(1).getTitulo()),
                () -> assertEquals("laranja", categoriaModelResponses.get(1).getCor())
        );
    }

    @Test
    public void testToModelResponseSuccess() {
        CategoriaModelResponse categoriaModelResponse =
                CategoriaModelMapper.toModelResponse(CategoriaMock.mockBuilderCategoriaDomainResponse());

        assertAll(
                () -> assertEquals(Long.valueOf(2), categoriaModelResponse.getId()),
                () -> assertEquals("+12", categoriaModelResponse.getTitulo()),
                () -> assertEquals("laranja", categoriaModelResponse.getCor()),
                () -> assertEquals(Long.valueOf(1), categoriaModelResponse.getVideos().get(0).getId()),
                () -> assertEquals("Homem de Ferro", categoriaModelResponse.getVideos().get(0).getTitulo()),
                () -> assertEquals("Filme numero 1", categoriaModelResponse.getVideos().get(0).getDescricao()),
                () -> assertEquals("/homem-de-ferro", categoriaModelResponse.getVideos().get(0).getUrl()),

                () -> assertEquals(Long.valueOf(2), categoriaModelResponse.getVideos().get(1).getId()),
                () -> assertEquals("Homem de Ferro 2", categoriaModelResponse.getVideos().get(1).getTitulo()),
                () -> assertEquals("Filme numero 2", categoriaModelResponse.getVideos().get(1).getDescricao()),
                () -> assertEquals("/homem-de-ferro-2", categoriaModelResponse.getVideos().get(1).getUrl())
        );
    }

    @Test
    public void testToModelResponseWhenVideoEmptyList() {
        CategoriaModelResponse categoriaModelResponse =
                CategoriaModelMapper.toModelResponse(CategoriaMock.mockBuilderCategoriaDomainResponseWhenVideoEmptyList());

        assertAll(
                () -> assertEquals(Long.valueOf(2), categoriaModelResponse.getId()),
                () -> assertEquals("+12", categoriaModelResponse.getTitulo()),
                () -> assertEquals("laranja", categoriaModelResponse.getCor()),
                () -> assertEquals(0, categoriaModelResponse.getVideos().size())
        );
    }

    @Test
    public void testToDomainRequestSaveSuccess() {
        CategoriaDomainRequest categoriaDomainRequest =
                CategoriaModelMapper.toDomain(CategoriaMock.mockBuilderCategoriasModelRequest());

        assertAll(
                () -> assertEquals("LIVRE", categoriaDomainRequest.getTitulo()),
                () -> assertEquals("verde", categoriaDomainRequest.getCor())
        );
    }

    @Test
    public void testToDomainRequestUpdateSuccess() {
        CategoriaDomainRequest categoriaDomainRequest =
                CategoriaModelMapper.toDomain(CategoriaMock.mockBuilderCategoriasModelRequestPartial());

        assertAll(
                () -> assertEquals("LIVRE", categoriaDomainRequest.getTitulo()),
                () -> assertEquals("verde", categoriaDomainRequest.getCor())
        );
    }
}
