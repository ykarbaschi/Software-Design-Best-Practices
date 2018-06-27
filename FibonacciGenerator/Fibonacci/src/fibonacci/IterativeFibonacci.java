package fibonacci;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static java.math.BigInteger.ONE;

public class IterativeFibonacci implements Fibonacci{

    public BigInteger calculate(int position) {
        if (position < 0)
            throw new IllegalArgumentException("Enter a positive number.");

        return IntStream.rangeClosed(2, position)
                        .mapToObj(i -> new BigInteger[]{})
                        .reduce(new BigInteger[]{ONE, ONE}, this::computeNext)[1];
    }

    public BigInteger[] computeNext(BigInteger[] pair, BigInteger[] ignore) {
        return new BigInteger[]{pair[1], pair[0].add(pair[1])};
    }
}
