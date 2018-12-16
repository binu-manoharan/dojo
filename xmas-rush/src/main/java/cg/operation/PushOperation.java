package cg.operation;

import cg.element.Direction;

/**
 * A push action on the board
 */
public class PushOperation extends Operation {
    int id;

    public PushOperation(int id, Direction direction) {
        super(direction);
        this.id = id;
    }

    @Override
    public String toString() {
        return "PUSH " + id + " " + direction;
    }
}
