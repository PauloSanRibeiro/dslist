package br.com.prsribeiro.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prsribeiro.dslist.dto.GameMinDTO;
import br.com.prsribeiro.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController { // DISPONIBILIZA API PARA COMUNICACAO

	@Autowired
	private GameService gameService;

	@GetMapping
	public List<GameMinDTO> findAll() {

		List<GameMinDTO> result = gameService.findAll();
		return result;

	}


}
