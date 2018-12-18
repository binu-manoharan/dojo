package cg.board;

import cg.element.Direction;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static cg.element.Direction.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TileTest {
    @Test
    public void should_have_no_movable_directions() throws Exception {
        final Tile tile = new Tile(0, 0, "0000");
        final List<Direction> directions = tile.getMovableDirections();
        assertThat("Tile should have expected directions", directions, is(Collections.emptyList()));
    }

    @Test
    public void should_have_up_as_a_movable_directions() throws Exception {
        runSingleDirectionTest("1000", UP);
    }

    @Test
    public void should_have_right_as_a_movable_directions() throws Exception {
        runSingleDirectionTest("0100", RIGHT);
    }

    @Test
    public void should_have_down_as_a_movable_directions() throws Exception {
        runSingleDirectionTest("0010", DOWN);
    }

    @Test
    public void should_have_left_as_a_movable_directions() throws Exception {
        runSingleDirectionTest("0001", LEFT);
    }

    @Test
    public void should_have_all_movable_directions() throws Exception {
        final Tile tile = new Tile(0, 0, "1111");
        final List<Direction> directions = tile.getMovableDirections();
        assertThat("Tile should have expected direction", directions.get(0), is(UP));
        assertThat("Tile should have expected direction", directions.get(1), is(RIGHT));
        assertThat("Tile should have expected direction", directions.get(2), is(DOWN));
        assertThat("Tile should have expected direction", directions.get(3), is(LEFT));
    }

    private void runSingleDirectionTest(String directionString, Direction expectedDirection) {
        final Tile tile = new Tile(0, 0, directionString);
        final List<Direction> directions = tile.getMovableDirections();
        assertThat("Tile should have expected direction", directions.get(0), is(expectedDirection));
    }
}
