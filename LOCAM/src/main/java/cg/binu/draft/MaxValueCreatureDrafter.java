package cg.binu.draft;

import cg.binu.input.Card;
import cg.binu.input.CardType;

import java.util.List;
import java.util.stream.Collectors;

public class MaxValueCreatureDrafter implements Drafter {
    @Override
    public int draft(DraftChoice draftChoice) {
        final List<Card> initialCards = draftChoice.getCards();
        final List<Card> cardsWithOnlyCreatures = draftChoice.getCards()
                .stream()
                .filter(card -> card.getType() == CardType.CREATURES)
                .collect(Collectors.toList());

        if (cardsWithOnlyCreatures.size() == 0) {
            return -1;
        }

        double maxValue = 0;
        Card maxValueCard = null;
        for (Card card : cardsWithOnlyCreatures) {
            final double value = getValue(card);
            if (value > maxValue) {
                maxValueCard = card;
                maxValue = value;
            }
        }

        return initialCards.indexOf(maxValueCard);
    }

    private double getValue(Card card) {
        final int cost = card.getCost();
        if (cost == 0) {
            return 5;
        }

        return (card.getAttack() + card.getDefense()) / (double) cost;
    }
}
