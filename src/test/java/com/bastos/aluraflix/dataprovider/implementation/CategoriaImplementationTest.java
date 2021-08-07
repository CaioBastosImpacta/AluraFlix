package com.bastos.aluraflix.dataprovider.implementation;

import com.bastos.aluraflix.dataprovider.mapper.CategoriaDomainMapper;
import com.bastos.aluraflix.dataprovider.repository.CategoriaRepository;
import com.bastos.aluraflix.exception.NenhumConteudoException;
import com.bastos.aluraflix.exception.RegistradoNaoEncontradoException;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.util.categoria.CategoriaMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CategoriaImplementationTest {

    @InjectMocks
    private CategoriaImplementation categoriaImplementation;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Spy
    private CategoriaDomainMapper categoriaDomainMapper;

    @Test
    public void testGetAllSuccess() {
        BDDMockito.given(this.categoriaRepository.findAll()).willReturn(CategoriaMock.mockBuilderCategoriasEntity());

        List<CategoriaDomainResponse> categoriasDomain = categoriaImplementation.getAll();
        assertNotNull(categoriasDomain);
        assertEquals(2, categoriasDomain.size());

        assertEquals(Long.valueOf(1), categoriasDomain.get(0).getId());
        assertEquals("LIVRE", categoriasDomain.get(0).getTitulo());
        assertEquals("verde", categoriasDomain.get(0).getCor());

        assertEquals(Long.valueOf(2), categoriasDomain.get(1).getId());
        assertEquals("+12", categoriasDomain.get(1).getTitulo());
        assertEquals("laranja", categoriasDomain.get(1).getCor());
    }

    @Test
    public void testGetAllNoContent() {
        BDDMockito.given(this.categoriaRepository.findAll()).willReturn(Collections.emptyList());

        assertThrows(NenhumConteudoException.class, () -> categoriaImplementation.getAll());
    }

    @Test
    public void testGetByIdSuccess() {
        BDDMockito.given(this.categoriaRepository.findById(1L)).willReturn(Optional.of(CategoriaMock.mockBuilderCategoriaEntity()));

        CategoriaDomainResponse categoriasDomain = categoriaImplementation.getById(1L);
        assertNotNull(categoriasDomain);

        assertEquals(Long.valueOf(1), categoriasDomain.getId());
        assertEquals("LIVRE", categoriasDomain.getTitulo());
        assertEquals("verde", categoriasDomain.getCor());
    }

    @Test
    public void testGetByIdNotFound() {
        BDDMockito.given(this.categoriaRepository.findById(1L)).willReturn(Optional.empty());

        assertThrows(RegistradoNaoEncontradoException.class, () -> categoriaImplementation.getById(1L));
    }
}
