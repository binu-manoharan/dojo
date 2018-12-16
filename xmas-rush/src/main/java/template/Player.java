package template;

import cg.board.Board;
import cg.board.Tile;
import cg.element.Item;
import cg.element.Participant;
import cg.element.Quest;
import cg.tree.BreadthFirstTree;

import java.util.*;

/**
 * Help the Christmas elves fetch presents in a magical labyrinth!
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // element loop
        while (true) {
            final long startTime = System.currentTimeMillis();
            int turnType = in.nextInt();
            String[] boardString = new String[7];
            for (int i = 0; i < 7; i++) {
                String tileRow = "";
                for (int j = 0; j < 7; j++) {
                    tileRow+= in.next() + " ";
                }
                boardString[i] = tileRow;
            }
            final Board board = new Board(boardString);
            System.err.println(board);

            final Participant[] participants = new Participant[2];
            for (int i = 0; i < 2; i++) {
                int numPlayerCards = in.nextInt(); // the total number of quests for a player (hidden and revealed)
                int playerX = in.nextInt();
                int playerY = in.nextInt();
                String playerTile = in.next();
                final Tile tile = new Tile((i * -1) - 1, (i * -1) - 1, playerTile);
                participants[i] = new Participant(playerX, playerY, numPlayerCards, tile);
                System.err.println(participants[i]);
            }

            int numItems = in.nextInt(); // the total number of items available on board and on player tiles
            final ArrayList<Item> items = new ArrayList<>();
            for (int i = 0; i < numItems; i++) {
                String itemName = in.next();
                int itemX = in.nextInt();
                int itemY = in.nextInt();
                int itemPlayerId = in.nextInt();
                items.add(new Item(itemPlayerId, itemX, itemY, itemName));
                System.err.println(items.get(i));
            }

            int numQuests = in.nextInt(); // the total number of revealed quests for both players
            final ArrayList<Quest> quests = new ArrayList<>();
            for (int i = 0; i < numQuests; i++) {
                String questItemName = in.next();
                int questPlayerId = in.nextInt();
                quests.add(new Quest(questItemName, questPlayerId));
                System.err.println(quests.get(i));
            }

            final BreadthFirstTree breadthFirstTree = new BreadthFirstTree(board, participants[0], quests, items);
            breadthFirstTree.populateTree(1);
            final long endTime = System.currentTimeMillis();
            System.err.println("Time taken: " + (endTime - startTime));

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            if (turnType == 0)
                System.out.println("PUSH 3 RIGHT"); // PUSH <id> <direction> | MOVE <direction> | PASS
            else
                System.out.println("PASS");
        }
    }
}
