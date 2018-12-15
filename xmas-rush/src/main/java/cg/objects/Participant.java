package cg.objects;

import cg.board.Tile;

/**
 * Player on the board
 */
public class Participant {
    int x,y;
    int numAvailableQuests;
    Tile tileInHand;

    public Participant(int x, int y, int numAvailableQuests, Tile tileInHand) {
        this.x = x;
        this.y = y;
        this.numAvailableQuests = numAvailableQuests;
        this.tileInHand = tileInHand;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "x=" + x +
                ", y=" + y +
                ", numAvailableQuests=" + numAvailableQuests +
                ", tileInHand=" + tileInHand +
                '}';
    }
}
