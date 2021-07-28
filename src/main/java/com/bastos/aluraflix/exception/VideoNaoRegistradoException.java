package com.bastos.aluraflix.exception;

public class VideoNaoRegistradoException extends RuntimeException {

    public VideoNaoRegistradoException(String mensagem) {
        super(mensagem);
    }
}
