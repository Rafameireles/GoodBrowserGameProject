package com.goodBrowserGame.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goodBrowserGame.entity.BrowserGameEntity;
import com.goodBrowserGame.repository.BrowserGameRepository;

@RestController
public class BrowserGameController {
	@Autowired
	private BrowserGameRepository repository;
	
	@RequestMapping(value = "/browsergames", method = RequestMethod.GET)
	public List<BrowserGameEntity> getBrowserGames() {
		return repository.findAll();
	}
	
    @RequestMapping(value = "/browsergames", method = RequestMethod.POST)
    public BrowserGameEntity createBrowserGame(@RequestBody BrowserGameEntity browsergames) {
        return repository.save(browsergames); // salva no banco
    }
	
	@RequestMapping(value = "/browsergames/{id}", method = RequestMethod.GET)
	public ResponseEntity<BrowserGameEntity> getById(@PathVariable(value = "id") long id){
		Optional<BrowserGameEntity> response = repository.findById(id);
		if (response.isPresent()) {
			return new ResponseEntity<BrowserGameEntity>(response.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/browsergames/{id}", method = RequestMethod.PUT)
	public ResponseEntity<BrowserGameEntity> Put(@PathVariable(value = "id") long id, 
			@Valid @RequestBody BrowserGameEntity novoJogo) {
		Optional<BrowserGameEntity> jogoAntigo = repository.findById(id);
		if (jogoAntigo.isPresent()) {
			BrowserGameEntity jogo = jogoAntigo.get();
			jogo.setNome(novoJogo.getNome());
			jogo.setUrlJogo(novoJogo.getUrlJogo());
			jogo.setUrlVideo(novoJogo.getUrlVideo());
			jogo.setDescricao(novoJogo.getDescricao());
			jogo.setUrlImagem(novoJogo.getUrlImagem());
			repository.save(jogo);
			return new ResponseEntity<BrowserGameEntity>(jogo, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/browsergames/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
		Optional<BrowserGameEntity> jogo = repository.findById(id);
		if (jogo.isPresent()) {
			repository.delete(jogo.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
