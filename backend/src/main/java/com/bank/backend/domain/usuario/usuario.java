package com.bank.backend.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String sobrenome;

    @Column(unique = true)
    private String documento;

    @Column(unique = true)
    private String email;
    private String senha;
    private BigDecimal saldo;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

}
