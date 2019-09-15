package cg.binu.actions;

import cg.binu.input.Card;

public abstract class CardAction {
    Card card;
    Action action;

    public CardAction(Card card, Action action) {
        this.card = card;
        this.action = action;
    }
}
