package com.webAplication.screenmatch.service;

import com.webAplication.screenmatch.business.FilmesBusiness;
import com.webAplication.screenmatch.domain.filme.FilmeDto;
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
    public boolean salvar(FilmeDto filmeDto) {
        List<String> mensagensDeErro = new ArrayList<>();
        try {
            filmesBusiness.verificaDadosDto(filmeDto, mensagensDeErro);
            if (mensagensDeErro.isEmpty()) {
                Filme filme = new Filme(filmeDto);
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
    public List<String> alterarFilme(FilmeDto dados) {
        Filme filme;
        List<String> mensagensDeErro = new ArrayList<>();
        try {
            filmesBusiness.verificaDadosDto(dados, mensagensDeErro);
            if (mensagensDeErro.isEmpty()) {
                filme = filmeRepository.getReferenceById(dados.id());
                filme.atualizaDados(dados);
                return mensagensDeErro;
            } else {
                throw new RuntimeException("Existem Erros de Validação!!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getCause());
            System.out.println(mensagensDeErro);
            return mensagensDeErro;
        }
    }

    @Transactional
    public void deletar(Long id) {
        filmeRepository.deleteById(id);
    }
}
