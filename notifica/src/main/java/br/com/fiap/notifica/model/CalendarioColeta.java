package br.com.fiap.notifica.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name ="tbl_calendario_coleta")
@SequenceGenerator(name = "calendario_coleta_seq", sequenceName = "calendario_coleta_seq", allocationSize = 1)
public class CalendarioColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendario_coleta_seq")
    private Long Id;

    private LocalDate dataColeta;

    private String regiao;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDate getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(LocalDate dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
}
