package com.bank.backend.controllers;

import com.bank.backend.domain.usuario.Usuario;
import com.bank.backend.dtos.DetalhamentoUsuarioDTO;
import com.bank.backend.dtos.UsuarioDTO;
import com.bank.backend.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoUsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO dadosCadastroAluno, UriComponentsBuilder uriBuilder) {
        Usuario novoUsuario = this.usuarioService.cadastrarUsuario(dadosCadastroAluno);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(novoUsuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoUsuarioDTO(novoUsuario));
    }

    @GetMapping
    public ResponseEntity<Page<DetalhamentoUsuarioDTO>> listarTodosUsuarios(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        var listaUsuarios = this.usuarioService.listarTodosUsuarios(paginacao).map(DetalhamentoUsuarioDTO::new);
        return ResponseEntity.ok(listaUsuarios);
    }



}
