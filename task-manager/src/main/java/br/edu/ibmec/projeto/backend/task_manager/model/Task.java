package br.edu.ibmec.projeto.backend.task_manager.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tasks")
public class Task {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String owner;

    @Column
    private String status;

    @Column
    private LocalDate createdDate;

    @Column
    private String description;
}
