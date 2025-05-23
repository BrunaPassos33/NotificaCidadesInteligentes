package br.com.fiap.notifica.dto;

import br.com.fiap.notifica.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto (

    Long usuarioId,

    @NotBlank(message = "O nome do usuário é obrigatório!")
    String nome,

    @NotBlank(message = "O e-mail do usuário é obrigatório!")
    @Email(message = "E-mail inválido")
    String email,

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, max = 20, message = "A senha deve conter entre 6 e 20 caracteres")
    String senha,
    String role



){
}
