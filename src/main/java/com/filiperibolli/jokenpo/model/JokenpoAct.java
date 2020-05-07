package com.filiperibolli.jokenpo.model;

public class JokenpoAct {
	
	private String playerId;
	private String move;
	
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getMove() {
		return move;
	}
	public void setMove(String move) {
		this.move = move;
	}
	@Override
	public String toString() {
		return "JokenpoInputDto [playerId=" + playerId + ", move=" + move + "]";
	}

}
