package com.goodBrowserGame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "browser_game")
public class BrowserGameEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)  //não pode ser vazio
	private String nome;
	
	@Column(nullable = false)
	private String urlJogo;
	
	@Column(nullable = false)
	private String urlVideo;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private String urlImagem;
	
    public BrowserGameEntity() {

    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlJogo() {
		return urlJogo;
	}

	public void setUrlJogo(String urlJogo) {
		this.urlJogo = urlJogo;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	
	

}
