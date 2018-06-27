package fibonacci;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static org.junit.Assert.assertEquals;

public abstract class FibonacciTest {
    private Fibonacci fibonacci;

    public abstract Fibonacci createInstanceOfFibonacci();

    @Before
    public void setUp() {
        fibonacci = createInstanceOfFibonacci();
    }

    @Test
    public void calculateMethodReturnsOneForInputNumber0() {
        assertEquals(ONE, fibonacci.calculate(0));
    }

    @Test
    public void calculateMethodReturnsOneForInputNumber1() {
        assertEquals(ONE, fibonacci.calculate(1));
    }

    @Test
    public void calculateMethodReturnsRightErrorForNegativeInput() {
        try {
            fibonacci.calculate(-1);
        } catch (IllegalArgumentException e) {
            assertEquals("Enter a positive number.", e.getMessage());
        }
    }

    @Test
    public void calculateMethodReturnsCorrectResultForInput2() {
        assertEquals(new BigInteger("2"), fibonacci.calculate(2));
    }

    @Test
    public void calculateMethodReturnsCorrectResultForInput3() {
        assertEquals(new BigInteger("3"), fibonacci.calculate(3));
    }

    @Test
    public void calculateMethodReturnsCorrectResultForInput4() {
        assertEquals(new BigInteger("5"), fibonacci.calculate(4));
    }

    @Test
    public void calculateMethodReturnsCorrectResultForInput6() {
        assertEquals(new BigInteger("13"), fibonacci.calculate(6));
    }
}

