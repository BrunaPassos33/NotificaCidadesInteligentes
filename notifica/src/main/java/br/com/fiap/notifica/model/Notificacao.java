package br.com.fiap.notifica.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Data
@Table(name ="tbl_notificacao")
@SequenceGenerator(name = "notificacao_seq", sequenceName = "notificacao_seq", allocationSize = 1)
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notificacao_seq")
    private Long id;

    private Long moradorId;

    private String mensagem;

    private LocalDateTime dataEnvio;
}
