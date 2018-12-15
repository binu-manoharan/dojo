package cg.board;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TileTest {
    @Test
    public void should_have_expected_to_string_methods() throws Exception {
        final Tile tile = new Tile(0, 0, false, false, false, false);
        assertThat("Tile should have to string", tile.toString(), is("|     |"));

        tile.setUp(true);
        assertThat("Tile should have to string", tile.toString(), is("|^    |"));

        tile.setDown(true);
        assertThat("Tile should have to string", tile.toString(), is("|^ v  |"));


        tile.setRight(true);
        assertThat("Tile should have to string", tile.toString(), is("|^>v  |"));

        tile.setLeft(true);
        assertThat("Tile should have to string", tile.toString(), is("|^>v< |"));
    }

}
