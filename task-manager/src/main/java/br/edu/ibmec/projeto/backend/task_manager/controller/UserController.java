package br.edu.ibmec.projeto.backend.task_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ibmec.projeto.backend.task_manager.model.User;
import br.edu.ibmec.projeto.backend.task_manager.repository.UserRepository;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping()
    public String index(Model modelView) {
        //Obtendo todos os usuários
        modelView.addAttribute("listaUser", repository.findAll());
        return "lista-user";
    }

    @GetMapping("/create")
    public String createTask() {
        return "create-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user) {
       //Inserção no banco de dados
        repository.save(user);

        return "redirect:/user";
    }
}
