package br.com.fiap.notifica.repository;

import br.com.fiap.notifica.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Long> {
}
