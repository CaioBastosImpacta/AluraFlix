package com.bastos.aluraflix.entrypoint.controller.exception.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum UrlErroEnum {

    NOT_FOUND("/registro-nao-encontrado", 404),
    BAD_REQUEST("/campo-invalido-na-requisicao", 400),
    INTERNAL_SERVER("/erro-generico", 500);

    private String url;
    private Integer httpStatus;

    UrlErroEnum(String url, Integer httpStatus) {
        this.url = url;
        this.httpStatus = httpStatus;
    }

    public static String buscaUrl(Integer httpStatusValue) {
        if (Objects.nonNull(httpStatusValue)) {
            for (UrlErroEnum urlErroEnum : values()) {
                if (urlErroEnum.getHttpStatus().equals(httpStatusValue)) {
                    return urlErroEnum.getUrl();
                }
            }
        }

        return UrlErroEnum.INTERNAL_SERVER.getUrl();
    }
}
