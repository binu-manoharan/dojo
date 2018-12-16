package cg.tree;

import cg.board.Tile;
import cg.element.Item;
import cg.element.Participant;
import cg.element.Quest;
import org.junit.Test;

import java.util.List;

import static cg.helper.TestUtils.getEmptyBoard;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BreadthFirstTreeTest {
    @Test
    public void should_populate_tree() throws Exception {
        final Tile myTile = new Tile(-1, -1, "0000");
        final Participant me = new Participant(0, 0, 1, myTile);
        final BreadthFirstTree breadthFirstTree = new BreadthFirstTree(getEmptyBoard(), me, emptyList(), emptyList());
        breadthFirstTree.populateTreeFromRootNode(1);

        final Node rootNode = breadthFirstTree.getRootNode();
        final List<Node> children = rootNode.getChildren();
        assertThat(children.size(), is(28));
    }

    @Test
    public void should_have_28_push_operation_children() throws Exception {
        final Tile myTile = new Tile(-1, -1, "1111");
        final Participant me = new Participant(0, 0, 1, myTile);
        final List<Quest> quests = singletonList(new Quest("DIAMOND", 0));
        final List<Item> items = singletonList(new Item(0, -1, -1, "DIAMOND"));

        final BreadthFirstTree breadthFirstTree = new BreadthFirstTree(getEmptyBoard(), me, quests, items);
        breadthFirstTree.populateTreeFromRootNode(2);
        final List<Node> children = breadthFirstTree.getRootNode().getChildren();
        assertThat(children.size(), is(28));
    }
}
