package com.bastos.aluraflix.entrypoint.controller;

import com.bastos.aluraflix.dataprovider.repository.CategoriaRepository;
import com.bastos.aluraflix.entrypoint.mapper.CategoriaModelMapper;
import com.bastos.aluraflix.util.categoria.CategoriaMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CategoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private CategoriaController categoriaController;

    @MockBean
    private CategoriaRepository categoriaRepository;

    @Spy
    private CategoriaModelMapper categoriaModelMapper;

    /*@Test
    public void testGetAllSuccess() throws Exception {
        BDDMockito.given(this.categoriaRepository.findAll()).willReturn(CategoriaMock.mockBuilderCategoriasEntity());

        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get("/categorias"));

        assertNotNull(result);
        result.andExpect(status().isOk());
    }*/
}
