package cg.operation;

import cg.element.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * A push action on the board
 */
public class PushOperation extends Operation {
    private final int id;

    public PushOperation(int id, Direction direction) {
        super(direction);
        this.id = id;
    }

    @Override
    public String toString() {
        return "PUSH " + id + " " + direction;
    }

    public static List<Operation> getAllPushOperations() {
        final ArrayList<Operation> operations = new ArrayList<>();
        final Direction[] values = Direction.values();
        for (int id = 0; id < 7; id++) {
            for (int i = 0; i < values.length; i++) {
                operations.add(new PushOperation(id, values[i]));
            }
        }

        return operations;
    }
}
