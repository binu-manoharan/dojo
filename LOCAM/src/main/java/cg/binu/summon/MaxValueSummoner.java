package cg.binu.summon;

import cg.binu.input.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxValueSummoner implements Summoner {
    @Override
    public List<CardAction> summon(List<Card> cardsInHand, int maxMana) {
        if (maxMana == 0) {
            return Collections.emptyList();
        }

        final List<Card> playableCards = cardsInHand.stream()
                .filter(card -> card.getCost() <= maxMana)
                .collect(Collectors.toList());

        final ArrayList<CardAction> summonActions = getSummonActions(maxMana, playableCards);

        return summonActions;
    }

    private ArrayList<CardAction> getSummonActions(int maxMana, List<Card> playableCards) {
        int availableMana = maxMana;
        final ArrayList<CardAction> summonActions = new ArrayList<>();
        playableCards.sort((card1, card2) -> {
            double card1Value = (card1.getAttack() + card1.getDefense()) / (double) card1.getCost();
            double card2Value = (card2.getAttack() + card2.getDefense()) / (double) card2.getCost();

            return card1Value - card2Value < 0 ? 1 : -1;
        });

        for (int i = 0; i < playableCards.size() && availableMana > 0; i++) {
            final Card card = playableCards.get(i);
            final int cardCost = card.getCost();

            if (cardCost <= availableMana) {
                summonActions.add(new CardAction(card, Action.SUMMON));
                availableMana -= cardCost;
            }
        }
        return summonActions;
    }
}
