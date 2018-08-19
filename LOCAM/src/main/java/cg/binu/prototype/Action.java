package cg.binu.prototype;

import java.util.List;

public interface Action {
    String generateMovesForThisTurn(List<Card> cards, int maxMana);
}
