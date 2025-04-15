package br.com.fiap.notifica.controller;

import br.com.fiap.notifica.model.CalendarioColeta;
import br.com.fiap.notifica.service.CalendarioColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coleta")
public class CalendarioColetaController {

    @Autowired
    private CalendarioColetaService calendarioColetaService;

    @PostMapping
    public ResponseEntity<CalendarioColeta> cadastrarColeta(@RequestBody CalendarioColeta calendarioColeta) {
        CalendarioColeta novaColeta = calendarioColetaService.cadastrarColeta(calendarioColeta);
        return ResponseEntity.ok(novaColeta);
    }

    @GetMapping
    public ResponseEntity<List<CalendarioColeta>> listarColetas() {
        return ResponseEntity.ok(calendarioColetaService.listarColetas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalendarioColeta> buscarColetaPorId(@PathVariable Long id) {
        CalendarioColeta coleta = calendarioColetaService.buscarColetaPorId(id);
        return coleta != null ? ResponseEntity.ok(coleta) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CalendarioColeta> atualizarColeta(@PathVariable Long id, @RequestBody CalendarioColeta calendarioColeta) {
        calendarioColeta.setId(id);
        calendarioColetaService.atualizarColeta(calendarioColeta);
        return ResponseEntity.ok(calendarioColeta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarColeta(@PathVariable Long id) {
        calendarioColetaService.deletarColeta(id);
        return ResponseEntity.noContent().build();
    }
}
