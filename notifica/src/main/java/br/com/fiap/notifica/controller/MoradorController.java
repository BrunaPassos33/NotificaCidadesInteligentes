package br.com.fiap.notifica.controller;

import br.com.fiap.notifica.model.Morador;
import br.com.fiap.notifica.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    @Autowired
    private MoradorRepository moradorRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Morador cadastrarMorador(@RequestBody Morador novoMorador) {
        return moradorRepository.save(novoMorador);
    }


    @PutMapping("/{id}/notificacao")
    public ResponseEntity<Morador> atualizarNotificacao(@PathVariable Long id, @RequestBody Morador dadosAtualizados) {
        Optional<Morador> optionalMorador = moradorRepository.findById(id);
        if (optionalMorador.isPresent()) {
            Morador morador = optionalMorador.get();
            morador.setPreferenciaNotificacao(dadosAtualizados.getPreferenciaNotificacao());
            moradorRepository.save(morador);
            return ResponseEntity.ok(morador);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping
    public List<Morador> listarMoradores() {
        return moradorRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Morador> buscarMoradorPorId(@PathVariable Long id) {
        Optional<Morador> optionalMorador = moradorRepository.findById(id);
        return optionalMorador.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerMorador(@PathVariable Long id) {
        if (moradorRepository.existsById(id)) {
            moradorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
