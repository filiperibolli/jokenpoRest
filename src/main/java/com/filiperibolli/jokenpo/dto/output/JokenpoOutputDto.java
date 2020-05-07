package com.filiperibolli.jokenpo.dto.output;

public class JokenpoOutputDto {

	
	public JokenpoOutputDto(String playerId) {
		this.playerId = playerId;
	}

	private String playerId;
	
	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	@Override
	public String toString() {
		return "JokenpoOutputDto [playerId=" + playerId + "]";
	}

}
