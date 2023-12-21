package com.example.tarefas.APIREST.Servirce;

import com.example.tarefas.APIREST.model.Tarefas;
import com.example.tarefas.APIREST.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/Tarefas")
public class TarefasService {
    @Autowired
    private TarefasRepository tarefasRepository;

    @GetMapping("/Tarefas")
    public List<Tarefas> listarTarefas() {
        return tarefasRepository.findAll();
    }

    @GetMapping("/Tarefa/{id}")
    public Optional<Tarefas> obterTarefaPorId(@PathVariable(value = "id") long id) {
        return tarefasRepository.findById(id);
    }

    @GetMapping("/Tarefa/{Ttitulo}")
    public Tarefas obterTarefaPotitulo(@PathVariable(value = "titulos") String titulos) {
        return tarefasRepository.findByTitulos(titulos);
    }

    @PostMapping("/Tarefa")
    public Tarefas criarTarefa(@RequestBody Tarefas tarefa) {
        return tarefasRepository.save(tarefa);
    }

    @PutMapping("/Tarefa")
    public Tarefas atualizarTarefas(@RequestBody Tarefas tarefas) {
        return tarefasRepository.save(tarefas);
    }

    @DeleteMapping("/Tarefa")
    public void deletarTarefa(@RequestBody Tarefas tarefas) {
        tarefasRepository.delete(tarefas);

    }


}





