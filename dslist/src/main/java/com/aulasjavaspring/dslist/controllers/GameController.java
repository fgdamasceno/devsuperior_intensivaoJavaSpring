package com.aulasjavaspring.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulasjavaspring.dslist.dto.GameDTO;
import com.aulasjavaspring.dslist.dto.GameMinDTO;
import com.aulasjavaspring.dslist.services.GameService;

@RestController // CONFIGURA CLASSE COMO CONTROLADORA
@RequestMapping(value = "/games") // MAPEIA O CAMINHO PARA OS DADOS
public class GameController {
	
	@Autowired
	private GameService gameService; // INJETA 'GameService' DENTRO DO 'GameController'

	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id) {
		GameDTO result = gameService.findById(id);
		return result;
	}
	
	@GetMapping // MAPEIA COM O VERBO HTTP 'GET' PARA OBTER OS DADOS
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
		
}
