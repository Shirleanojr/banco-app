package com.bank.backend.domain.usuario;

import com.bank.backend.dtos.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

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

    public Usuario(UsuarioDTO dados) {
        this.setNome(dados.nome());
        this.setSobrenome(dados.sobrenome());
        this.setDocumento(dados.documento());
        this.setEmail(dados.email());
        this.setSenha(dados.senha());
        this.setSaldo(dados.saldo());
        this.setTipo(dados.tipo());
    }
}
