package com.bastos.aluraflix.dataprovider.implementation;

import com.bastos.aluraflix.dataprovider.mapper.CategoriaDomainMapper;
import com.bastos.aluraflix.dataprovider.repository.CategoriaRepository;
import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.exception.NenhumConteudoException;
import com.bastos.aluraflix.exception.RegistradoNaoEncontradoException;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.usecase.gateway.CategoriaGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Component
public class CategoriaImplementation implements CategoriaGateway {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDomainResponse> getAll() {
        List<CategoriaEntity> categoriaEntities = categoriaRepository.findAll();

        if (categoriaEntities.isEmpty()) {
            throw new NenhumConteudoException();
        }

        return CategoriaDomainMapper.toDomain(categoriaEntities);
    }

    @Override
    public CategoriaDomainResponse getById(Long id) {
        CategoriaEntity categoriaEntity = categoriaRepository.findById(id)
                .orElseThrow(() -> new RegistradoNaoEncontradoException(
                        String.format("A categoria com o código '%s' não foi encontrado, nos registros", id)));

        return CategoriaDomainMapper.toDomain(categoriaEntity);
    }

    @Transactional
    @Override
    public CategoriaDomainResponse save(CategoriaDomainRequest categoriaDomainRequest) {
        CategoriaEntity categoriaEntityRequest = CategoriaDomainMapper.toEntity(categoriaDomainRequest);
        CategoriaEntity categoriaEntity = categoriaRepository.save(categoriaEntityRequest);

        return CategoriaDomainMapper.toDomain(categoriaEntity);
    }

    @Transactional
    @Override
    public CategoriaDomainResponse update(CategoriaDomainResponse categoriaDomainResponse) {
        CategoriaEntity categoriaEntityRequest = CategoriaDomainMapper.toEntity(categoriaDomainResponse);
        CategoriaEntity categoriaEntity = categoriaRepository.save(categoriaEntityRequest);

        return CategoriaDomainMapper.toDomain(categoriaEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
