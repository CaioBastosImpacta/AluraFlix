package com.bastos.aluraflix.entrypoint.mapper;

import com.bastos.aluraflix.entrypoint.model.request.UsuarioModelRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AutenticacaoModelMapper {

    public static UsernamePasswordAuthenticationToken toDomain(UsuarioModelRequest usuarioModelRequest) {
        return new UsernamePasswordAuthenticationToken(usuarioModelRequest.getEmail(), usuarioModelRequest.getSenha());
    }
}
