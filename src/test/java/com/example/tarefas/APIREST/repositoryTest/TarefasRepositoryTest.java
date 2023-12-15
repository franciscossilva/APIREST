package com.example.tarefas.APIREST.repositoryTest;

import com.example.tarefas.APIREST.model.Tarefas;
import com.example.tarefas.APIREST.repository.TarefasRepository;
import com.example.tarefas.APIREST.resource.TarefasService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TarefasRepositoryTest {

    @Mock
    private TarefasRepository tarefasRepositoryMock;

    @InjectMocks
    private TarefasService tarefasServiceTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        // Arrange
        long id = 1L;
        Tarefas tarefaMock = new Tarefas();
        tarefaMock.setId(id);
        when(tarefasRepositoryMock.findById(id)).thenReturn(Optional.of(tarefaMock));

        // Act
        //Tarefas result = tarefasServiceTest.

        // Assert
        //assertEquals(id, result.getId());
        verify(tarefasRepositoryMock, times(1)).findById(id);
    }
    @Disabled
    @Test
    public void testFindByTitulos() {
        // Arrange
        String titulo = "Tarefa 1";
        Tarefas tarefaMock = new Tarefas();
       // tarefaMock.setTitulos(titulo);
        when(tarefasRepositoryMock.findByTitulos(titulo)).thenReturn(tarefaMock);

        // Act
       // Tarefas result = tarefasService.findByTitulos(titulo);

        // Assert
      //  assertEquals(titulo, result.getTitulos());
        verify(tarefasRepositoryMock, times(1)).findByTitulos(titulo);
    }
}
