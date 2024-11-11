package com.aulasjavaspring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulasjavaspring.dslist.dto.GameMinDTO;
import com.aulasjavaspring.dslist.entities.Game;
import com.aulasjavaspring.dslist.repositories.GameRepository;

@Service // ou @Component
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public  List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
//		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
//		return dto;
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}

}
