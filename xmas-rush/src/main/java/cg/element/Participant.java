package cg.element;

import cg.board.Tile;

/**
 * Player on the board
 */
public class Participant {
    private final int x,y;
    private final int numAvailableQuests;
    private Tile tileInHand;

    public Participant(Participant participant) {
        x = participant.x;
        y = participant.y;
        numAvailableQuests = participant.numAvailableQuests;
        tileInHand = participant.tileInHand;
    }

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumAvailableQuests() {
        return numAvailableQuests;
    }

    public Tile getTileInHand() {
        return tileInHand;
    }

    public void setTileInHand(Tile tileInHand) {
        this.tileInHand = tileInHand;
    }
}
