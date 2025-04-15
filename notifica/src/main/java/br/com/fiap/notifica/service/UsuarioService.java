package br.com.fiap.notifica.service;

import br.com.fiap.notifica.dto.UsuarioCadastroDto;
import br.com.fiap.notifica.dto.UsuarioExibicaoDto;
import br.com.fiap.notifica.exception.UsuarioNaoEncontradoException;
import br.com.fiap.notifica.model.Usuario;
import br.com.fiap.notifica.model.UsuarioRole;
import br.com.fiap.notifica.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDto salvarUsuario(UsuarioCadastroDto usuarioDTO) {
        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioDTO.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuario.setSenha(senhaCriptografada);


        if (usuarioDTO.role() != null) {
            usuario.setRole(UsuarioRole.valueOf(usuarioDTO.role().toUpperCase()));
        }

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioExibicaoDto(usuarioSalvo.getUsuarioId(), usuarioSalvo.getNome(), usuarioSalvo.getEmail(), usuarioSalvo.getRole());
    }

    public UsuarioExibicaoDto buscarPorId(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            return new UsuarioExibicaoDto(usuario.getUsuarioId(), usuario.getNome(), usuario.getEmail(), usuario.getRole());
        } else {
            throw new RuntimeException("Usuário não existe no banco de dados!");
        }
    }

    public List<UsuarioExibicaoDto> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> new UsuarioExibicaoDto(usuario.getUsuarioId(), usuario.getNome(), usuario.getEmail(), usuario.getRole()))
                .toList();
    }

    public void excluir(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado!");
        }
    }

    public UsuarioExibicaoDto atualizar(Long id, UsuarioCadastroDto usuarioDTO) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            BeanUtils.copyProperties(usuarioDTO, usuario, "senha"); // Evita sobrescrever a senha
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuarioDTO.senha())); // Atualiza a senha
            // Atualiza o role
            if (usuarioDTO.role() != null) {
                usuario.setRole(UsuarioRole.valueOf(usuarioDTO.role().toUpperCase()));
            }
            Usuario usuarioAtualizado = usuarioRepository.save(usuario);
            return new UsuarioExibicaoDto(usuarioAtualizado.getUsuarioId(), usuarioAtualizado.getNome(), usuarioAtualizado.getEmail(), usuarioAtualizado.getRole());
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }
}
