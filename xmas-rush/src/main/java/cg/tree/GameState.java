package cg.tree;

import cg.board.Board;
import cg.board.Tile;
import cg.element.Direction;
import cg.element.Item;
import cg.element.Participant;
import cg.element.Quest;

import java.util.ArrayList;
import java.util.List;

/**
 * State of the element at a given point.
 */
public class GameState {
    private final Board board;
    private final Participant me;
    private final List<Quest> availableQuests;
    private final List<Item> items;

    public GameState(GameState gameState) {
        board = new Board(gameState.board);
        me = new Participant(gameState.me);
        availableQuests = new ArrayList<>(gameState.availableQuests);
        items = new ArrayList<>(gameState.items);
    }

    public GameState(Board board, Participant me, List<Quest> availableQuests, List<Item> items) {
        this.board = new Board(board);
        this.me = new Participant(me);
        this.availableQuests = new ArrayList<>(availableQuests);
        this.items = new ArrayList<>(items);
    }

    public void push(Direction direction, int pushIndex) {
        System.err.println(direction + " " + pushIndex);
        final Tile tileInHand = me.getTileInHand();
        System.err.println(tileInHand.getX() + " " + tileInHand.getY() + " " + tileInHand);
        final Tile newTile = this.board.push(tileInHand, direction, pushIndex);
        me.setTileInHand(newTile);
    }

    public Board getBoard() {
        return board;
    }

    public Participant getMe() {
        return me;
    }

    public List<Quest> getAvailableQuests() {
        return availableQuests;
    }

    public List<Item> getItems() {
        return items;
    }
}
