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
    private final String movableDirections;
    private final ArrayList<Direction> directions;

    public Tile(Tile tile) {
        x = tile.x;
        y = tile.y;
        movableDirections = tile.movableDirections;
        directions = new ArrayList<>(tile.directions);
    }

    public Tile(int x, int y, String movableDirections) {
        this.x = x;
        this.y = y;
        this.movableDirections = movableDirections;

        directions = new ArrayList<>();
        if (movableDirections.charAt(0) == '1') {
            directions.add(Direction.UP);
        }

        if (movableDirections.charAt(1) == '1') {
            directions.add(Direction.RIGHT);
        }

        if (movableDirections.charAt(2) == '1') {
            directions.add(Direction.DOWN);
        }

        if (movableDirections.charAt(3) == '1') {
            directions.add(Direction.LEFT);
        }
    }

    @Override
    public String toString() {
        return movableDirections;
    }

    public List<Direction> getMovableDirections() {
        return directions;
    }
}
