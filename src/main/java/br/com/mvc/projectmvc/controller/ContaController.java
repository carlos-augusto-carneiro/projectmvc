package br.com.mvc.projectmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller 
@RequestMapping("/conta")
public class ContaController {

    @GetMapping("atualizar")
    public String atualizar(Model model){
        return "Conta/Atualizar";
    }
}
