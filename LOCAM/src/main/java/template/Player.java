package template;

import cg.binu.draft.DraftChoice;
import cg.binu.draft.Drafter;
import cg.binu.draft.MaxValueDrafter;
import cg.binu.input.Card;
import cg.binu.input.CardType;
import cg.binu.input.Hero;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        final Drafter drafter = new MaxValueDrafter();
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

                final Card card = new Card(cardNumber, instanceId, location, CardType.CREATURES, cost, attack, defense, abilities, myHealthChange, opponentHealthChange, cardDraw);
                allCardsInPlay.add(card);
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            if (draftingPhase) {
                final DraftChoice draftChoice = new DraftChoice(allCardsInPlay);
                final int draft = drafter.draft(draftChoice);

                System.out.println("PICK " + draft);
            } else {
                System.out.println("PASS");
            }
        }
    }
}
