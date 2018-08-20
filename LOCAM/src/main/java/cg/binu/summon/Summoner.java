package cg.binu.summon;

import cg.binu.input.Card;

import java.util.List;

public interface Summoner {
    List<CardAction> summon(List<Card> cardsInHand, int maxMana);
}
