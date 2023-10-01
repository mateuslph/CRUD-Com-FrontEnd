package com.webAplication.screenmatch.repository;

import com.webAplication.screenmatch.domain.filme.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
