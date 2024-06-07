package com.bank.backend.exception;

import com.bank.backend.domain.usuario.TipoUsuario;
import com.bank.backend.service.UsuarioService;

public class UsuarioNaoAutorizadoException extends RuntimeException {
    public UsuarioNaoAutorizadoException(TipoUsuario tipo) { super(String.format("Usuário do tipo %s não está autorizado a realizar esta transação. ", tipo)); }

    public UsuarioNaoAutorizadoException() {super("Usuário não autorizado.");}
}
