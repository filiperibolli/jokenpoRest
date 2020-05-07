package com.filiperibolli.jokenpo.persistence;

import java.util.Optional;

import com.filiperibolli.jokenpo.model.JokenpoAct;

public interface JokenpoPersistence {

	public boolean servidorOpen();

	public Optional<JokenpoAct> findById(String id);

	public String save(String player);

	public void delete(String id);
}
