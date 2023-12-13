package com.example.tarefas.APIREST.modelTest;

import com.example.tarefas.APIREST.model.Tarefas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class TarefasTest {

    @Test
    void testGettersAndSetters() {

        Tarefas tarefa = new Tarefas();



        tarefa.setId(1L);


        assertEquals(1L, tarefa.getId());


        tarefa.setTitulo("Teste Título");


        assertEquals("Teste Título", tarefa.getTitulo());


        tarefa.setDescricao("Teste Descrição");


        assertEquals("Teste Descrição", tarefa.getDescricao());


        Date dataVencimento = new Date();
        tarefa.setDataVencimento(dataVencimento);


        assertEquals(dataVencimento, tarefa.getDataVencimento());


        tarefa.setStatus(true);


        assertTrue(tarefa.isStatus());
    }


    @Test
    void testToString() {

        Tarefas tarefa = new Tarefas();
        tarefa.setId(1L);
        tarefa.setTitulo("Teste Título");
        tarefa.setDescricao(null);  // Tratamento para descrição nula


        String expectedToString = "Tarefas{id=1, titulo='Teste Título', descricao='null', dataVencimento=null, status=false}";



    }
}
