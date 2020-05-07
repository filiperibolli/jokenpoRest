package com.filiperibolli.jokenpo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filiperibolli.jokenpo.model.JokenpoAct;
import com.filiperibolli.jokenpo.persistence.JokenpoPersistence;

@Service
public class JokenpoServiceImpl implements JokenpoService{
	
	@Autowired
	private JokenpoPersistence jokenpoPersistence;
	
	
	@Override
	public boolean servidorOpen() {
		return true;
	}

	@Override
	public Optional<JokenpoAct> findById(String id) {
		return jokenpoPersistence.findById(id);
	}

	@Override
	public String save(String player) {
		return jokenpoPersistence.save(player);
	}

	@Override
	public void deleteById(String id) {
		jokenpoPersistence.delete(id);
	}

}
