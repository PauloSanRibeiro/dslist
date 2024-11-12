package br.com.prsribeiro.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.prsribeiro.dslist.dto.GameDTO;
import br.com.prsribeiro.dslist.dto.GameMinDTO;
import br.com.prsribeiro.dslist.entities.Game;
import br.com.prsribeiro.dslist.repositories.GameRepository;

@Service
public class GameService {
	/** REGRA DE NEGOCIO, CUIDA DAS OPERADOCOES **/

	@Autowired // INJECT GAME REPORSITORY
	public GameRepository gameRepository;

	@Transactional(readOnly = true) // RECOMENDADO PARA GARANTIR TRANSACAO COM BANCO
	public GameDTO findById(Long id) {

		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);

	}

	public List<GameMinDTO> findAll() {

		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();

	}

}
