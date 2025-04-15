package br.com.fiap.notifica.controller;


import br.com.fiap.notifica.config.security.TokenService;
import br.com.fiap.notifica.dto.LoginDto;
import br.com.fiap.notifica.dto.TokenDto;
import br.com.fiap.notifica.dto.UsuarioCadastroDto;
import br.com.fiap.notifica.dto.UsuarioExibicaoDto;
import br.com.fiap.notifica.model.Usuario;
import br.com.fiap.notifica.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService service;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto loginDto) {
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.senha());


        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDto(token));

    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioExibicaoDto> registrar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto) {
        UsuarioExibicaoDto usuarioSalvo = service.salvarUsuario(usuarioCadastroDto);

        // Defina a URI do novo recurso criado
        URI location = URI.create("/auth/register/" + usuarioSalvo.usuarioId());

        // Retorna o ResponseEntity com status CREATED e a URI do recurso criado
        return ResponseEntity.created(location).body(usuarioSalvo);
    }
}
