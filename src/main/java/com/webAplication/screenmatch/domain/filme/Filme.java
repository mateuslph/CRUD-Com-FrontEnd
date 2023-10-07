package com.webAplication.screenmatch.domain.filme;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer duracaoEmMinutos;
    private Integer anoLancamento;
    private String genero;
    private LocalDateTime dataHoraGravacao;

    public Filme(FilmeDto dados) {
            this.nome = dados.nome();
            this.duracaoEmMinutos = dados.duracao();
            this.anoLancamento = dados.ano();
            this.genero = dados.genero();
            this.dataHoraGravacao = LocalDateTime.now();
    }

    public Filme() {
    }

    public void atualizaDados(FilmeDto dados) {
        this.nome = dados.nome();
        this.duracaoEmMinutos = dados.duracao();
        this.anoLancamento = dados.ano();
        this.genero = dados.genero();
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                ", anoLancamento=" + anoLancamento +
                ", genero='" + genero + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDateTime getDataHoraGravacao() { return dataHoraGravacao; }

}

