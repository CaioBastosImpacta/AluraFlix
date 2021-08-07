package com.bastos.aluraflix.entrypoint.controller;

import com.bastos.aluraflix.commons.DataModelMapper;
import com.bastos.aluraflix.commons.DataModelResponse;
import com.bastos.aluraflix.entrypoint.mapper.CategoriaModelMapper;
import com.bastos.aluraflix.entrypoint.model.request.CategoriaModelRequest;
import com.bastos.aluraflix.entrypoint.model.request.CategoriaPartialModelRequest;
import com.bastos.aluraflix.entrypoint.model.response.CategoriaModelResponse;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.usecase.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final CategoriaModelMapper categoriaModelMapper;
    private final DataModelMapper dataModelMapper;

    @GetMapping
    public ResponseEntity<DataModelResponse<Page<CategoriaModelResponse>>> getAll(@RequestParam(value="page", defaultValue="0", required = false) Integer page,
                                                                                  @RequestParam(value="linesPerPage", defaultValue="5", required = false) Integer linesPerPage,
                                                                                  @RequestParam(value="direction", defaultValue="ASC", required = false) String direction,
                                                                                  @RequestParam(value="orderBy", defaultValue="titulo", required = false) String orderBy) {

        Page<CategoriaDomainResponse> categoriasDomainResponse = categoriaService.getAllCategorias(page, linesPerPage, direction, orderBy);
        Page<CategoriaModelResponse> categoriasModelResponses = categoriaModelMapper.toModelResponse(categoriasDomainResponse);
        DataModelResponse dataModelResponseCategoria = dataModelMapper.setDataModel(categoriasModelResponses);

        return ResponseEntity.ok(dataModelResponseCategoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataModelResponse<CategoriaModelResponse>> getById(@PathVariable Long id) {

        CategoriaDomainResponse categoriaDomainResponse = categoriaService.getByIdCategoria(id);
        CategoriaModelResponse categetoriaModelResponse = categoriaModelMapper.toModelResponse(categoriaDomainResponse);
        DataModelResponse dataModelResponse = dataModelMapper.setDataModel(categetoriaModelResponse);

        return ResponseEntity.ok(dataModelResponse);
    }

    @GetMapping("/{id}/videos")
    public ResponseEntity<DataModelResponse<List<CategoriaModelResponse>>> getByIdCategoriaVideo(@PathVariable Long id) {

        CategoriaDomainResponse categoriaDomainResponse = categoriaService.getByIdCategoriaVideo(id);
        CategoriaModelResponse categetoriaModelResponse = categoriaModelMapper.toModelResponse(categoriaDomainResponse);
        DataModelResponse dataModelResponse = dataModelMapper.setDataModel(categetoriaModelResponse);

        return ResponseEntity.ok(dataModelResponse);
    }

    @PostMapping
    public ResponseEntity<DataModelResponse<CategoriaModelResponse>> save(@RequestBody @Validated CategoriaModelRequest categoriaModelRequest) {

        CategoriaDomainRequest categoriaDomainRequest = categoriaModelMapper.toDomain(categoriaModelRequest);
        CategoriaDomainResponse categoriaDomainResponse = categoriaService.save(categoriaDomainRequest);
        CategoriaModelResponse categetoriaModelResponse = categoriaModelMapper.toModelResponse(categoriaDomainResponse);
        DataModelResponse dataModelResponse = dataModelMapper.setDataModel(categetoriaModelResponse);

        return new ResponseEntity<>(dataModelResponse, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DataModelResponse<CategoriaModelResponse>> updatePartial(@PathVariable Long id,
                                                                                   @RequestBody CategoriaPartialModelRequest categoriaPartialModelRequest) {

        CategoriaDomainRequest categoriaDomainRequest = categoriaModelMapper.toDomain(categoriaPartialModelRequest);
        CategoriaDomainResponse categoriaDomainResponse = categoriaService.update(id, categoriaDomainRequest);
        CategoriaModelResponse categetoriaModelResponse = categoriaModelMapper.toModelResponse(categoriaDomainResponse);
        DataModelResponse dataModelResponse = dataModelMapper.setDataModel(categetoriaModelResponse);

        return ResponseEntity.ok(dataModelResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

