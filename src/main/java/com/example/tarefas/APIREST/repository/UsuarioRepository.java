package com.example.tarefas.APIREST.repository;

import com.example.tarefas.APIREST.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsernameAndSenha(String username, String senha);
}
