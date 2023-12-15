package com.example.tarefas.APIREST.modelTest;

import com.example.tarefas.APIREST.model.Tarefas;
import lombok.Data;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

class TarefasTest {
    @Test
    @DisplayName(" Teste da Funcionalidade GET")
    void  testGettersAndSetters() {

        //Given / Arrange
        Tarefas tarefa = new Tarefas();

        Long id1 = 1L;
        Long id2 = 1L;
        Long expected = 1L;

        // When / Act
        //Long atual = tarefa.getId(id1,id2);


      //  assertEquals(expected,atual, id1 + "+" + id2+ " Nao retornou o " + expected );
    //   assertNotEquals(1L, atual);;
     //  assertNotNull(atual);





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
