package com.bank.backend.domain.transacao;

import com.bank.backend.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "transacao")
public class transacao {

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
    private LocalDateTime dataHora;

}
