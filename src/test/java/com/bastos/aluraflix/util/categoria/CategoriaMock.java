package com.bastos.aluraflix.util.categoria;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;

import java.util.List;

public class CategoriaMock {

    public static List<CategoriaEntity> mockBuilderCategoriasEntity() {
        CategoriaEntity categoriaEntity =
                new CategoriaEntityBuilder()
                        .comId(1L)
                        .comNome("LIVRE")
                        .comTitulo("Categoria Livre")
                        .comCor("verde")
                        .criar();

        CategoriaEntity categoriaEntity1 =
                new CategoriaEntityBuilder()
                        .comId(2L)
                        .comNome("+12")
                        .comTitulo("Proibido para menores de 12 anos")
                        .comCor("laranja")
                        .criar();

        return List.of(categoriaEntity, categoriaEntity1);
    }

    public static CategoriaEntity mockBuilderCategoriaEntity() {
        CategoriaEntity categoriaEntity =
                new CategoriaEntityBuilder()
                        .comId(1L)
                        .comNome("LIVRE")
                        .comTitulo("Categoria Livre")
                        .comCor("verde")
                        .criar();

        return categoriaEntity;
    }

    public static CategoriaDomainRequest mockBuilderCategoriaDomainRequest() {
        CategoriaDomainRequest categoriaDomainRequest =
                new CategoriaDomainRequestBuilder()
                        .comId(Long.valueOf(1))
                        .comNome("LIVRE")
                        .comTitulo("Categoria Livre")
                        .comCor("verde")
                        .criar();

        return categoriaDomainRequest;
    }

    public static CategoriaDomainRequest mockBuilderCategoriaDomainRequestWhenTituloNull() {
        CategoriaDomainRequest categoriaDomainRequest =
                new CategoriaDomainRequestBuilder()
                        .comTitulo(null)
                        .comTitulo("Categoria Livre")
                        .comCor("verde")
                        .criar();

        return categoriaDomainRequest;
    }

    public static CategoriaDomainResponse mockBuilderCategoriaDomainResponse() {
        CategoriaDomainResponse categoriaDomainRequest =
                new CategoriaDomainResponseBuilder()
                        .comId(2L)
                        .comNome("+12")
                        .comTitulo("Proibido para menores de 12 anos")
                        .comCor("laranja")
                        .criar();

        return categoriaDomainRequest;
    }
}
