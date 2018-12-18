package cg.board;

import cg.element.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * Single tile on a board. In a element there are 51 tiles, 49 on the board and 2 in player hand.
 */
public class Tile {
    private final int x;
    private final int y;
    private final String movableDirectionsString;
    private final ArrayList<Direction> movableDirections;

    public Tile(Tile tile) {
        x = tile.x;
        y = tile.y;
        movableDirectionsString = tile.movableDirectionsString;
        movableDirections = new ArrayList<>(tile.movableDirections);
    }

    public Tile(int x, int y, String movableDirectionsString) {
        this.x = x;
        this.y = y;
        this.movableDirectionsString = movableDirectionsString;

        movableDirections = new ArrayList<>();
        if (movableDirectionsString.charAt(0) == '1') {
            movableDirections.add(Direction.UP);
        }

        if (movableDirectionsString.charAt(1) == '1') {
            movableDirections.add(Direction.RIGHT);
        }

        if (movableDirectionsString.charAt(2) == '1') {
            movableDirections.add(Direction.DOWN);
        }

        if (movableDirectionsString.charAt(3) == '1') {
            movableDirections.add(Direction.LEFT);
        }
    }

    @Override
    public String toString() {
        return movableDirectionsString;
    }

    public List<Direction> getMovableDirections() {
        return movableDirections;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getMovableDirectionsString() {
        return movableDirectionsString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tile)) return false;

        Tile tile = (Tile) o;

        if (x != tile.x) return false;
        return y == tile.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
