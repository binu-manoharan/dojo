package cg.binu.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {

            int playerHealth1 = in.nextInt();
            int playerMana1 = in.nextInt();
            int playerDeck1 = in.nextInt();
            int playerRune1 = in.nextInt();

            int playerHealth2 = in.nextInt();
            int playerMana2 = in.nextInt();
            int playerDeck2 = in.nextInt();
            int playerRune2 = in.nextInt();

            int opponentHand = in.nextInt();
            int cardCount = in.nextInt();

            List<Card> allCardsInPlay = new ArrayList<>();
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
                allCardsInPlay.add(new Card(cardNumber, instanceId, location, cardType, cost, attack, defense, abilities, myHealthChange, opponentHealthChange, cardDraw));
            }
            final Action action = new SummonCreatures();
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            action.generateMovesForThisTurn(allCardsInPlay, playerMana1);
            System.out.println(action.toString());
        }
    }
}
