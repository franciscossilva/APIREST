package com.example.tarefas.APIREST.resourceTest;

import com.example.tarefas.APIREST.model.Tarefas;
import com.example.tarefas.APIREST.repository.TarefasRepository;
import com.example.tarefas.APIREST.resource.TarefasService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TarefasServiceTest {

    @Mock
    private TarefasRepository tarefasRepositoryMock;

    @InjectMocks
    private TarefasService tarefasService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarTarefas() {
        // Arrange
        List<Tarefas> tarefasList = Arrays.asList(new Tarefas(), new Tarefas());
        when(tarefasRepositoryMock.findAll()).thenReturn(tarefasList);

        // Act
        List<Tarefas> result = tarefasService.listarTarefas();

        // Assert
        assertEquals(tarefasList, result);
        verify(tarefasRepositoryMock, times(1)).findAll();
    }

    @Test
    public void testObterTarefaPorId() {
        // Arrange
        long id = 1L;
        Tarefas tarefaMock = new Tarefas();
        when(tarefasRepositoryMock.findById(id)).thenReturn(Optional.of(tarefaMock));

        // Act
        Optional<Tarefas> result = tarefasService.obterTarefaPorId(id);

        // Assert
        assertEquals(Optional.of(tarefaMock), result);
        verify(tarefasRepositoryMock, times(1)).findById(id);
    }

    @Test
    public void testObterTarefaPorTitulo() {
        // Arrange
        String titulo = "Tarefa 1";
        Tarefas tarefaMock = new Tarefas();
        when(tarefasRepositoryMock.findByTitulos(titulo)).thenReturn(tarefaMock);

        // Act
        Tarefas result = tarefasService.obterTarefaPotitulo(titulo);

        // Assert
        assertEquals(tarefaMock, result);
        verify(tarefasRepositoryMock, times(1)).findByTitulos(titulo);
    }

    @Test
    public void testCriarTarefa() {
        // Arrange
        Tarefas tarefaMock = new Tarefas();
        when(tarefasRepositoryMock.save(tarefaMock)).thenReturn(tarefaMock);

        // Act
        Tarefas result = tarefasService.criarTarefa(tarefaMock);

        // Assert
        assertEquals(tarefaMock, result);
        verify(tarefasRepositoryMock, times(1)).save(tarefaMock);
    }

    @Test
    public void testAtualizarTarefas() {
        // Arrange
        Tarefas tarefaMock = new Tarefas();
        when(tarefasRepositoryMock.save(tarefaMock)).thenReturn(tarefaMock);

        // Act
        Tarefas result = tarefasService.atualizarTarefas(tarefaMock);

        // Assert
        assertEquals(tarefaMock, result);
        verify(tarefasRepositoryMock, times(1)).save(tarefaMock);
    }

    @Test
    public void testDeletarTarefa() {
        // Arrange
        Tarefas tarefaMock = new Tarefas();

        // Act
        tarefasService.deletarTarefa(tarefaMock);

        // Assert
        verify(tarefasRepositoryMock, times(1)).delete(tarefaMock);
    }
}
