package com.bank.backend.dtos;

import com.bank.backend.domain.usuario.TipoUsuario;

import java.math.BigDecimal;

public record UsuarioDTO(
        String nome,
        String sobrenome,
        String documento,
        String email,
        String senha,
        BigDecimal saldo,
        TipoUsuario tipo
) {
}
