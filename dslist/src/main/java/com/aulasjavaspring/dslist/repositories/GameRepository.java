package com.aulasjavaspring.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aulasjavaspring.dslist.entities.Game;
import com.aulasjavaspring.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {

	// OBJETO RESPONSÁVEL POR FAZER OPERAÇOES NO BANCO DE DADOS (CONSULTAR/INSERIR/ATUALIZAR/DELETAR : OPERAÇÕES BÁSICAS)

	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	
	List<GameMinProjection> searchByList(Long listId);
}
