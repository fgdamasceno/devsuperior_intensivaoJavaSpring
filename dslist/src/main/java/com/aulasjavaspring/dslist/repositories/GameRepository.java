package com.aulasjavaspring.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulasjavaspring.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	
	// REALIZA AS CONSULTAS/OPERAÇÕES NO BANCO DE DADOS
	
}
