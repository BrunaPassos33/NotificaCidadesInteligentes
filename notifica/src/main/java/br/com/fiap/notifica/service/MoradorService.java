package br.com.fiap.notifica.service;

import br.com.fiap.notifica.dto.UsuarioCadastroDto;
import br.com.fiap.notifica.model.Morador;
import br.com.fiap.notifica.repository.MoradorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    public Morador cadastrarMorador(Morador morador) {
        return moradorRepository.save(morador);
    }

    public List<Morador> listarMoradores() {
        return moradorRepository.findAll();
    }

    public Morador buscarMoradorPorId(Long id) {
        return moradorRepository.findById(id).orElse(null);
    }

    public void atualizarMorador(Morador morador) {
        moradorRepository.save(morador);
    }

    public void deletarMorador(Long id) {
        moradorRepository.deleteById(id);
    }
}