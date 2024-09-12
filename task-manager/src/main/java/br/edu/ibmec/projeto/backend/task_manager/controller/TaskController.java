package br.edu.ibmec.projeto.backend.task_manager.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import br.edu.ibmec.projeto.backend.task_manager.model.Task;
import br.edu.ibmec.projeto.backend.task_manager.repository.TaskRepository;
import ch.qos.logback.core.testUtil.RandomUtil;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @GetMapping()
    public String index(Model modelView ) {
        //Obtendo todas as tarefas
        modelView.addAttribute("listaTarefas", repository.findAll());
        return "lista-task";
    }

    @GetMapping("/create")
    public String createTask() {
        return "criar-task";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute Task task) {
        task.setId(RandomUtil.getPositiveInt());
        task.setCreatedDate(LocalDate.now());
        task.setDescription("Acabei de criar uma nova tarefa!");

        //Inserção no banco de dados
        repository.save(task);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Integer id) {
        Optional<Task> optTask = repository.findById(id);

        if (optTask.isPresent()) {
            repository.delete(optTask.get());
        }

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model modelAndView, @PathVariable("id") Integer id) {
        Optional<Task> optTask = repository.findById(id);

        modelAndView.addAttribute("editTask", optTask.get());
        return "editar-task";
    }

    @PostMapping("/editTask/{id}")
    public String editTask(@PathVariable("id") Integer id, @ModelAttribute Task newData) {
        Optional<Task> optTask = repository.findById(id);

        Task task = optTask.get();

        task.setName(newData.getName());
        task.setOwner(newData.getOwner());
        task.setStatus(newData.getStatus());

        repository.save(task);

        return "redirect:/";
    }
}
