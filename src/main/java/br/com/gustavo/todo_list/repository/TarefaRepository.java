package br.com.gustavo.todo_list.repository;

import br.com.gustavo.todo_list.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

        List<Tarefa> findAllByTituloContainingIgnoreCase(String titulo);

    List<Tarefa> findByTituloContainingIgnoreCase(String titulo);
}
