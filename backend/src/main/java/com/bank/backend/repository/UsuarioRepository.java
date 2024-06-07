package com.bank.backend.repository;

import com.bank.backend.domain.usuario.Usuario;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findUsuarioByDocumento(String documento);
    Optional<Usuario> findUsuarioById(String id);

}
