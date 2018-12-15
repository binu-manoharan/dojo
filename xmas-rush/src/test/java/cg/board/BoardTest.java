package cg.board;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BoardTest {

    @Test
    public void showBoard() throws Exception {
        final Board board = new Board();
        board.initBoard();
        assertThat("Matches expected toString()", board.toString(), is(
                "|^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< |\n" +
                "|^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< |\n" +
                "|^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< |\n" +
                "|^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< |\n" +
                "|^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< |\n" +
                "|^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< |\n" +
                "|^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< ||^>v< |\n"
        ));
    }

}
