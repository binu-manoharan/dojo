package template;

import cg.binu.attack.Attacker;
import cg.binu.attack.GuardAndFaceAttacker;
import cg.binu.draft.DraftChoice;
import cg.binu.draft.Drafter;
import cg.binu.draft.MaxValueCreatureDrafter;
import cg.binu.input.Card;
import cg.binu.input.CardType;
import cg.binu.input.Hero;
import cg.binu.actions.CardAction;
import cg.binu.actions.CardActions;
import cg.binu.summon.MaxValueSummoner;
import cg.binu.summon.Summoner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        final Drafter drafter = new MaxValueCreatureDrafter();
        final Summoner summoner = new MaxValueSummoner();
        final Attacker attacker = new GuardAndFaceAttacker();

        // game loop
        while (true) {
            final ArrayList<Hero> heroes = new ArrayList<>();
            // i = 0 is me, 1 is opponent
            for (int i = 0; i < 2; i++) {
                int playerHealth = in.nextInt();
                int playerMana = in.nextInt();
                int playerDeck = in.nextInt();
                int playerRune = in.nextInt();
                heroes.add(new Hero(playerHealth, playerMana));
            }

            final Hero me = heroes.get(0);
            final Hero opponent = heroes.get(1);

            final boolean draftingPhase = me.getMana() == 0 && opponent.getMana() == 0;

            int opponentHand = in.nextInt();
            int cardCount = in.nextInt();

            final ArrayList<Card> allCardsInPlay = new ArrayList<>();
            for (int i = 0; i < cardCount; i++) {
                int cardNumber = in.nextInt();
                int instanceId = in.nextInt();
                int location = in.nextInt();
                int cardType = in.nextInt();
                int cost = in.nextInt();
                int attack = in.nextInt();
                int defense = in.nextInt();
                String abilities = in.next();
                int myHealthChange = in.nextInt();
                int opponentHealthChange = in.nextInt();
                int cardDraw = in.nextInt();

                CardType migratedCardType;
                switch (cardType) {
                    case 0: migratedCardType = CardType.CREATURES; break;
                    case 1: migratedCardType = CardType.ITEM_GREEN; break;
                    case 2: migratedCardType = CardType.ITEM_RED; break;
                    case 3: migratedCardType = CardType.ITEM_BLUE; break;
                    default:
                        throw new IllegalAccessException("Unexpected cardtype!");
                }
                final Card card = new Card(cardNumber, instanceId, location, migratedCardType, cost, attack, defense, abilities, myHealthChange, opponentHealthChange, cardDraw);
                allCardsInPlay.add(card);
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            if (draftingPhase) {
                final DraftChoice draftChoice = new DraftChoice(allCardsInPlay);
                final int draft = drafter.draft(draftChoice);
                if (draft == -1) {
                    System.out.println("PASS");
                } else {
                    System.out.println("PICK " + draft);
                }
            } else {
                final List<Card> cardsInHand = getCardsByLocation(allCardsInPlay, 0);
                final List<Card> myCardsOnBoard = getCardsByLocation(allCardsInPlay, 1);
                final List<Card> opponentCardsOnBoard = getCardsByLocation(allCardsInPlay, -1);

                final List<CardAction> summons = summoner.summon(cardsInHand, me.getMana());
                final List<CardAction> attacks = attacker.getAttacks(myCardsOnBoard, opponentCardsOnBoard);

                final ArrayList<CardAction> allActions = new ArrayList<>();
                allActions.addAll(summons);
                allActions.addAll(attacks);

                System.out.println(CardActions.getCardActionStrings(allActions));
            }
        }
    }

    private static List<Card> getCardsByLocation(ArrayList<Card> allCardsInPlay, int location) {
        return allCardsInPlay.stream()
                            .filter(card -> card.getLocation() == location)
                            .collect(Collectors.toList());
    }
}
