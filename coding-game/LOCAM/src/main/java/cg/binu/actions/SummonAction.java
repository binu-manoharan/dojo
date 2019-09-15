package cg.binu.actions;

import cg.binu.input.Card;

public class SummonAction extends CardAction {
    public SummonAction(Card card) {
        super(card, Action.SUMMON);
    }

    @Override
    public String toString() {
        if (action == Action.SUMMON) {
            return "SUMMON " + card.getInstanceId() + ";";
        }

        throw new UnsupportedOperationException("Unexpected action.");
    }
}
