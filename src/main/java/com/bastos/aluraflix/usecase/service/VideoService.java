package com.bastos.aluraflix.usecase.service;

import com.bastos.aluraflix.exception.ErroInternoServidor;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import com.bastos.aluraflix.usecase.gateway.CategoriaGateway;
import com.bastos.aluraflix.usecase.gateway.VideoGateway;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class VideoService {

    VideoGateway videoGateway;
    CategoriaGateway categoriaGateway;

    @Cacheable(value = "listaVideos")
    public Page<VideoDomainResponse> getAllVideos(String search, Pageable pageable) {

        if (StringUtils.isNotBlank(search)) {
            return videoGateway.findByTitulo(search, pageable);
        }

        return videoGateway.getAll(pageable);
    }

    public VideoDomainResponse getByIdVideo(Long id) {
        return videoGateway.getById(id);
    }

    public VideoDomainResponse save(VideoDomainRequest videoDomainRequest) {
        validaIdCategoria(videoDomainRequest);

        try {
            return videoGateway.save(videoDomainRequest);
        } catch (Exception exception) {
            throw new ErroInternoServidor("Houve um erro ao salvar os dados do vídeo na base.");
        }
    }

    public VideoDomainResponse update(Long id, VideoDomainRequest videoDomainRequest) {
        VideoDomainResponse videoDomainResponse = getByIdVideo(id);

        if (Objects.nonNull(videoDomainRequest.getTitulo())) {
            videoDomainResponse = VideoDomainResponse.builder()
                    .titulo(videoDomainRequest.getTitulo())
                    .build();
        }

        if (Objects.nonNull(videoDomainRequest.getDescricao())) {
            videoDomainResponse = VideoDomainResponse.builder()
                    .descricao(videoDomainRequest.getDescricao())
                    .build();
        }

        if (Objects.nonNull(videoDomainRequest.getUrl())) {
            videoDomainResponse = VideoDomainResponse.builder()
                    .url(videoDomainRequest.getUrl())
                    .build();
        }
        
        return videoGateway.update(videoDomainResponse);
    }

    public void deleteById(Long id) {
        getByIdVideo(id);
        videoGateway.deleteById(id);
    }

    private void validaIdCategoria(VideoDomainRequest videoDomainRequest) {
        Long idCategoria = videoDomainRequest.getCategoria().getId();

        if (Objects.nonNull(idCategoria)) {
            categoriaGateway.getById(idCategoria);
        }
    }

    public List<VideoDomainResponse> getByIdCategoriaVideo(Long id) {
        return videoGateway.findByCategoriaId(id);
    }
}
