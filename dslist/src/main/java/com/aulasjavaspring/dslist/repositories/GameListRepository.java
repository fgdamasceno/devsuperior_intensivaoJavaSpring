package com.aulasjavaspring.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulasjavaspring.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
	
	// REALIZA AS CONSULTAS/OPERAÇÕES NO BANCO DE DADOS
	
}
