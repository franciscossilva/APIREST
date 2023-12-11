package com.example.tarefas.APIREST.resourceTest;

import com.example.tarefas.APIREST.model.Tarefas;
import com.example.tarefas.APIREST.model.Usuario;
import com.example.tarefas.APIREST.repository.TarefasRepository;
import com.example.tarefas.APIREST.repository.UsuarioRepository;
import com.example.tarefas.APIREST.resource.TarefasResource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TarefasResourceTest {

    @InjectMocks
    private TarefasResource tarefasResource;

    @Mock
    private TarefasRepository tarefasRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListarTarefas() {
        when(tarefasRepository.findAll()).thenReturn(Arrays.asList(
                new Tarefas(1L, "Tarefa 1", "Descrição 1", new Date(), true, null),
                new Tarefas(2L, "Tarefa 2", "Descrição 2", new Date(), false, null)
        ));

        List<Tarefas> tarefas = tarefasResource.listarTarefas();
        assertEquals(2, tarefas.size());
    }

    @Test
    public void testObterTarefaPorId() {
        when(tarefasRepository.findById(1L)).thenReturn(Optional.of(new Tarefas(1L, "Tarefa 1", "Descrição 1", new Date(), true, null)));

        Tarefas tarefa = tarefasResource.obterTarefaPorId(1L);
        assertEquals("Tarefa 1", tarefa.getTitulo());
    }

    @Test
    public void testCriarTarefa() {
        Tarefas tarefaParaSalvar = new Tarefas(null, "Nova Tarefa", "Descrição Nova Tarefa", new Date(), false, null);
        when(tarefasRepository.save(tarefaParaSalvar)).thenReturn(new Tarefas(1L, "Nova Tarefa", "Descrição Nova Tarefa", new Date(), false, null));

        Tarefas tarefaCriada = tarefasResource.criarTarefa(tarefaParaSalvar);
        assertEquals(1L, tarefaCriada.getId().longValue());
    }

    @Test
    public void testDeletarTarefa() {
        when(tarefasRepository.findById(1L)).thenReturn(Optional.of(new Tarefas(1L, "Tarefa 1", "Descrição 1", new Date(), true, null)));

        tarefasResource.deletarTarefa(1L);

        verify(tarefasRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testAtualizarTarefa() {
        Tarefas tarefaExistente = new Tarefas(1L, "Tarefa 1", "Descrição 1", new Date(), true, null);
        when(tarefasRepository.findById(1L)).thenReturn(Optional.of(tarefaExistente));

        Tarefas tarefaAtualizada = new Tarefas(1L, "Tarefa Atualizada", "Nova Descrição", new Date(), false, null);

        Tarefas tarefaAtualizadaResult = tarefasResource.atualizarTarefa(1L, tarefaAtualizada);

        verify(tarefasRepository, times(1)).save(tarefaAtualizada);

        assertEquals("Tarefa Atualizada", tarefaAtualizadaResult.getTitulo());
        assertEquals("Nova Descrição", tarefaAtualizadaResult.getDescricao());
    }

    @Test
    public void testLogin() {
        Usuario usuarioExistente = new Usuario("usuarioTeste", "senhaTeste");
        when(usuarioRepository.findByUsernameAndSenha("usuarioTeste", "senhaTeste")).thenReturn(usuarioExistente);

        Usuario usuarioLogado = tarefasResource.login(new Usuario("usuarioTeste", "senhaTeste"));

        assertEquals("usuarioTeste", usuarioLogado.getUsername());
        assertEquals("senhaTeste", usuarioLogado.getSenha());
    }

    @Test
    public void testAssociarTarefaAUsuario() {
        Tarefas tarefaExistente = new Tarefas(1L, "Tarefa 1", "Descrição 1", new Date(), true, null);
        Usuario usuarioExistente = new Usuario("usuarioTeste", "senhaTeste");
        when(tarefasRepository.findById(1L)).thenReturn(Optional.of(tarefaExistente));
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuarioExistente));

        Tarefas tarefaAssociada = tarefasResource.associarTarefaAUsuario(1L, 1L);

        assertEquals(usuarioExistente, tarefaAssociada.getUsuario());
    }
}
