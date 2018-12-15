package cg.board;

/**
 * Game 7x7 board for xmas rush
 */
public class Board {
    private Tile[][] tiles = new Tile[7][7];

    public Board(String[] tileString) {
        assert tileString.length == 7;

        for (int y = 0; y < 7; y++) {
            final String[] tilesInRow = tileString[y].split(" ");
            for (int x = 0; x < 7; x++) {
                this.tiles[x][y] = new Tile(x, y, tilesInRow[x]);
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    @Override
    public String toString() {
        String boardString = "";
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                boardString += tiles[x][y].toString();
            }
            boardString += "\n";
        }
        return boardString;
    }
}
