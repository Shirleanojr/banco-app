package com.bank.backend.domain.historico_transacao;

import com.bank.backend.domain.usuario.Usuario;
import com.bank.backend.dtos.HistoricoTransacaoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "historico_transacao")
@Table(name = "historico_transacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class HistoricoTransacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    private Usuario remetente;
    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    private Usuario destinatario;
    private TipoTransacao tipo;
    private LocalDateTime dataHora;

    public HistoricoTransacao(HistoricoTransacaoDTO dados) {
        this.setValor(dados.valor());
        this.setRemetente(dados.remetente());
        this.setDestinatario(dados.destinatario());
        this.setTipo(dados.tipo());
        this.setDataHora(LocalDateTime.now());
    }

    public HistoricoTransacao(Usuario remetente, BigDecimal valor, TipoTransacao tipo){
        this.setValor(valor);
        this.setRemetente(remetente);
        this.setTipo(tipo);
        this.setDataHora(LocalDateTime.now());
    }
}

