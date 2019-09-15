package cg.tree;

import cg.board.Board;
import cg.element.Item;
import cg.element.Participant;
import cg.element.Quest;
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
        this.rootNode = new Node(new GameState(board, me, availableQuests, items), null, null);
    }

    public void populateTreeFromRootNode(int depth) {
        populateTree(rootNode, depth);
    }

    private void populateTree(Node parentNode, int depth) {
        if (depth <= 0) {
            return;
        }

        final List<PushOperation> allPushOperations = PushOperation.getAllPushOperations();
        for (PushOperation pushOperation : allPushOperations) {
            final GameState gameStateWithPushOperationApplied = new GameState(parentNode.getGameState());
            gameStateWithPushOperationApplied.push(pushOperation.getDirection(), pushOperation.getPushIndex());
            final Node child = new Node(gameStateWithPushOperationApplied, pushOperation, parentNode);


            final boolean isGoodGameState = parentNode.addChild(child);
            updateTreeStateInfo(child, isGoodGameState);
            populateTree(child, depth - 1);
        }
    }

    private void updateTreeStateInfo(Node node, boolean isGood) {
        if (node != null) {
            if (isGood) {
                node.good++;
            } else {
                node.bad++;
            }
            updateTreeStateInfo(node.getParent(), isGood);
        }
    }

    public Node getRootNode() {
        return rootNode;
    }
}
