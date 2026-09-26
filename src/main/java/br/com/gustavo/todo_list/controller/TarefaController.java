package br.com.gustavo.todo_list.controller;

import br.com.gustavo.todo_list.entity.Tarefa;
import br.com.gustavo.todo_list.repository.TarefaRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "http://localhost:5173")

public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Tarefa criar(@Valid @RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    @GetMapping
    public List<Tarefa> listar(@RequestParam(required = false) String titulo) {

        if (titulo != null) {
            return repository.findByTituloContainingIgnoreCase(titulo);
        }

        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Tarefa editar(@PathVariable Long id, @Valid @RequestBody Tarefa tarefa) {
        tarefa.setId(id);
        return repository.save(tarefa);
    }

}
