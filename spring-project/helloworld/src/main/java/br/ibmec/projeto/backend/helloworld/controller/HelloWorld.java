package br.ibmec.projeto.backend.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ibmec.projeto.backend.helloworld.model.Saudacao;

@Controller
@RequestMapping("/hello")
public class HelloWorld {

    @GetMapping
    public String exibir(Model viewModel){
        Saudacao model = new Saudacao();
        model.setNome("Bernardo");
        model.setUltimoNome("James");
        model.setMensagem("Hello world");

        viewModel.addAttribute("saudacaoModel", model);

        return "hello-world";
    }
}
