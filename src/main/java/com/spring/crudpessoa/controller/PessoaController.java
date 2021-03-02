package com.spring.crudpessoa.controller;

import com.spring.crudpessoa.model.Pessoa;
import com.spring.crudpessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping("/cadastrar")
    public String cadastrar(ModelMap modelMap){
        modelMap.addAttribute("pessoa", new Pessoa());
        return "cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(Pessoa pessoa){
        service.salvar(pessoa);

        return "redirect:/pessoa/listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("pessoas", service.listar());
        return "listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable(name = "id") Long id,
                            ModelMap model){
        model.addAttribute("pessoa", service.buscarPorId(id));
        return "cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable(name = "id") Long id,
                         ModelMap model){
        Pessoa pessoa = service.buscarPorId(id);
        service.excluir(pessoa);

        return "redirect:/pessoa/listar";
    }

    @ModelAttribute("anoAtual")
    public int anoAtual(){
        return LocalDate.now().getYear();
    }
}
