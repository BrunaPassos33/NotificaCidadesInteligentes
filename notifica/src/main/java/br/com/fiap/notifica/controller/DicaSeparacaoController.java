package br.com.fiap.notifica.controller;

import br.com.fiap.notifica.model.DicaSeparacao;
import br.com.fiap.notifica.service.DicaSeparacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residuos")
public class DicaSeparacaoController {

    @Autowired
    private DicaSeparacaoService dicaSeparacaoService;

    @GetMapping("/instrucoes")
    public List<DicaSeparacao> getInstrucoesSeparacao() {
        return dicaSeparacaoService.listarDicas();
    }

    @PostMapping("/instrucoes")
    public ResponseEntity<DicaSeparacao> cadastrarDicaSeparacao(@RequestBody DicaSeparacao dicaSeparacao) {
        DicaSeparacao novaDica = dicaSeparacaoService.cadastrarDica(dicaSeparacao);
        return ResponseEntity.ok(novaDica);
    }

    @PutMapping("/instrucoes/{id}")
    public ResponseEntity<DicaSeparacao> atualizarDicaSeparacao(@PathVariable Long id, @RequestBody DicaSeparacao dicaSeparacao) {
        return dicaSeparacaoService.atualizarDica(id, dicaSeparacao)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/instrucoes/{id}")
    public ResponseEntity<Void> deletarDicaSeparacao(@PathVariable Long id) {
        if (dicaSeparacaoService.deletarDica(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

