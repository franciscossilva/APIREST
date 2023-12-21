package com.example.tarefas.APIREST.repositoryTest;

import com.example.tarefas.APIREST.model.Tarefas;
import com.example.tarefas.APIREST.repository.TarefasRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TarefasRepositoryTest {

    @Autowired
    private TarefasRepository tarefasRepository;

    @Test
    public void testFindByID() {
        // Arrange
        Tarefas tarefas = new Tarefas();
        tarefas.setId(1L);
        tarefasRepository.save(tarefas);

        // Act
        Tarefas result = tarefasRepository.findByID(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testFindByTitulos() {
        // Arrange (
        Tarefas tarefas = new Tarefas();
        tarefas.setTitulos("Teste");
        tarefasRepository.save(tarefas);

        // Act
        Tarefas result = tarefasRepository.findByTitulos("Teste");

        // Assert
        assertNotNull(result);
        assertEquals("Teste", result.getTitulos());
    }
}
