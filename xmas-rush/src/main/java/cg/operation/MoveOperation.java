package cg.operation;

import cg.element.Direction;

/**
 * Move operation on the board
 */
public class MoveOperation extends Operation{
    public MoveOperation(Direction direction) {
        super(direction);
    }

    @Override
    public String toString() {
        return "MOVE " + direction;
    }
}
