package cg.tree;

import cg.board.Board;
import cg.element.Item;
import cg.element.Participant;
import cg.element.Quest;
import cg.operation.Operation;
import cg.operation.PushOperation;

import java.util.List;

/**
 * Perform a action tree for my a board
 */
public class BreadthFirstTree {
    private final Node rootNode;

    public BreadthFirstTree(
            Board board,
            Participant me,
            List<Quest> availableQuests,
            List<Item> items)
    {
        this.rootNode = new Node(new GameState(board, me, availableQuests, items), null);
    }

    public void populateTree() {
        final List<Operation> allPushOperations = PushOperation.getAllPushOperations();
        for (Operation allPushOperation : allPushOperations) {
            final GameState gameState = rootNode.getGameState(); // TODO apply push operation on this game state
            final Node child = new Node(gameState, allPushOperation);
            rootNode.addChild(child);
        }
    }

    public Node getRootNode() {
        return rootNode;
    }
}
