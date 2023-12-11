package com.example.tarefas.APIREST.resource;

import com.example.tarefas.APIREST.model.Tarefas;
import com.example.tarefas.APIREST.model.Usuario;
import com.example.tarefas.APIREST.repository.TarefasRepository;
import com.example.tarefas.APIREST.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "tarefas")
public class TarefasResource {

    @Autowired
    private TarefasRepository tarefasRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/Tarefas")
    public List<Tarefas> listarTarefas() {
        return tarefasRepository.findAll();
    }

    @GetMapping("/Tarefa/{id}")
    public Tarefas obterTarefaPorId(@PathVariable(value = "id") long id) {
        return tarefasRepository.findById(id).orElse(null);
    }

    @PostMapping("/Tarefa")
    public Tarefas criarTarefa(@RequestBody Tarefas tarefa) {
        return tarefasRepository.save(tarefa);
    }

    @DeleteMapping("/Tarefa/{id}")
    public void deletarTarefa(@PathVariable(value = "id") long id) {
        tarefasRepository.deleteById(id);
    }

    @PutMapping("/Tarefa/{id}")
    public Tarefas atualizarTarefa(@PathVariable(value = "id") long id, @RequestBody Tarefas tarefaAtualizada) {
        Tarefas tarefaExistente = tarefasRepository.findById(id).orElse(null);

        if (tarefaExistente != null) {
            // Atualiza os campos relevantes da tarefaExistente com os valores da tarefaAtualizada
            tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
            tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
            tarefaExistente.setDataVencimento(tarefaAtualizada.getDataVencimento());
            tarefaExistente.setStatus(tarefaAtualizada.isStatus());

            return tarefasRepository.save(tarefaExistente);
        } else {
            return null; // Trate a situação em que a tarefa não foi encontrada
        }
    }

    // Operação de Login
    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) {
        // Implemente a lógica de login, verificando se o usuário e a senha correspondem
        // Se a autenticação for bem-sucedida, retorne o usuário autenticado; caso contrário, retorne null
        return usuarioRepository.findByUsernameAndSenha(usuario.getUsername(), usuario.getSenha());
    }

    // Operação de Associação de Tarefa a Usuário
    @PostMapping("/associar-tarefa-usuario/{idTarefa}/{idUsuario}")
    public Tarefas associarTarefaAUsuario(
            @PathVariable(value = "idTarefa") long idTarefa,
            @PathVariable(value = "idUsuario") long idUsuario) {

        Tarefas tarefa = tarefasRepository.findById(idTarefa).orElse(null);
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);

        if (tarefa != null && usuario != null) {
            // Associa a tarefa ao usuário
            tarefa.setUsuario(usuario);
            return tarefasRepository.save(tarefa);
        } else {
            return null; // Trate a situação em que a tarefa ou o usuário não foi encontrado
        }
    }
}
