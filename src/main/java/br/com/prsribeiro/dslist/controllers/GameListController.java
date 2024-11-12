package br.com.prsribeiro.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prsribeiro.dslist.dto.GameListDTO;
import br.com.prsribeiro.dslist.dto.GameMinDTO;
import br.com.prsribeiro.dslist.services.GameListService;
import br.com.prsribeiro.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	public GameListService gameListService;

	@Autowired
	public GameService gameService;

	@GetMapping
	public List<GameListDTO> findAll() {

		List<GameListDTO> result = gameListService.findAll();
		return result;
	}

	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {

		List<GameMinDTO> result = gameService.findByList(listId);
		return result;

	}
}
