package com.filiperibolli.jokenpo.service;

import java.util.Optional;

import com.filiperibolli.jokenpo.model.JokenpoAct;

public interface JokenpoService {

	public boolean servidorOpen();

	public Optional<JokenpoAct> findById(String id);

	public String save(String player);

	public void deleteById(String id);
}
