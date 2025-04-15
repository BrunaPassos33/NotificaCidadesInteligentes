package br.com.fiap.notifica.service;

import br.com.fiap.notifica.model.DicaSeparacao;
import br.com.fiap.notifica.repository.DicaSeparacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DicaSeparacaoService {

    @Autowired
    private DicaSeparacaoRepository dicaSeparacaoRepository;

    public List<DicaSeparacao> listarDicas() {
        return dicaSeparacaoRepository.findAll();
    }

    public DicaSeparacao cadastrarDica(DicaSeparacao dicaSeparacao) {
        return dicaSeparacaoRepository.save(dicaSeparacao);
    }

    public Optional<DicaSeparacao> atualizarDica(Long id, DicaSeparacao dicaSeparacao) {
        if (dicaSeparacaoRepository.existsById(id)) {
            dicaSeparacao.setId(id);
            return Optional.of(dicaSeparacaoRepository.save(dicaSeparacao));
        }
        return Optional.empty();
    }

    public boolean deletarDica(Long id) {
        if (dicaSeparacaoRepository.existsById(id)) {
            dicaSeparacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}