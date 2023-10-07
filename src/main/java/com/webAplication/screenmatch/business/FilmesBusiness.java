package com.webAplication.screenmatch.business;

import com.webAplication.screenmatch.domain.filme.DadosAlteracaoFilme;
import com.webAplication.screenmatch.domain.filme.Filme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesBusiness {
    public void verificaDados(Filme filme, List<String> mensagens) {
        if (filme.getDuracaoEmMinutos() < 100) {
            mensagens.add("Filme com Duração menor que o pemitido!!");
        }
        if (filme.getAnoLancamento() < 1900) {
            mensagens.add("Ano menor que 1900 não é permitido!!");
        }
        if (filme.getGenero().toUpperCase().equals("AÇÃO")) {
                if ((filme.getDuracaoEmMinutos() < 120) && (filme.getAnoLancamento() < 1950)) {
                    mensagens.add("o genero de acao nao seja com duracao menor de que 120 minutos e\n" +
                            "o ano menor que 1950");
                }
        }
    }
    public void verificaDadosDto(DadosAlteracaoFilme filme, List<String> mensagens) {
        if (filme.duracao() < 100) {
            mensagens.add("Filme com Duração menor que o pemitido!!");
        }
        if (filme.ano() < 1900) {
            mensagens.add("Ano menor que 1900 não é permitido!!");
        }
        if (filme.genero().toUpperCase().equals("AÇÃO")) {
            if ((filme.duracao() < 120) && (filme.ano() < 1950)) {
                mensagens.add("o genero de acao nao seja com duracao menor de que 120 minutos e\n" +
                        "o ano menor que 1950");
            }
        }
    }
    // TODO: 01/10/2023 validar para que o filme nao seja menor que 1900 caso for ficar na mesma tela e
    //  avisar a inconsistemncia ao usuario --> ok

    // TODO: 01/10/2023 validar para que o genero de acao nao seja com duracao menor de que 120 minutos e
    //  o ano menor que 1950 --> ok

    // TODO: 01/10/2023 mostrar essas inconsistencias na tela
}
