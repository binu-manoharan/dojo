package cg.binu.attack;

import cg.binu.actions.CardAction;
import cg.binu.input.Card;

import java.util.List;

public interface Attacker {
    List<CardAction> getAttacks(List<Card> myCardsOnBoard, List<Card> opponentCardsOnBoard);
}
