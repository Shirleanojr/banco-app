package com.bank.backend.service;

import com.bank.backend.domain.historico_transacao.HistoricoTransacao;
import com.bank.backend.domain.historico_transacao.TipoTransacao;
import com.bank.backend.domain.usuario.Usuario;
import com.bank.backend.dtos.HistoricoTransacaoDTO;
import com.bank.backend.repository.HistoricoTransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HistoricoTransacaoService {

    //        Talves usar kafka para os historicos

    @Autowired
    private HistoricoTransacaoRepository repository;


    public void adicionaHistoricoTransacao(HistoricoTransacaoDTO dados) {
        HistoricoTransacao novaTransacao = new HistoricoTransacao(dados);
        this.repository.save(novaTransacao);
    }

    public void adicionaHistoricoTransacao(Usuario usuario, BigDecimal valor, TipoTransacao tipo) {
        HistoricoTransacao novaTransacao = new HistoricoTransacao(usuario, valor, tipo);
        this.repository.save(novaTransacao);
    }

    public List<HistoricoTransacao> listarHistoricoTransacao(){
        return this.repository.findAll();
    }
}
