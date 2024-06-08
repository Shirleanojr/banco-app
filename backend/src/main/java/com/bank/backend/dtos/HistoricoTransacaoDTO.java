package com.bank.backend.dtos;

import com.bank.backend.domain.historico_transacao.TipoTransacao;
import com.bank.backend.domain.usuario.Usuario;

import java.math.BigDecimal;

public record HistoricoTransacaoDTO(
        BigDecimal valor,
        Usuario remetente,
        Usuario destinatario,

        TipoTransacao tipo
) {
}
