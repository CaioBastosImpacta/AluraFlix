package com.bastos.aluraflix.dataprovider.mapper;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.util.categoria.CategoriaMock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriaDomainMapperTest {

    @Test
    public void testToDomainListSuccess() {
        List<CategoriaDomainResponse> categoriaDomainResponses =
                CategoriaDomainMapper.toDomain(CategoriaMock.mockBuilderCategoriasEntity());
        assertNotNull(categoriaDomainResponses);

        assertAll(
                () -> assertEquals(Long.valueOf(1), categoriaDomainResponses.get(0).getId()),
                () -> assertEquals("LIVRE", categoriaDomainResponses.get(0).getNome()),
                () -> assertEquals("Categoria Livre", categoriaDomainResponses.get(0).getTitulo()),
                () -> assertEquals("verde", categoriaDomainResponses.get(0).getCor()),

                () -> assertEquals(Long.valueOf(2), categoriaDomainResponses.get(1).getId()),
                () -> assertEquals("+12", categoriaDomainResponses.get(1).getNome()),
                () -> assertEquals("Proibido para menores de 12 anos", categoriaDomainResponses.get(1).getTitulo()),
                () -> assertEquals("laranja", categoriaDomainResponses.get(1).getCor())
        );
    }

    @Test
    public void testToDomainSuccess() {
        CategoriaDomainResponse categoriaDomainResponse =
                CategoriaDomainMapper.toDomain(CategoriaMock.mockBuilderCategoriaEntity());
        assertNotNull(categoriaDomainResponse);

        assertAll(
                () -> assertEquals(Long.valueOf(1), categoriaDomainResponse.getId()),
                () -> assertEquals("LIVRE", categoriaDomainResponse.getNome()),
                () -> assertEquals("Categoria Livre", categoriaDomainResponse.getTitulo()),
                () -> assertEquals("verde", categoriaDomainResponse.getCor())
        );
    }

    @Test
    public void testToEntitySaveSuccess() {
        CategoriaEntity categoriaEntity =
                CategoriaDomainMapper.toEntity(CategoriaMock.mockBuilderCategoriaDomainRequest());
        assertNotNull(categoriaEntity);

        assertAll(
                () -> assertEquals("LIVRE", categoriaEntity.getNome()),
                () -> assertEquals("Categoria Livre", categoriaEntity.getTitulo()),
                () -> assertEquals("verde", categoriaEntity.getCor())
        );
    }

    @Test
    public void testToEntitySaveWhenNomeNullSuccess() {
        CategoriaEntity categoriaEntity =
                CategoriaDomainMapper.toEntity(CategoriaMock.mockBuilderCategoriaDomainRequestWhenTituloNull());
        assertNotNull(categoriaEntity);

        assertAll(
                () -> assertEquals("LIVRE", categoriaEntity.getNome()),
                () -> assertEquals("Categoria Livre", categoriaEntity.getTitulo()),
                () -> assertEquals("verde", categoriaEntity.getCor())
        );
    }

    @Test
    public void testToEntityUpdateSuccess() {
        CategoriaEntity categoriaEntity =
                CategoriaDomainMapper.toEntity(CategoriaMock.mockBuilderCategoriaDomainResponse());
        assertNotNull(categoriaEntity);

        assertAll(
                () -> assertEquals(Long.valueOf(2), categoriaEntity.getId()),
                () -> assertEquals("+12", categoriaEntity.getNome()),
                () -> assertEquals("Proibido para menores de 12 anos", categoriaEntity.getTitulo()),
                () -> assertEquals("laranja", categoriaEntity.getCor())
        );
    }
}
