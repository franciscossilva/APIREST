package com.example.tarefas.APIREST.resourceTest;

import com.example.tarefas.APIREST.model.Tarefas;
import com.example.tarefas.APIREST.repository.TarefasRepository;
import com.example.tarefas.APIREST.resource.TarefasResource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TarefasResourceTest {

    @Mock
    private TarefasRepository tarefasRepository;

    @InjectMocks
    private TarefasResource tarefasResource;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListarTarefas() {
        List<Tarefas> tarefasList = new ArrayList<>();
        when(tarefasRepository.findAll()).thenReturn(tarefasList);

        List<Tarefas> result = tarefasResource.listarTarefas();

        assertEquals(tarefasList, result);
    }

    @Test
    public void testObterTarefaPorId() {
        long id = 1L;
        Tarefas tarefa = new Tarefas();
        when(tarefasRepository.findById(id)).thenReturn(Optional.of(tarefa));

        Optional<Tarefas> result = tarefasResource.obterTarefaPorId(id);

        assertEquals(Optional.of(tarefa), result);
    }

    @Test
    public void testObterTarefaPorTitulo() {
        String titulo = "Tarefa Teste";
        Tarefas tarefa = new Tarefas();
        when(tarefasRepository.findByTitulos(titulo)).thenReturn(tarefa);

        Tarefas result = tarefasResource.obterTarefaPotitulo(titulo);

        assertEquals(tarefa, result);
    }

    @Test
    public void testCriarTarefa() {
        Tarefas tarefa = new Tarefas();
        when(tarefasRepository.save(any(Tarefas.class))).thenReturn(tarefa);

        Tarefas result = tarefasResource.criarTarefa(tarefa);

        assertEquals(tarefa, result);
    }

    @Test
    public void testAtualizarTarefas() {
        Tarefas tarefa = new Tarefas();
        when(tarefasRepository.save(any(Tarefas.class))).thenReturn(tarefa);

        Tarefas result = tarefasResource.atualizarTarefas(tarefa);

        assertEquals(tarefa, result);
    }

    @Test
    public void testDeletarTarefa() {
        Tarefas tarefa = new Tarefas();

        tarefasResource.deletarTarefa(tarefa);

        verify(tarefasRepository, times(1)).delete(tarefa);
    }
}
