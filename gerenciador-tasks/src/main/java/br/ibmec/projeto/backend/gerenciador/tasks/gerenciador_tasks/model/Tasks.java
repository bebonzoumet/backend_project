package br.ibmec.projeto.backend.gerenciador.tasks.gerenciador_tasks.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Tasks {
    private Integer id;
    private String nome;
    private String responsavel;
    private String status;
    private LocalDate dataCriacao;
}
