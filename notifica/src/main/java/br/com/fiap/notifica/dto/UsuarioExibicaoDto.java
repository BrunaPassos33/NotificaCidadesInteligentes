package br.com.fiap.notifica.dto;

import br.com.fiap.notifica.model.Usuario;
import br.com.fiap.notifica.model.UsuarioRole;

public record UsuarioExibicaoDto(
        Long usuarioId,
        String nome,
        String email,
        UsuarioRole role
) {

    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole() // Corrigido: agora está passando a role corretamente
        );
    }
}

