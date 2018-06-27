package fibonacci;

import java.math.BigInteger;

public class RecursiveFibonacci implements Fibonacci {

    public BigInteger calculate(int position) {
        if (position < 0)
            throw new IllegalArgumentException("Enter a positive number.");

        if (position < 2)
            return BigInteger.ONE;

        return calculate(position - 1).add(calculate(position - 2));
    }
}