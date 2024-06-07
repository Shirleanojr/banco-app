package com.bank.backend.service;

import com.bank.backend.domain.usuario.TipoUsuario;
import com.bank.backend.domain.usuario.Usuario;
import com.bank.backend.dtos.UsuarioDTO;
import com.bank.backend.exception.SaldoInsuficienteException;
import com.bank.backend.exception.UsuarioNaoAutorizadoException;
import com.bank.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validarTransacao(Usuario remetente, BigDecimal valor) {
        if (remetente.getTipo() == TipoUsuario.LOJISTA) {
            throw new UsuarioNaoAutorizadoException(remetente.getTipo());
        }

        if (remetente.getSaldo().compareTo(valor) < 0 ){
            throw new SaldoInsuficienteException();
        }
    }

    public Usuario cadastrarUsuario(UsuarioDTO dados) {
       Usuario novoUsuario = new Usuario(dados);
       this.salvarUsuario(novoUsuario);
       return novoUsuario;
    }

    public void salvarUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    public Page<Usuario> listarTodosUsuarios(Pageable paginacao) {
        return this.usuarioRepository.findAll(paginacao);
    }
}
