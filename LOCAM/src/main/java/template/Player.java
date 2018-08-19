package template;

import cg.binu.input.Hero;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

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

            int opponentHand = in.nextInt();
            int cardCount = in.nextInt();
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
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println("PASS");
        }
    }
}
