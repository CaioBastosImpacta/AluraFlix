package com.bastos.aluraflix.util.categoria;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.entrypoint.model.request.CategoriaModelRequest;
import com.bastos.aluraflix.entrypoint.model.request.CategoriaPartialModelRequest;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import com.bastos.aluraflix.util.video.VideoMock;

import java.util.Collections;
import java.util.List;

public class CategoriaMock {

    public static List<CategoriaEntity> mockBuilderCategoriasEntity() {
        CategoriaEntity categoriaEntity =
                new CategoriaEntityBuilder()
                        .comId(1L)
                        .comTitulo("LIVRE")
                        .comCor("verde")
                        .criar();

        CategoriaEntity categoriaEntity1 =
                new CategoriaEntityBuilder()
                        .comId(2L)
                        .comTitulo("+12")
                        .comCor("laranja")
                        .criar();

        return List.of(categoriaEntity, categoriaEntity1);
    }

    public static CategoriaEntity mockBuilderCategoriaEntity() {
        CategoriaEntity categoriaEntity =
                new CategoriaEntityBuilder()
                        .comId(1L)
                        .comTitulo("LIVRE")
                        .comCor("verde")
                        .criar();

        return categoriaEntity;
    }

    public static CategoriaDomainRequest mockBuilderCategoriaDomainRequest() {
        CategoriaDomainRequest categoriaDomainRequest =
                new CategoriaDomainRequestBuilder()
                        .comId(Long.valueOf(1))
                        .comTitulo("LIVRE")
                        .comCor("verde")
                        .criar();

        return categoriaDomainRequest;
    }

    public static CategoriaDomainRequest mockBuilderCategoriaDomainRequestWhenTituloNull() {
        CategoriaDomainRequest categoriaDomainRequest =
                new CategoriaDomainRequestBuilder()
                        .comTitulo(null)
                        .comCor("verde")
                        .criar();

        return categoriaDomainRequest;
    }

    public static CategoriaDomainResponse mockBuilderCategoriaDomainResponse() {
        CategoriaDomainResponse categoriaDomainRequest =
                new CategoriaDomainResponseBuilder()
                        .comId(2L)
                        .comTitulo("+12")
                        .comCor("laranja")
                        .comVideos(VideoMock.mockBuilderVideosDomainResponse())
                        .criar();

        return categoriaDomainRequest;
    }

    public static CategoriaDomainResponse mockBuilderCategoriaDomainResponseWhenVideoEmptyList() {
        CategoriaDomainResponse categoriaDomainRequest =
                new CategoriaDomainResponseBuilder()
                        .comId(2L)
                        .comTitulo("+12")
                        .comCor("laranja")
                        .comVideos(Collections.emptyList())
                        .criar();

        return categoriaDomainRequest;
    }

    public static List<CategoriaDomainResponse> mockBuilderCategoriasDomainResponse() {
        CategoriaDomainResponse categoriaDomainResponse =
                new CategoriaDomainResponseBuilder()
                        .comId(1L)
                        .comTitulo("LIVRE")
                        .comCor("verde")
                        .criar();

        CategoriaDomainResponse categoriaDomainResponse1 =
                new CategoriaDomainResponseBuilder()
                        .comId(2L)
                        .comTitulo("+12")
                        .comCor("laranja")
                        .criar();

        return List.of(categoriaDomainResponse, categoriaDomainResponse1);
    }


    public static CategoriaModelRequest mockBuilderCategoriasModelRequest() {
        CategoriaModelRequest categoriaModelRequest =
                new CategoriaModelRequestBuilder()
                        .comTitulo("LIVRE")
                        .comCor("verde")
                        .criar();

        return categoriaModelRequest;
    }

    public static CategoriaPartialModelRequest mockBuilderCategoriasModelRequestPartial() {
        CategoriaPartialModelRequest categoriaPartialModelRequest =
                new CategoriaModelRequestPartialBuilder()
                        .comTitulo("LIVRE")
                        .comCor("verde")
                        .criar();

        return categoriaPartialModelRequest;
    }
}
