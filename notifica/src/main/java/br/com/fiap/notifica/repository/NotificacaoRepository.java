package br.com.fiap.notifica.repository;

import br.com.fiap.notifica.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
}
