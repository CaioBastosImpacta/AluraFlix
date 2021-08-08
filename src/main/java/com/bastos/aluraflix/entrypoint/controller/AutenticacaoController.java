package com.bastos.aluraflix.entrypoint.controller;

import com.bastos.aluraflix.entrypoint.mapper.AutenticacaoModelMapper;
import com.bastos.aluraflix.entrypoint.model.request.UsuarioModelRequest;
import com.bastos.aluraflix.config.security.TokenService;
import com.bastos.aluraflix.entrypoint.model.response.TokenModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
@Profile("prod")
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenModelResponse> autenticar(@RequestBody @Validated UsuarioModelRequest usuarioModelRequest) {
        UsernamePasswordAuthenticationToken dadosLogin = AutenticacaoModelMapper.toDomain(usuarioModelRequest);

        try {
            Authentication authenticate = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authenticate);
            return ResponseEntity.ok().body(new TokenModelResponse(token, "Bearer"));
        } catch (AuthenticationException e) {
            return new ResponseEntity("Usuário ou senha inválidos.", HttpStatus.BAD_REQUEST);
        }
    }
}
