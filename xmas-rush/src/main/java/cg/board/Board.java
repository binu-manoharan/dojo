package cg.board;

import cg.element.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * Game 7x7 board for xmas rush
 */
public class Board {
    private Tile[][] tiles = new Tile[7][7];

    public Board(Board board) {
        final Tile[][] tiles = board.getTiles();
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                this.tiles[x][y] = new Tile(tiles[x][y]);
            }
        }
    }

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
                boardString += tiles[x][y].toString() + " ";
            }
            boardString += "\n";
        }
        return boardString;
    }

    public Tile push(Tile tileInHand, Direction direction, int pushIndex) {
        Tile newTileInHand = null;
        switch (direction) {
            case DOWN:
                newTileInHand = new Tile(tiles[pushIndex][6]);
                for (int i = 6; i > 0; i--) {
                    tiles[pushIndex][i] = tiles[pushIndex][i - 1];
                }
                tiles[pushIndex][0] =  new Tile(pushIndex, 0, tileInHand.getMovableDirectionsString());
                break;
            case UP:
                newTileInHand = new Tile(tiles[pushIndex][0]);
                for (int i = 0; i < 6; i++) {
                    tiles[pushIndex][i] = tiles[pushIndex][i + 1];
                }
                tiles[pushIndex][6] = new Tile(pushIndex, 6, tileInHand.getMovableDirectionsString());
                break;
            case RIGHT:
                newTileInHand = new Tile(tiles[6][pushIndex]);
                for (int i = 6; i > 0; i--) {
                    tiles[i][pushIndex] = tiles[i - 1][pushIndex];
                }
                tiles[0][pushIndex] =  new Tile(0, pushIndex, tileInHand.getMovableDirectionsString());
                break;
            case LEFT:
                newTileInHand = new Tile(tiles[0][pushIndex]);
                for (int i = 0; i < 6; i++) {
                    tiles[i][pushIndex] = tiles[i + 1][pushIndex];
                }
                tiles[6][pushIndex] = new Tile(6, pushIndex, tileInHand.getMovableDirectionsString());
                break;
        }

        return newTileInHand;
    }

    public List<Tile> getConnectedAdjacentTiles(int x, int y) {
        final List<Direction> movableDirections = tiles[x][y].getMovableDirections();
        final ArrayList<Tile> connectedTiles = new ArrayList<>();
        if (movableDirections.contains(Direction.UP) && y > 0) {
            connectedTiles.add(tiles[x][y - 1]);
        }
        if (movableDirections.contains(Direction.DOWN) && y < 6) {
            connectedTiles.add(tiles[x][y + 1]);
        }
        if (movableDirections.contains(Direction.RIGHT) && x < 6) {
            connectedTiles.add(tiles[x + 1][y]);
        }
        if (movableDirections.contains(Direction.LEFT) && x > 0) {
            connectedTiles.add(tiles[x - 1][y]);
        }

        return connectedTiles;
    }

}
