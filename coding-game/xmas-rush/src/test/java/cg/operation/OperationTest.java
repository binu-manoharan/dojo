package cg.operation;

import cg.element.Direction;
import org.junit.Test;

import static cg.element.Direction.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OperationTest {
    @Test
    public void should_have_the_correct_output_message_for_move() throws Exception {
        runMoveTest(LEFT, "MOVE LEFT");
        runMoveTest(RIGHT, "MOVE RIGHT");
        runMoveTest(UP, "MOVE UP");
        runMoveTest(DOWN, "MOVE DOWN");
    }

    private void runMoveTest(Direction direction, String expectedMessage) {
        final Operation moveOperation = new MoveOperation(direction);
        assertThat(moveOperation.toString(),  is(expectedMessage));
    }

    @Test
    public void should_have_the_correct_output_message_for_push() throws Exception {
        runPushTest(0, LEFT, "PUSH 0 LEFT");
        runPushTest(1, RIGHT, "PUSH 1 RIGHT");
        runPushTest(2, UP, "PUSH 2 UP");
        runPushTest(3, DOWN, "PUSH 3 DOWN");
    }

    private void runPushTest(int id, Direction direction, String expectedMessage) {
        final Operation pushOperation = new PushOperation(id, direction);
        assertThat(pushOperation.toString(),  is(expectedMessage));
    }
}
