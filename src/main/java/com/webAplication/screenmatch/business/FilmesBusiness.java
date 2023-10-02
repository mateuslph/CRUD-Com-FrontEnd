package com.webAplication.screenmatch.business;

import com.webAplication.screenmatch.domain.filme.Filme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesBusiness {
    public void verificaDados(Filme filme, List<String> mensagens) {
        if (filme.getDuracaoEmMinutos() < 100) {
            mensagens.add("Filme com Duração menor que o pemitido!!");
        }
    }
}
