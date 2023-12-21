package com.example.tarefas.APIREST.modelTest;

import com.example.tarefas.APIREST.model.Tarefas;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class TarefasTest {

    @Test
    public void testTarefas() {
        // Arrange (Preparação)
        Long id = 1L;
        String titulo = "Minha Tarefa";
        String descricao = "Descrição da tarefa";
        Date dataVencimento = new Date();
        boolean status = true;

        // Act ( ação)
        Tarefas tarefas = new Tarefas();
        tarefas.setId(id);
        tarefas.setTitulo(titulo);
        tarefas.setDescricao(descricao);
        tarefas.setDataVencimento(dataVencimento);
        tarefas.setStatus(status);

        // Assert ( validação)
        assertEquals(id, tarefas.getId());
        assertEquals(titulo, tarefas.getTitulo());
        assertEquals(descricao, tarefas.getDescricao());
        assertEquals(dataVencimento, tarefas.getDataVencimento());
        assertEquals(status, tarefas.isStatus());
    }
}
