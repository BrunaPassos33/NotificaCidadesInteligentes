package br.com.fiap.notifica.service;

import br.com.fiap.notifica.model.CalendarioColeta;
import br.com.fiap.notifica.repository.CalendarioColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarioColetaService {

    @Autowired
    private CalendarioColetaRepository calendarioColetaRepository;

    public CalendarioColeta cadastrarColeta(CalendarioColeta calendarioColeta) {
        return calendarioColetaRepository.save(calendarioColeta);
    }

    public List<CalendarioColeta> listarColetas() {
        return calendarioColetaRepository.findAll();
    }

    public CalendarioColeta buscarColetaPorId(Long id) {
        return calendarioColetaRepository.findById(id).orElse(null);
    }

    public void atualizarColeta(CalendarioColeta calendarioColeta) {
        calendarioColetaRepository.save(calendarioColeta);
    }

    public void deletarColeta(Long id) {
        calendarioColetaRepository.deleteById(id);
    }
}