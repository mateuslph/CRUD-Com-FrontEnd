package com.webAplication.screenmatch.controller;

import com.webAplication.screenmatch.domain.filme.FilmeDto;
import com.webAplication.screenmatch.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        filmeService.carregarById(id, model);
        return "filmes/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        filmeService.carregarListagem(model);
        return "filmes/listagem";
    }

    @PostMapping
    public String cadastraFilmes(FilmeDto dados) {
        boolean dadosSalvos = filmeService.salvar(dados);
        if (dadosSalvos) {
            return "redirect:/filmes";
        } return "filmes/formulario";
    }

    @PutMapping
    public String alteraFilmes(FilmeDto dados) {
        filmeService.alterarFilme(dados);
        return "redirect:/filmes";
    }

    @DeleteMapping
    public String removeFilme(Long id) {
        filmeService.deletar(id);
        return "redirect:/filmes";
    }

}
