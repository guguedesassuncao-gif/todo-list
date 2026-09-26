package br.com.gustavo.todo_list.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
@Getter
@Setter

public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O titulo e obrigatorio")
    private String titulo;

    private String descricao;

    @NotNull(message = "A data prevista e obrigatoria")
    private LocalDate dataPrevista;

    private String status;

    }

