package com.bastos.aluraflix.dataprovider.implementation;

import com.bastos.aluraflix.dataprovider.mapper.CategoriaDomainMapper;
import com.bastos.aluraflix.dataprovider.repository.CategoriaRepository;
import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.exception.NenhumConteudoException;
import com.bastos.aluraflix.exception.RegistradoNaoEncontradoException;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.usecase.gateway.CategoriaGateway;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@AllArgsConstructor
@Component
public class CategoriaImplementation implements CategoriaGateway {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaDomainMapper categoriaDomainMapper;

    @Override
    public Page<CategoriaDomainResponse> getAll(Pageable pageRequest) {
        Page<CategoriaEntity> categoriaEntities = categoriaRepository.findAll(pageRequest);

        if (categoriaEntities.isEmpty()) {
            throw new NenhumConteudoException();
        }

        return categoriaDomainMapper.toDomain(categoriaEntities);
    }

    @Override
    public CategoriaDomainResponse getById(Long id) {
        CategoriaEntity categoriaEntity = categoriaRepository.findById(id)
                .orElseThrow(() -> new RegistradoNaoEncontradoException(
                        String.format("A categoria com o código '%s' não foi encontrado, nos registros", id)));

        return categoriaDomainMapper.toDomain(categoriaEntity);
    }

    @Transactional
    @Override
    public CategoriaDomainResponse save(CategoriaDomainRequest categoriaDomainRequest) {
        CategoriaEntity categoriaEntityRequest = categoriaDomainMapper.toEntity(categoriaDomainRequest);
        CategoriaEntity categoriaEntity = categoriaRepository.save(categoriaEntityRequest);

        return categoriaDomainMapper.toDomain(categoriaEntity);
    }

    @Transactional
    @Override
    public CategoriaDomainResponse update(CategoriaDomainResponse categoriaDomainResponse) {
        CategoriaEntity categoriaEntityRequest = categoriaDomainMapper.toEntity(categoriaDomainResponse);
        CategoriaEntity categoriaEntity = categoriaRepository.save(categoriaEntityRequest);

        return categoriaDomainMapper.toDomain(categoriaEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
