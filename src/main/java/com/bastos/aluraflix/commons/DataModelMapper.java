package com.bastos.aluraflix.commons;

import org.springframework.stereotype.Component;

/**
 * Classe responsável por realizar o set (setar) de dados de um objeto (tratado como genérico), de um nó de
 * dataModel Response. Para assim obter a saída da API em JSON dentro de um <b>data</b>
 *
 * @param <T>
 *     - Objeto genérico
 *
 * @since 09/05/2021
 */
@Component
public class DataModelMapper<T> {

    public DataModelResponse setDataModel(T generic) {
        return DataModelResponse.builder()
                .data(generic)
                .build();
    }
}
