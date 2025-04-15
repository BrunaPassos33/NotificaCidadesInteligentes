package br.com.fiap.notifica.repository;

import br.com.fiap.notifica.model.CalendarioColeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarioColetaRepository extends JpaRepository<CalendarioColeta, Long> {
    List<CalendarioColeta> findByRegiao(String regiao);
}
