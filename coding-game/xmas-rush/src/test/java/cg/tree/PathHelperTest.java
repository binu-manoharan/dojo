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
    public void path_between_1_0_and_0_5_should_not_be_connected() throws Exception {
        final String[] tileString = {
                "0110 0110 1010 0000 0000 0000 0000",
                "0101 1001 1110 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000",
                "0000 0000 0000 0000 0000 0000 0000"
        };

        final Board board = new Board(tileString);

        final boolean connected = PathHelper.isConnected(board, 1, 0, 0, 5);
        assertThat(connected, is(false));
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
                "0110 1101 1111 1010 1110 0111 1010",
                "1001 1010 1001 1101 1011 0110 1101",
                "1001 1011 1011 0011 1010 1010 1100",
                "1101 0011 1010 1010 1110 1100 0111",
                "0011 1010 1110 1100 0110 1110 0110",
                "0111 1001 1011 0111 1111 1010 0110",
                "1010 1101 1010 1010 1100 0111 1001"
        };

        final Board board = new Board(tileString);

        final boolean connected = PathHelper.isConnected(board, 0, 0, 3, 5);
        assertThat(connected, is(false));
    }
}
