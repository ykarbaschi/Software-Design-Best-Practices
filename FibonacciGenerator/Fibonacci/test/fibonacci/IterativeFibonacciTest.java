package fibonacci;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IterativeFibonacciTest extends FibonacciTest {

    @Test
    public void canary() {
        assertTrue(true);
    }

    public Fibonacci createInstanceOfFibonacci() {
        return new IterativeFibonacci();
    }
}