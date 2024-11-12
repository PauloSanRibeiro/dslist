package br.com.prsribeiro.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prsribeiro.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
