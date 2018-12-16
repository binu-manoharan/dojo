package cg.operation;

import cg.element.Direction;

/**
 *
 */
public abstract class Operation {
    protected Direction direction;

    public Operation(Direction direction) {
        this.direction = direction;
    }

    @Override
    public abstract String toString();
}
