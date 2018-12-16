package cg.tree;

import cg.board.Board;
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
}
