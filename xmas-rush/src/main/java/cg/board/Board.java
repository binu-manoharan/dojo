package cg.board;

public class Board {
    private Tile[][] tiles = new Tile[7][7];

    public void initBoard() {
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                tiles[x][y] = new Tile(x, y, true, true, true, true);
            }
        }
    }

    @Override
    public String toString() {
        String boardString = "";
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                boardString += tiles[x][y].toString();
            }
            boardString += "\n";
        }
        return boardString;
    }
}
