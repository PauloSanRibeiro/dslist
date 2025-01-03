package br.com.prsribeiro.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.prsribeiro.dslist.dto.GameListDTO;
import br.com.prsribeiro.dslist.entities.GameList;
import br.com.prsribeiro.dslist.projections.GameMinProjection;
import br.com.prsribeiro.dslist.repositories.GameListRepository;
import br.com.prsribeiro.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {

		List<GameList> result = gameListRepository.findAll();

		return result.stream().map(x -> new GameListDTO(x)).toList();
	}

	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		// atualizacao em memoria
		GameMinProjection obj = result.remove(sourceIndex);
		result.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, result.get(i).getId(), i);
		}

	}

}
