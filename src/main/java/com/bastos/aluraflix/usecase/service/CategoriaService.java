package com.bastos.aluraflix.usecase.service;

import com.bastos.aluraflix.exception.ErroInternoServidor;
import com.bastos.aluraflix.exception.RegistradoNaoEncontradoException;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import com.bastos.aluraflix.usecase.gateway.CategoriaGateway;
import com.bastos.aluraflix.usecase.service.enums.CategoriaEnum;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoriaService {

    private final CategoriaGateway categoriaGateway;
    private final VideoService videoService;

    @Cacheable(value = "listaCategorias")
    public Page<CategoriaDomainResponse> getAllCategorias(Pageable pageable) {
        return categoriaGateway.getAll(pageable);
    }

    public CategoriaDomainResponse getByIdCategoria(Long id) {
        return categoriaGateway.getById(id);
    }

    @CacheEvict(value = "listaCategorias", allEntries = true)
    public CategoriaDomainResponse save(CategoriaDomainRequest categoriaDomainRequest) {
        try {
            CategoriaDomainResponse categoriaDomainResponse = categoriaGateway.save(categoriaDomainRequest);
            Optional<String> nomeCategoria = CategoriaEnum.buscarTituloCategoriaById(categoriaDomainResponse.getId());

            if (nomeCategoria.isPresent()) {
                categoriaDomainResponse = CategoriaDomainResponse.builder()
                        .titulo(nomeCategoria.get())
                        .build();
                categoriaDomainResponse = categoriaGateway.update(categoriaDomainResponse);
            }

            return categoriaDomainResponse;

        } catch (Exception exception) {
            throw new ErroInternoServidor("Houve um erro ao salvar os dados da categoria na base.");
        }
    }

    @CacheEvict(value = "listaCategorias", allEntries = true)
    public CategoriaDomainResponse update(Long id, CategoriaDomainRequest categoriaDomainRequest) {
        CategoriaDomainResponse categoriaDomainResponse = getByIdCategoria(id);

        if (Objects.nonNull(categoriaDomainRequest.getTitulo())) {
            categoriaDomainResponse = CategoriaDomainResponse.builder()
                    .titulo(categoriaDomainRequest.getTitulo())
                    .build();
        }

        if (Objects.nonNull(categoriaDomainRequest.getCor())) {
            categoriaDomainResponse = CategoriaDomainResponse.builder()
                    .cor(categoriaDomainRequest.getCor())
                    .build();
        }

        return categoriaGateway.update(categoriaDomainResponse);
    }

    @CacheEvict(value = "listaCategorias", allEntries = true)
    public void deleteById(Long id) {
        getByIdCategoria(id);
        categoriaGateway.deleteById(id);
    }

    public CategoriaDomainResponse getByIdCategoriaVideo(Long id) {
        CategoriaDomainResponse categoriaDomainResponse = getByIdCategoria(id);

        List<VideoDomainResponse> videosDomainResponses = videoService.getByIdCategoriaVideo(id);

        if (CollectionUtils.isEmpty(videosDomainResponses)) {
            throw new RegistradoNaoEncontradoException(String.format("Não existem videos cadastrados na categoria '%s'", id));
        }

        categoriaDomainResponse = CategoriaDomainResponse.builder()
                .id(categoriaDomainResponse.getId())
                .titulo(categoriaDomainResponse.getTitulo())
                .cor(categoriaDomainResponse.getCor())
                .videos(videosDomainResponses)
                .build();

        return categoriaDomainResponse;
    }
}
