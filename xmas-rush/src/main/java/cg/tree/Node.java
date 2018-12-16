package cg.tree;

import cg.board.Board;
import cg.element.Item;
import cg.element.Participant;
import cg.element.Quest;
import cg.operation.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * A single node in the tree representing the game state and the last action taken
 * to get into this game state.
 */
public class Node {
    private final GameState gameState;
    private final Operation operation;
    private final Node parent;
    private final List<Node> children = new ArrayList<>();
    int good, bad = 0;

    public Node(GameState gameState, Operation operation, Node parent) {
        this.gameState = new GameState(gameState);
        this.operation = operation;
        this.parent = parent;
    }

    public boolean addChild(Node child) {
        children.add(child);
        return child.isGoodGameState();
    }

    public boolean isGoodGameState() {
        final Board board = gameState.getBoard();
        final Participant me = gameState.getMe();
        final List<Item> items = gameState.getItems();
        final List<Quest> availableQuests = gameState.getAvailableQuests();
        boolean isGood = false;

        for (Quest availableQuest : availableQuests) {
            final String questItemName = availableQuest.getItemName();
            for (Item item : items) {
                final String itemName = item.getName();
                if (itemName.equals(questItemName)) {
                    final boolean connected = PathHelper.isConnected(board, me.getX(), me.getY(), item.getX(), item.getY());
                    if (connected) {
                        isGood = true;
                        break;
                    }
                }
            }
        }

        return isGood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        if (!gameState.equals(node.gameState)) return false;
        return operation != null ? operation.equals(node.operation) : node.operation == null;

    }

    @Override
    public int hashCode() {
        int result = gameState.hashCode();
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Operation getOperation() {
        return operation;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }
}
