package com.bastos.aluraflix.dataprovider.mapper;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.util.categoria.CategoriaMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class CategoriaDomainMapperTest {

    @Spy
    private CategoriaDomainMapper categoriaDomainMapper;

    @Test
    public void testToDomainListSuccess() {
        List<CategoriaDomainResponse> categoriaDomainResponses =
                categoriaDomainMapper.toDomain(CategoriaMock.mockBuilderCategoriasEntity());
        assertNotNull(categoriaDomainResponses);

        assertAll(
                () -> assertEquals(Long.valueOf(1), categoriaDomainResponses.get(0).getId()),
                () -> assertEquals("LIVRE", categoriaDomainResponses.get(0).getTitulo()),
                () -> assertEquals("verde", categoriaDomainResponses.get(0).getCor()),

                () -> assertEquals(Long.valueOf(2), categoriaDomainResponses.get(1).getId()),
                () -> assertEquals("+12", categoriaDomainResponses.get(1).getTitulo()),
                () -> assertEquals("laranja", categoriaDomainResponses.get(1).getCor())
        );
    }

    @Test
    public void testToDomainSuccess() {
        CategoriaDomainResponse categoriaDomainResponse =
                categoriaDomainMapper.toDomain(CategoriaMock.mockBuilderCategoriaEntity());
        assertNotNull(categoriaDomainResponse);

        assertAll(
                () -> assertEquals(Long.valueOf(1), categoriaDomainResponse.getId()),
                () -> assertEquals("LIVRE", categoriaDomainResponse.getTitulo()),
                () -> assertEquals("verde", categoriaDomainResponse.getCor())
        );
    }

    @Test
    public void testToEntitySaveSuccess() {
        CategoriaEntity categoriaEntity =
                categoriaDomainMapper.toEntity(CategoriaMock.mockBuilderCategoriaDomainRequest());
        assertNotNull(categoriaEntity);

        assertAll(
                () -> assertEquals("LIVRE", categoriaEntity.getTitulo()),
                () -> assertEquals("verde", categoriaEntity.getCor())
        );
    }

    @Test
    public void testToEntitySaveWhenNomeNullSuccess() {
        CategoriaEntity categoriaEntity =
                categoriaDomainMapper.toEntity(CategoriaMock.mockBuilderCategoriaDomainRequestWhenTituloNull());
        assertNotNull(categoriaEntity);

        assertAll(
                () -> assertEquals("LIVRE", categoriaEntity.getTitulo()),
                () -> assertEquals("verde", categoriaEntity.getCor())
        );
    }

    @Test
    public void testToEntityUpdateSuccess() {
        CategoriaEntity categoriaEntity =
                categoriaDomainMapper.toEntity(CategoriaMock.mockBuilderCategoriaDomainResponse());
        assertNotNull(categoriaEntity);

        assertAll(
                () -> assertEquals(Long.valueOf(2), categoriaEntity.getId()),
                () -> assertEquals("+12", categoriaEntity.getTitulo()),
                () -> assertEquals("laranja", categoriaEntity.getCor())
        );
    }
}
