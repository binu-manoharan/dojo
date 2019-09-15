package cg.helper;

import cg.board.Board;

/**
 * Helper class for test methods
 */
public class TestUtils {
    public static Board getEmptyBoard() {
        String[] tileStrings = {
            "0000 0000 0000 0000 0000 0000 0000",
            "0000 0000 0000 0000 0000 0000 0000",
            "0000 0000 0000 0000 0000 0000 0000",
            "0000 0000 0000 0000 0000 0000 0000",
            "0000 0000 0000 0000 0000 0000 0000",
            "0000 0000 0000 0000 0000 0000 0000",
            "0000 0000 0000 0000 0000 0000 0000"
        };

        return new Board(tileStrings);
    }
}
