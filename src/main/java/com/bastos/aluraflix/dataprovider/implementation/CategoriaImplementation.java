package com.bastos.aluraflix.dataprovider.implementation;

import com.bastos.aluraflix.dataprovider.mapper.CategoriaDomainMapper;
import com.bastos.aluraflix.dataprovider.repository.CategoriaRepository;
import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.exception.NenhumConteudoException;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.usecase.gateway.CategoriaGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CategoriaImplementation implements CategoriaGateway {

    CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDomainResponse> getAll() {
        List<CategoriaEntity> categoriaEntities = categoriaRepository.findAll();

        if (categoriaEntities.isEmpty()) {
            throw new NenhumConteudoException();
        }

        return CategoriaDomainMapper.toDomain(categoriaEntities);
    }
}
