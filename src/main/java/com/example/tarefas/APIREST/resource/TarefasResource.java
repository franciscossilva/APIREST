package com.example.tarefas.APIREST.resource;

import com.example.tarefas.APIREST.model.Tarefas;
import com.example.tarefas.APIREST.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "tarefas")
public class TarefasResource {

    @Autowired
    private TarefasRepository tarefasRepository;
    private com.example.tarefas.APIREST.model.Tarefas Tarefas;

    @GetMapping("/Tarefas")
    public List<Tarefas> listadeTarefas() {
        return tarefasRepository.findAll();
    }

    @GetMapping("/Tarefa/{id}")
    public Tarefas tarefasUnica(@PathVariable(value = "id") long id) {
        return tarefasRepository.findByID(id);
    }

    @PostMapping("/Tarefa")
    public Tarefas criarTarefas(@RequestBody Tarefas Tarefas) {
        return tarefasRepository.save(Tarefas);
    }

    @DeleteMapping("/Tarefa/{id}")
    public void deletetarefas(@RequestBody Tarefas Tarefas) {
        tarefasRepository.delete(Tarefas);
    }

    @PutMapping("/Tarefa/{id}")
    public Tarefas atualizarTarefas(@RequestBody Tarefas Tarefas) {
        return tarefasRepository.save(Tarefas);
    }
}




