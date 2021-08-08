package com.bastos.aluraflix.entrypoint.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TokenModelResponse {

    private String token;
    private String tipo;
}
