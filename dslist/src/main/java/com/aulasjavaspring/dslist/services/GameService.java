package com.aulasjavaspring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aulasjavaspring.dslist.dto.GameDTO;
import com.aulasjavaspring.dslist.dto.GameMinDTO;
import com.aulasjavaspring.dslist.entities.Game;
import com.aulasjavaspring.dslist.projections.GameMinProjection;
import com.aulasjavaspring.dslist.repositories.GameRepository;

@Service // OU @Component -> REGISTRA COMO SENDO UM COMPONENTE DO SISTEMA
public class GameService {
	
	// RESPONSÁVEL POR IMPLEMENTAR A LÓGICA DE NEGÓCIOS
	
	@Autowired // 
	private GameRepository gameRepository; // INJETA 'GameRepository' DENTRO DO 'GameService'
	
	@Transactional(readOnly = true) // 
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get(); // CABE TRATAMENTO DE EXCEÇAO
//		GameDTO dto = new GameDTO(result); // LONG VERSION
//		return dto;
		return new GameDTO(result);
	}
	
	@Transactional(readOnly = true)
	public  List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll(); // CONSULTA O BD E TRAZ AS INFORMAÇÕES SOLICITADAS EM FORMA DE LISTA
//		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // LONG VERSION
//		return dto;
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public  List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}

}
