package com.example.tarefas.APIREST.modelTest;

import com.example.tarefas.APIREST.model.Tarefas;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TarefasTest {

    @Test
    public void testGetterSetter() {
        Date dataVencimento = null;
        Tarefas tarefa = new Tarefas(1L, "Título", "Descrição", dataVencimento, true, null);
        tarefa.setTitulo("Título");
        assertEquals("Título", tarefa.getTitulo());

        tarefa.setDescricao("Descrição");
        assertEquals("Descrição", tarefa.getDescricao());

        dataVencimento = new Date();
        tarefa.setDataVencimento(dataVencimento);
        assertEquals(dataVencimento, tarefa.getDataVencimento());

        tarefa.setStatus(true);
        assertEquals(true, tarefa.isStatus());

        // Testar outros atributos
    }

    @Test
    public void testConstrutor() {
        Date dataVencimento = new Date();
        Tarefas tarefa = new Tarefas(1L, "Título", "Descrição", dataVencimento, true, null);
        assertEquals(1L, tarefa.getId().longValue());
        assertEquals("Título", tarefa.getTitulo());
        assertEquals("Descrição", tarefa.getDescricao());
        assertEquals(dataVencimento, tarefa.getDataVencimento());
        assertEquals(true, tarefa.isStatus());

        // Testar outros atributos
    }
}
