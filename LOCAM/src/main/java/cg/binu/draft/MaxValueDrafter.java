package cg.binu.draft;

import cg.binu.input.Card;

import java.util.List;

public class MaxValueDrafter implements Drafter {
    @Override
    public int draft(DraftChoice draftChoice) {
        final List<Card> cards = draftChoice.getCards();
        double maxValue = 0;
        Card maxValueCard = null;
        for (Card card : cards) {
            final double value = getValue(card);
            if (value > maxValue) {
                maxValueCard = card;
                maxValue = value;
            }
        }

        return cards.indexOf(maxValueCard);
    }

    private double getValue(Card card) {
        final int cost = card.getCost();
        if (cost == 0) {
            return 5;
        }

        return (card.getAttack() + card.getDefense()) / (double) cost;
    }
}
