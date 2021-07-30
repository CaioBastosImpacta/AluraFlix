package com.bastos.aluraflix.entrypoint.controller;

import com.bastos.aluraflix.commons.DataModelMapper;
import com.bastos.aluraflix.commons.DataModelResponse;
import com.bastos.aluraflix.entrypoint.mapper.CategoriaModelMapper;
import com.bastos.aluraflix.entrypoint.model.response.CategetoriaModelResponse;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.usecase.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/categorias")
public class CategoriaController {

    CategoriaService categoriaService;
    DataModelMapper dataModelMapper;

    @GetMapping
    public ResponseEntity<DataModelResponse<List<CategetoriaModelResponse>>> getAll() {

        List<CategoriaDomainResponse> categoriasDomainResponse = categoriaService.getAllCategorias();
        List<CategetoriaModelResponse> categoriasModelResponses = CategoriaModelMapper.toModelResponse(categoriasDomainResponse);
        DataModelResponse dataModelResponseCategoria = dataModelMapper.setDataModel(categoriasModelResponses);

        return ResponseEntity.ok(dataModelResponseCategoria);
    }
}

