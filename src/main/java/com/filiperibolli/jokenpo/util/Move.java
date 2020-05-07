package com.filiperibolli.jokenpo.util;

import java.util.Arrays;
import java.util.List;

public enum Move {
	 ROCK, PAPER, SCISSORS, LIZARD, SPOCK;

    public List<Move> winsTo;

    public boolean winsTo(Move other) {
      return winsTo.contains(other);
    }

    static {
      SCISSORS.winsTo = Arrays.asList(PAPER, LIZARD);
      ROCK.winsTo = Arrays.asList(LIZARD, SCISSORS);
      PAPER.winsTo = Arrays.asList(ROCK, SPOCK);
      SPOCK.winsTo = Arrays.asList(ROCK, SCISSORS);
      LIZARD.winsTo = Arrays.asList(PAPER, SPOCK);
    }
}
