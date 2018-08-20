package cg.binu.actions;

import cg.binu.input.Card;

public class AttackAction extends CardAction {
    private final Card opponentCard;

    public AttackAction(Card myCard, Card opponentCard) {
        super(myCard, Action.ATTACK);
        this.opponentCard = opponentCard;
    }

    @Override
    public String toString() {
        if (action == Action.ATTACK) {
            return "ATTACK " + card.getInstanceId() + " " + opponentCard.getInstanceId() + ";";
        }

        throw new UnsupportedOperationException("Unexpected action.");
    }
}
