package com.bastos.aluraflix.config.security;

import com.bastos.aluraflix.dataprovider.repository.UsuarioRepository;
import com.bastos.aluraflix.exception.RegistradoNaoEncontradoException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new RegistradoNaoEncontradoException(
                        String.format("O usuário com o email '%s' não foi encontrado, nos registros", username)));
    }
}
