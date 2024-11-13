package com.aulasjavaspring.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // CONFIGURA A CLASSE PARA QUE SEJA EQUIVALENTE A UMA TABELA DO BANCO DE DADOS RELACIONAL
@Table(name = "tb_game") // CONFIGURA UM NOME CUSTOMIZADO PARA UMA TABELA SQL NO BANCO DE DADOS E DEFINE SEU NOME NO PARAMETRO
public class Game {

	@Id // DEFINE O id COMO CHAVE PRIMARIA
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PARA QUE O id SEJA AUTO INCREMENTÁVEL PELO BANCO DE DADOS
	private Long id;
	private String title;
	@Column(name = "game_year") // CUSTOMIZANDO O NOME DA COLUNA NO BD PARA EVITAR CONFLITO COM PALAVRA RESERVADA 'year'
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	@Column(columnDefinition = "TEXT") // PARA QUE A JPA GERE UM CAMPO NO DB COMO 'TEXTO' E NÃO COMO 'VARCHAR(255)'
	private String shortDescription;
	@Column(columnDefinition = "TEXT")
	private String longDescription;
	
	public Game() {
	}

	public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl,
			String shortDescription, String longDescription) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platforms = platforms;
		this.score = score;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	// PARA REALIZAR A COMPARAÇÃO ENTRE OS JOGOS
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}

	
}
