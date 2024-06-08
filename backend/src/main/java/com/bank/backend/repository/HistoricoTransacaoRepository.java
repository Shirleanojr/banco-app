package com.bank.backend.repository;

import com.bank.backend.domain.historico_transacao.HistoricoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoTransacaoRepository extends JpaRepository<HistoricoTransacao, String> {

}
