package br.com.fiap.notifica.controller;

import br.com.fiap.notifica.dto.UsuarioCadastroDto;
import br.com.fiap.notifica.dto.UsuarioExibicaoDto;
import br.com.fiap.notifica.model.Usuario;
import br.com.fiap.notifica.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto salvar(@RequestBody @Valid UsuarioCadastroDto usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDto> litarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<UsuarioExibicaoDto> buscarPorId(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(usuarioService.buscarPorId(usuarioId));
    }

    @DeleteMapping("/usuarios/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long usuarioId) {
        usuarioService.excluir(usuarioId);
    }

    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDto atualizar(@PathVariable Long id, @RequestBody UsuarioCadastroDto usuarioCadastroDto) {
        // Chamar o serviço passando o ID e o DTO
        return usuarioService.atualizar(id, usuarioCadastroDto);


    }
}
