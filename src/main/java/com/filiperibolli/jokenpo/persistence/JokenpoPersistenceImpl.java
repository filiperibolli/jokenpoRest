package com.filiperibolli.jokenpo.persistence;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.filiperibolli.jokenpo.model.JokenpoAct;

@Service
public class JokenpoPersistenceImpl implements JokenpoPersistence{
	
	@Override
	public boolean servidorOpen() {
		return true;
	}

	@Override
	public Optional<JokenpoAct> findById(String id) {
		//Mock retorno do bd
		JokenpoAct jokenpoAct = new JokenpoAct();
		jokenpoAct.setPlayerId("Jogador1");
		
		return Optional.of(jokenpoAct);
	}

	@Override
	public String save(String player) {
		//Retorna o id
		return player;
	}

	@Override
	public void delete(String id) {
	}

}
