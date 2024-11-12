package br.com.prsribeiro.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.prsribeiro.dslist.entities.Game;
import br.com.prsribeiro.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> { /** ACESSO PARA CONSULTA E OUTRAS OPERAÇÕES COM DADOS DO BD **/
	@Query(nativeQuery = true, value = """
			SELECT game.id, game.title, game.game_year AS `year`, game.img_url AS imgUrl,
			game.short_description AS shortDescription, belonging.position
			FROM game
			INNER JOIN belonging ON game.id = belonging.game_id
			WHERE belonging.list_id = :listId
			ORDER BY belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);
}

