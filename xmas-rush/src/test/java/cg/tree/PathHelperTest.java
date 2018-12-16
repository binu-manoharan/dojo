package cg.tree;

import cg.board.Board;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PathHelperTest {
    @Test
    public void path_between_0_0_and_1_1_should_be_connected() throws Exception {
        final String[] tileString = {
                "1111 0011 0000 0000 0000 0000 0000",
                "0000 1111 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000"
        };

        final Board board = new Board(tileString);

        final boolean connected = PathHelper.isConnected(board, 0, 0, 1, 1);
        assertThat(connected, is(true));
    }

    @Test
    public void path_between_0_0_and_0_2_should_not_be_connected() throws Exception {
        final String[] tileString = {
                "1111 0011 0000 0000 0000 0000 0000",
                "0000 1111 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000"
        };

        final Board board = new Board(tileString);

        final boolean connected = PathHelper.isConnected(board, 0, 0, 0, 2);
        assertThat(connected, is(false));
    }

    @Test
    public void path_between_0_0_and_1_1_should_not_be_connected() throws Exception {
        final String[] tileString = {
                "1111 1110 0000 0000 0000 0000 0000",
                "0000 1111 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000"
        };

        final Board board = new Board(tileString);

        final boolean connected = PathHelper.isConnected(board, 0, 0, 1, 1);
        assertThat(connected, is(false));
    }
}
