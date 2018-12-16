package cg.operation;

import cg.element.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * A push action on the board
 */
public class PushOperation extends Operation {
    private final int pushIndex;

    public PushOperation(int pushIndex, Direction direction) {
        super(direction);
        this.pushIndex = pushIndex;
    }

    @Override
    public String toString() {
        return "PUSH " + pushIndex + " " + direction;
    }

    public static List<PushOperation> getAllPushOperations() {
        final ArrayList<PushOperation> operations = new ArrayList<>();
        final Direction[] values = Direction.values();
        for (int id = 0; id < 7; id++) {
            for (int i = 0; i < values.length; i++) {
                operations.add(new PushOperation(id, values[i]));
            }
        }

        return operations;
    }

    public int getPushIndex() {
        return pushIndex;
    }
}
