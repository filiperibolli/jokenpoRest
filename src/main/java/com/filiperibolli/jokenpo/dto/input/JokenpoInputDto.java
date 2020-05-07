package com.filiperibolli.jokenpo.dto.input;

import java.util.List;

import com.filiperibolli.jokenpo.model.JokenpoAct;

public class JokenpoInputDto {

	private List<JokenpoAct> jokenpoActs;

	public List<JokenpoAct> getJokenpoActs() {
		return jokenpoActs;
	}

	public void setJokenpoActs(List<JokenpoAct> jokenpoActs) {
		this.jokenpoActs = jokenpoActs;
	}

}
