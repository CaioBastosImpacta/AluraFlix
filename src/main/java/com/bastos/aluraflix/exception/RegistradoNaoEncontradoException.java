package com.bastos.aluraflix.exception;

public class RegistradoNaoEncontradoException extends RuntimeException {

    public RegistradoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
