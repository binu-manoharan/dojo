package cg.board;

import cg.element.Direction;
import org.junit.Test;

import java.util.List;

import static cg.element.Direction.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BoardTest {

    @Test
    public void should_create_an_empty_board() throws Exception {
        final String[] tileString = {
            "0000 0000 0000 0000 0000 0000 0000",
            "1111 0000 0000 0000 0000 0000 0000",
            "0000 0000 0000 0000 0000 0000 0000",
            "0000 0000 0000 0000 0000 0000 0000",
            "0000 0000 0000 0000 0000 0000 0000",
            "0000 0000 0000 0000 0000 0000 0000",
            "0000 0000 0000 0000 0000 0000 0000"
        };

        final Tile[][] tiles = new Board(tileString).getTiles();

        for (int columnIndex = 0; columnIndex < 7; columnIndex++) {
            final String[] tilesInRow = tileString[columnIndex].split(" ");
            for (int tilesInRowIndex = 0; tilesInRowIndex < 7; tilesInRowIndex++) {
                final Tile tile = tiles[tilesInRowIndex][columnIndex];
                final List<Direction> movableDirections = tile.getMovableDirections();
                assertDirection(tilesInRow[tilesInRowIndex], movableDirections, 0, UP);
                assertDirection(tilesInRow[tilesInRowIndex], movableDirections, 1, RIGHT);
                assertDirection(tilesInRow[tilesInRowIndex], movableDirections, 2, DOWN);
                assertDirection(tilesInRow[tilesInRowIndex], movableDirections, 3, LEFT);
            }
        }
    }

    private void assertDirection(String tileDirectionString, List<Direction> movableDirections, int charPosition, Direction expectedDirection) {
        if (tileDirectionString.charAt(charPosition) == 1) {
            assertThat("Should be able to move up", movableDirections.contains(expectedDirection), is(true));
        }
    }
}
