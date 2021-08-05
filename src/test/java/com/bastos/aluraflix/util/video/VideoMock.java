package com.bastos.aluraflix.util.video;

import com.bastos.aluraflix.dataprovider.repository.entity.VideoEntity;
import com.bastos.aluraflix.entrypoint.model.request.VideoModelRequest;
import com.bastos.aluraflix.entrypoint.model.request.VideoPartialModelRequest;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import com.bastos.aluraflix.util.categoria.CategoriaMock;

import java.util.List;

public class VideoMock {

    public static List<VideoEntity> mockBuilderVideosEntity() {
        VideoEntity videoEntity =
                new VideoEntityBuilder()
                        .comId(Long.valueOf(1))
                        .comTitulo("Homem de Ferro")
                        .comDescricao("Filme numero 1")
                        .comUrl("/homem-de-ferro")
                        .comCategoria(CategoriaMock.mockBuilderCategoriaEntity())
                        .criar();

        VideoEntity videoEntity1 =
                new VideoEntityBuilder()
                        .comId(Long.valueOf(1))
                        .comTitulo("Homem de Ferro 2")
                        .comDescricao("Filme numero 2")
                        .comUrl("/homem-de-ferro-2")
                        .comCategoria(CategoriaMock.mockBuilderCategoriaEntity())
                        .criar();

        return List.of(videoEntity, videoEntity1);
    }

    public static List<VideoEntity> mockBuilderVideosEntityWhenCategoriaNull() {
        VideoEntity videoEntity =
                new VideoEntityBuilder()
                        .comId(Long.valueOf(1))
                        .comTitulo("Homem de Ferro")
                        .comDescricao("Filme numero 1")
                        .comUrl("/homem-de-ferro")
                        .comCategoria(null)
                        .criar();

        return List.of(videoEntity);
    }

    public static VideoEntity mockBuilderVideoEntity() {
        VideoEntity videoEntity =
                new VideoEntityBuilder()
                        .comId(Long.valueOf(1))
                        .comTitulo("Homem de Ferro")
                        .comDescricao("Filme numero 1")
                        .comUrl("/homem-de-ferro")
                        .comCategoria(CategoriaMock.mockBuilderCategoriaEntity())
                        .criar();

        return videoEntity;
    }

    public static VideoDomainRequest mockBuilderVideoDomainRequest() {
        VideoDomainRequest videoDomainRequest =
                new VideoDomainRequestBuilder()
                        .comTitulo("Homem de Ferro")
                        .comDescricao("Filme numero 1")
                        .comUrl("/homem-de-ferro")
                        .comCategoria(CategoriaMock.mockBuilderCategoriaDomainRequest())
                        .criar();

        return videoDomainRequest;
    }

    public static VideoDomainResponse mockBuilderVideoDomainResponse() {
        VideoDomainResponse videoDomainResponse =
                new VideoDomainResponseBuilder()
                        .comId(Long.valueOf(1))
                        .comTitulo("Homem de Ferro")
                        .comDescricao("Filme numero 1")
                        .comUrl("/homem-de-ferro")
                        .comCategoria(CategoriaMock.mockBuilderCategoriaDomainResponseWhenVideoEmptyList())
                        .criar();

        return videoDomainResponse;
    }

    public static List<VideoDomainResponse> mockBuilderVideosDomainResponse() {
        VideoDomainResponse videoDomainResponse =
                new VideoDomainResponseBuilder()
                        .comId(Long.valueOf(1))
                        .comTitulo("Homem de Ferro")
                        .comDescricao("Filme numero 1")
                        .comUrl("/homem-de-ferro")
                        .comCategoria(CategoriaMock.mockBuilderCategoriaDomainResponseWhenVideoEmptyList())
                        .criar();

        VideoDomainResponse videoDomainResponse2 =
                new VideoDomainResponseBuilder()
                        .comId(Long.valueOf(2))
                        .comTitulo("Homem de Ferro 2")
                        .comDescricao("Filme numero 2")
                        .comUrl("/homem-de-ferro-2")
                        .comCategoria(CategoriaMock.mockBuilderCategoriaDomainResponseWhenVideoEmptyList())
                        .criar();

        return List.of(videoDomainResponse, videoDomainResponse2);
    }

    public static List<VideoDomainResponse> mockBuilderVideosDomainResponseCategoriaIsNull() {
        VideoDomainResponse videoDomainResponse =
                new VideoDomainResponseBuilder()
                        .comId(Long.valueOf(1))
                        .comTitulo("Homem de Ferro")
                        .comDescricao("Filme numero 1")
                        .comUrl("/homem-de-ferro")
                        .comCategoria(null)
                        .criar();

        VideoDomainResponse videoDomainResponse2 =
                new VideoDomainResponseBuilder()
                        .comId(Long.valueOf(2))
                        .comTitulo("Homem de Ferro 2")
                        .comDescricao("Filme numero 2")
                        .comUrl("/homem-de-ferro-2")
                        .comCategoria(null)
                        .criar();

        return List.of(videoDomainResponse, videoDomainResponse2);
    }

    public static VideoModelRequest mockBuilderVideoModelRequest() {
        VideoModelRequest videoModelRequest =
                new VideoModelRequestBuilder()
                        .comTitulo("Homem de Ferro")
                        .comDescricao("Filme 1")
                        .comUrl("/homem-de-ferro")
                        .comCategoria(CategoriaMock.mockBuilderCategoriasModelRequest())
                        .criar();

        return videoModelRequest;
    }

    public static VideoPartialModelRequest mockBuilderVideoPartialModelRequest() {
        VideoPartialModelRequest videoPartialModelRequest =
                new VideoPartialModelRequestBuilder()
                        .comTitulo("Homem de Ferro")
                        .comDescricao("Filme 1")
                        .comUrl("/homem-de-ferro")
                        .criar();

        return videoPartialModelRequest;
    }
}
