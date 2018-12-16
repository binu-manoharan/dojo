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
        this.rootNode = new Node(new GameState(board, me, availableQuests, items), null);
    }

    public void populateTree(int depth) {
        if (depth == 0) {
            return;
        }

        final List<PushOperation> allPushOperations = PushOperation.getAllPushOperations();
        for (PushOperation pushOperation : allPushOperations) {
            final GameState node = new GameState(rootNode.getGameState());
            node.push(pushOperation.getDirection(), pushOperation.getPushIndex());
            final Node child = new Node(node, pushOperation);
            rootNode.addChild(child);

            populateTree(--depth);
        }
    }

    public Node getRootNode() {
        return rootNode;
    }
}
