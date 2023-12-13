package com.example.tarefas.APIREST.repository;

import com.example.tarefas.APIREST.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TarefasRepository  extends JpaRepository <Tarefas ,Long >{
    Tarefas findByID(long id);
    Tarefas findByTitulos(String titulos);

}
