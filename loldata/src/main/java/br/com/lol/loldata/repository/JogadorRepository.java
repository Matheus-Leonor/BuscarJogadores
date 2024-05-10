package br.com.lol.loldata.repository;

import br.com.lol.loldata.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
