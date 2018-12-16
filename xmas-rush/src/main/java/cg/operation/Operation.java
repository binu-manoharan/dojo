package cg.operation;

import cg.element.Direction;

/**
 *
 */
public abstract class Operation {
    protected final Direction direction;

    public Operation(Direction direction) {
        this.direction = direction;
    }

    @Override
    public abstract String toString();
}
