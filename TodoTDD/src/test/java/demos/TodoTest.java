package demos;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TodoTest {
    @Test
    public void markCompete() {
        Todo todo = new Todo(1L, "Complete me!");

        todo.markComplete();

        assertTrue(todo.isCompete());
    }
}
