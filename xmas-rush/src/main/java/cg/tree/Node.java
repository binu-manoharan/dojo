package cg.tree;

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
    private final List<Node> children = new ArrayList<>();

    public Node(GameState gameState, Operation operation) {
        this.gameState = new GameState(gameState);
        this.operation = operation;
    }

    public void addChild(Node child) {
        children.add(child);
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
}
