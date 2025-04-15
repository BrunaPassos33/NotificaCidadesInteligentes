package br.com.fiap.notifica.controller;

import br.com.fiap.notifica.model.Notificacao;
import br.com.fiap.notifica.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {
    @Autowired
    private NotificacaoRepository notificacaoRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Notificacao criarNotificacao(@RequestBody Notificacao novaNotificacao) {
        return notificacaoRepository.save(novaNotificacao);
    }

    // Método para listar todas as notificações
    @GetMapping
    public List<Notificacao> listarNotificacoes() {
        return notificacaoRepository.findAll();
    }

    // Método para buscar uma notificação por ID
    @GetMapping("/{id}")
    public ResponseEntity<Notificacao> buscarNotificacaoPorId(@PathVariable Long id) {
        Optional<Notificacao> optionalNotificacao = notificacaoRepository.findById(id);
        return optionalNotificacao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para remover uma notificação pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerNotificacao(@PathVariable Long id) {
        if (notificacaoRepository.existsById(id)) {
            notificacaoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

