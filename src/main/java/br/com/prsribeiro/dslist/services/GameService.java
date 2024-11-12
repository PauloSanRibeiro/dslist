package br.com.prsribeiro.dslist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prsribeiro.dslist.dto.GameMinDTO;
import br.com.prsribeiro.dslist.entities.Game;
import br.com.prsribeiro.dslist.repositories.GameRepository;

@Service
public class GameService {
	/** REGRA DE NEGOCIO, CUIDA DAS OPERADOCOES **/

	@Autowired // INJECT GAME REPORSITORY
	public GameRepository gameRepository;

	public List<GameMinDTO> findAll() {

		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();

	}

}
