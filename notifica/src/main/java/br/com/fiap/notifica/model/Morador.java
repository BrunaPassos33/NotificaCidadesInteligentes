package br.com.fiap.notifica.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name ="tbl_morador")
@SequenceGenerator(name = "morador_seq", sequenceName = "morador_seq", allocationSize = 1)
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "morador_seq")
    private Long id;

    private String Nome;

    private String endereco;

    private String email;

    private String telefone;

    private String preferenciaNotificacao;

    public String getPreferenciaNotificacao() {
        return preferenciaNotificacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPreferenciaNotificacao(String preferenciaNotificacao) {
        this.preferenciaNotificacao = preferenciaNotificacao;
    }

}