package com.bank.backend.dtos;

import com.bank.backend.domain.usuario.TipoUsuario;
import com.bank.backend.domain.usuario.Usuario;

import java.math.BigDecimal;

public record DetalhamentoUsuarioDTO(
        String id,
        String nome,
        String sobrenome,
        String documento,
        String email,
        BigDecimal saldo,
        TipoUsuario tipo
) {

    public DetalhamentoUsuarioDTO(Usuario dados) {
        this(dados.getId(),
                dados.getNome(),
                dados.getSobrenome(),
                dados.getDocumento(),
                dados.getEmail(),
                dados.getSaldo(),
                dados.getTipo());
    }
}
