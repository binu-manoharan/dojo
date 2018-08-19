package cg.binu.drafter;

import cg.binu.input.Card;

import java.util.List;

public class DraftChoice {
    private final List<Card> cards;

    public DraftChoice(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
