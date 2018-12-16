package cg.board;

import cg.element.Direction;
import cg.helper.TestUtils;
import org.junit.Test;

import java.util.List;

import static cg.element.Direction.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BoardTest {

    @Test
    public void should_create_a_board() throws Exception {
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

    @Test
    public void should_push_tile_down() throws Exception {
        final Board board = TestUtils.getEmptyBoard();
        final Tile tileInHand = new Tile(-1, -1, "1111");
        final Tile newTileInHand = board.push(tileInHand, DOWN, 0);
        final Tile[][] tiles = board.getTiles();

        assertThat(newTileInHand.toString(), is("0000"));
        final Tile tile = tiles[0][0];
        assertTile(tile, 0, 0);
    }

    @Test
    public void should_push_tile_up() throws Exception {
        final Board board = TestUtils.getEmptyBoard();
        final Tile tileInHand = new Tile(-1, -1, "1111");
        final Tile newTileInHand = board.push(tileInHand, UP, 1);
        final Tile[][] tiles = board.getTiles();

        assertThat(newTileInHand.toString(), is("0000"));
        final Tile tile = tiles[1][6];
        assertTile(tile, 1, 6);
    }

    @Test
    public void should_push_tile_right() throws Exception {
        final Board board = TestUtils.getEmptyBoard();
        final Tile tileInHand = new Tile(-1, -1, "1111");
        final Tile newTileInHand = board.push(tileInHand, RIGHT, 2);
        final Tile[][] tiles = board.getTiles();

        assertThat(newTileInHand.toString(), is("0000"));
        final Tile tile = tiles[0][2];
        assertTile(tile, 0, 2);
    }

    @Test
    public void should_push_tile_left() throws Exception {
        final Board board = TestUtils.getEmptyBoard();
        final Tile tileInHand = new Tile(-1, -1, "1111");
        final Tile newTileInHand = board.push(tileInHand, LEFT, 3);
        final Tile[][] tiles = board.getTiles();

        assertThat(newTileInHand.toString(), is("0000"));
        final Tile tile = tiles[6][3];
        assertTile(tile, 6, 3);
    }

    private void assertTile(Tile tile, int x, int y) {
        assertThat(tile.getX(), is(x));
        assertThat(tile.getY(), is(y));
        assertThat(tile.getMovableDirectionsString(), is("1111"));
    }

    private void assertDirection(String tileDirectionString, List<Direction> movableDirections, int charPosition, Direction expectedDirection) {
        if (tileDirectionString.charAt(charPosition) == 1) {
            assertThat("Should be able to move up", movableDirections.contains(expectedDirection), is(true));
        }
    }
}
