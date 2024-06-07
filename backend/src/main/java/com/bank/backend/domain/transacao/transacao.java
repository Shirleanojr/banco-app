package com.bank.backend.domain.transacao;

import jakarta.persistence.*;
import org.apache.catalina.User;

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
    @Column(name = "remetente_id")
    private User remetente;
    @ManyToOne
    @Column(name = "destinatario_id")
    private User destinatario;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

}
