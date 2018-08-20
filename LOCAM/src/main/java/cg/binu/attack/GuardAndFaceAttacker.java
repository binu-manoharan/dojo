package cg.binu.attack;

import cg.binu.actions.AttackAction;
import cg.binu.actions.CardAction;
import cg.binu.input.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuardAndFaceAttacker implements Attacker {

    @Override
    public List<CardAction> getAttacks(List<Card> myCardsOnBoard, List<Card> opponentCardsOnBoard) {
        final List<Card> opponentCardsWithGuard = opponentCardsOnBoard.stream()
                .filter(card -> card.getAbilities().contains("G"))
                .collect(Collectors.toList());

        opponentCardsWithGuard.sort((card1, card2) -> card1.getDefense() - card2.getDefense());
        myCardsOnBoard.sort((card1, card2) -> card1.getDamage() - card2.getDamage());

        final List<CardAction> cardActions = new ArrayList<>();
        int opponentCardsWithGuardIndex = 0;
        final ArrayList<Card> myCardsWithoutAction = new ArrayList<>();
        final ArrayList<Card> opponentCardsAliveWithGuard = new ArrayList<>();

        final int numberOfOpponentCardsWithGuard = opponentCardsWithGuard.size();
        for (Card myCard : myCardsOnBoard) {
            final int myCardAttack = myCard.getAttack();

            if (numberOfOpponentCardsWithGuard > opponentCardsWithGuardIndex) {
                final Card opponentCard = opponentCardsWithGuard.get(opponentCardsWithGuardIndex);
                if (opponentCard.getDefense() <= myCardAttack) {
                    cardActions.add(new AttackAction(myCard, opponentCard));
                    opponentCardsWithGuardIndex++;
                } else {
                    myCardsWithoutAction.add(myCard);
                }
            } else {
                cardActions.add(new AttackAction(myCard, null));
            }
        }


        if (numberOfOpponentCardsWithGuard > opponentCardsWithGuardIndex) {
            if (opponentCardsWithGuardIndex == 0) {
                opponentCardsAliveWithGuard.addAll(opponentCardsWithGuard);
            } else {
                opponentCardsAliveWithGuard.addAll(opponentCardsWithGuard.subList(opponentCardsWithGuardIndex, numberOfOpponentCardsWithGuard - 1));
            }
        }

        for (Card opponentCard : opponentCardsAliveWithGuard) {
            int defense  = opponentCard.getDefense();

            if (myCardsWithoutAction.size() == 0) {
                break;
            } else {
                final ArrayList<Card> myCardsWithNewlyAssignedAction = new ArrayList<>();

                for (Card myCard : myCardsWithoutAction) {
                    final int myCardAttack = myCard.getAttack();
                    cardActions.add(new AttackAction(myCard, opponentCard));
                    myCardsWithNewlyAssignedAction.add(myCard);
                    defense -= myCardAttack;

                    if (defense < 0) {
                        break;
                    }
                }
                myCardsWithoutAction.removeAll(myCardsWithNewlyAssignedAction);
            }
        }

        for (Card myCard : myCardsWithoutAction) {
            cardActions.add(new AttackAction(myCard, null));
        }
        return cardActions;
    }
}
