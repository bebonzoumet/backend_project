package br.ibmec.projeto.backend.gerenciador.tasks.gerenciador_tasks.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ibmec.projeto.backend.gerenciador.tasks.gerenciador_tasks.model.Tasks;

@Controller
@RequestMapping("/")
public class GerenciadorTasks {

    private static List<Tasks> _Tasks = new ArrayList<>();

    public Tasks criaTask(Integer id, String nome, String responsavel, String descricao, String status, LocalDate dataCriacao) {
        Tasks novaTask = new Tasks();
        novaTask.setId(id);
        novaTask.setNome(nome);
        novaTask.setResponsavel(responsavel);
        novaTask.setStatus(status);
        novaTask.setDataCriacao(dataCriacao);
        return novaTask;
    }

    @GetMapping
    public String exibir(Model viewModel) {
        viewModel.addAttribute("listTasks", _Tasks);
        return "index";
    }

    @GetMapping("/create")
    public String createTaskForm(Model model) {
        //model.addAttribute("task", new Tasks());
        return "create-task";
    }
}
