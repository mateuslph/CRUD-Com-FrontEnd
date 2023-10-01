package com.webAplication.screenmatch.service;

import com.webAplication.screenmatch.business.FilmesBusiness;
import com.webAplication.screenmatch.domain.filme.DadosAlteracaoFilme;
import com.webAplication.screenmatch.domain.filme.DadosCadastroFilme;
import com.webAplication.screenmatch.domain.filme.Filme;
import com.webAplication.screenmatch.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService {

    @Autowired
    FilmeRepository filmeRepository;
    @Autowired
    FilmesBusiness filmesBusiness;

    @Transactional
    public boolean salvar(DadosCadastroFilme dados) {
        Filme filme = new Filme(dados);
        List<String> mensagensDeErro = new ArrayList<>();
        try {
            filmesBusiness.verificaDados(filme, mensagensDeErro);
            if (mensagensDeErro.isEmpty()) {
                filmeRepository.save(filme);
                return true;
            } else {
                throw new RuntimeException("Existem Erros de Validação!!");
            }
        } catch (RuntimeException e) {
            System.out.println(mensagensDeErro);
            return false;
        }
    }

    public void carregarById(Long id, Model model) {
        if (id != null) {
            var filme = filmeRepository.getReferenceById(id);
            model.addAttribute("filme", filme);
        }
    }

    public void carregarListagem(Model model) {
        model.addAttribute("lista", filmeRepository.findAll());
    }

    @Transactional
    public void alterarFilme(DadosAlteracaoFilme dados) {
        Filme filme = filmeRepository.getReferenceById(dados.id());
        filme.atualizaDados(dados);
    }

    @Transactional
    public void deletar(Long id) {
        filmeRepository.deleteById(id);
    }
}
