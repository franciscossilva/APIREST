package com.example.tarefas.APIREST.repositoryTest;

import com.example.tarefas.APIREST.model.Usuario;
import com.example.tarefas.APIREST.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void testFindByUsernameAndSenha() {
        Usuario usuario = new Usuario(1L, "usuarioTeste", "senhaTeste");
        usuarioRepository.save(usuario);

        Usuario usuarioEncontrado = usuarioRepository.findByUsernameAndSenha("usuarioTeste", "senhaTeste");
        assertNotNull(usuarioEncontrado);
        assertEquals("usuarioTeste", usuarioEncontrado.getUsername());
        assertEquals("senhaTeste", usuarioEncontrado.getSenha());
    }
}
