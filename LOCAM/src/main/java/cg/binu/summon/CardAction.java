package cg.binu.summon;

import cg.binu.input.Card;

public class CardAction {
    Card card;
    Action action;

    public CardAction(Card card, Action action) {
        this.card = card;
        this.action = action;
    }

    @Override
    public String toString() {
        if (action == Action.SUMMON) {
            return "SUMMON " + card.getInstanceId() + ";";
        }

        throw new UnsupportedOperationException("Unexpected action.");
    }
}
