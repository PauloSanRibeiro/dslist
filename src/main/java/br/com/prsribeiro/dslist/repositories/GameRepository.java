package br.com.prsribeiro.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prsribeiro.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> { /** ACESSO PARA CONSULTA E OUTRAS OPERAÇÕES COM DADOS DO BD **/

}
