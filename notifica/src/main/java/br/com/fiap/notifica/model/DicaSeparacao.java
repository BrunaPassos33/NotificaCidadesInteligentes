package br.com.fiap.notifica.model;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name ="tbl_dica_separacao")
@SequenceGenerator(name = "dica_separacao_seq", sequenceName = "dica_separacao_seq", allocationSize = 1)
public class DicaSeparacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dica_separacao_seq")
    private Long id;

    private String TipoResiduo;

    private String instrucoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
