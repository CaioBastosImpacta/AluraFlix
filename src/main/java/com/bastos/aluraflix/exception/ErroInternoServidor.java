package com.bastos.aluraflix.exception;

public class ErroInternoServidor extends RuntimeException {

    public ErroInternoServidor(String mensagem) {
        super(mensagem);
    }
}
