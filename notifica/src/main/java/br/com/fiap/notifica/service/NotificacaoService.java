package br.com.fiap.notifica.service;

import br.com.fiap.notifica.model.Notificacao;
import br.com.fiap.notifica.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacaoService {
    @Autowired
    private NotificacaoRepository notificacoesRepository;

    public Notificacao cadastrarNotificacao(Notificacao notificacao) {
        return notificacoesRepository.save(notificacao);
    }

    public List<Notificacao> listarNotificacoes() {
        return notificacoesRepository.findAll();
    }

    public Notificacao buscarNotificacaoPorId(Long id) {
        return notificacoesRepository.findById(id).orElse(null);
    }

    public void atualizarNotificacao(Notificacao notificacao) {
        notificacoesRepository.save(notificacao);
    }

    public void deletarNotificacao(Long id) {
        notificacoesRepository.deleteById(id);
    }
}

