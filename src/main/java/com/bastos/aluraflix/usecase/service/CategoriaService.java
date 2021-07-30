package com.bastos.aluraflix.usecase.service;

import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.usecase.gateway.CategoriaGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoriaService {

    CategoriaGateway categoriaRepository;

    public List<CategoriaDomainResponse> getAllCategorias() {
        return categoriaRepository.getAll();
    }
}
