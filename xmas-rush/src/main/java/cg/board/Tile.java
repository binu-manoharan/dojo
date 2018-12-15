package cg.board;

import cg.element.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * Single tile on a board. In a element there are 51 tiles, 49 on the board and 2 in player hand.
 */
public class Tile {
    private int x;
    private int y;
    private final String movableDirections;

    public Tile(int x, int y, String movableDirections) {
        this.x = x;
        this.y = y;
        this.movableDirections = movableDirections;
    }

    @Override
    public String toString() {
        return movableDirections;
    }

    public List<Direction> getMovableDirections() {
        final ArrayList<Direction> directions = new ArrayList<>();
        if (this.movableDirections.charAt(0) == '1') {
            directions.add(Direction.UP);
        }

        if (this.movableDirections.charAt(1) == '1') {
            directions.add(Direction.RIGHT);
        }

        if (this.movableDirections.charAt(2) == '1') {
            directions.add(Direction.DOWN);
        }

        if (this.movableDirections.charAt(3) == '1') {
            directions.add(Direction.LEFT);
        }

        return directions;
    }
}
