package com.filiperibolli.jokenpo.util;

import java.util.List;
import java.util.Optional;

import com.filiperibolli.jokenpo.dto.input.JokenpoInputDto;
import com.filiperibolli.jokenpo.model.JokenpoAct;

public class JokenpoCalculator {

	 /** Return a winner of a game Rock-Paper-Scissors-Lizard-Spock
		 * @return JokenpoAct - Winner act*/
	public static Optional<JokenpoAct> calculateJokenpoWinner(JokenpoInputDto jokenpoInputDto) {
		return verifyWinner(jokenpoInputDto.getJokenpoActs());
	}
	
	
	 /** Return a winner of a game Rock-Paper-Scissors-Lizard-Spock
	 * @return JokenpoAct - Winner act*/
	
	private static Optional<JokenpoAct> verifyWinner(List<JokenpoAct> moves) {
		for (int i = 0; i < moves.size(); i++) {
			boolean winner = true;
			for (int j = 0; j < moves.size(); j++) {
				if(i != j) {
					//Same move = draw
					if((moves.get(i).getMove().toUpperCase())
							.equals((moves.get(j).getMove().toUpperCase()))) {
						winner = false;
						break;
					//Cant win = no winner
					}else if(!(Move.valueOf(moves.get(i).getMove().toUpperCase()).
							winsTo(Move.valueOf(moves.get(j).getMove().toUpperCase())))) {
						winner = false;
						break;
					}
				}
			}
			if(winner) {
				return Optional.of(moves.get(i));
			}
		}
		return Optional.empty();
	}
	
}
