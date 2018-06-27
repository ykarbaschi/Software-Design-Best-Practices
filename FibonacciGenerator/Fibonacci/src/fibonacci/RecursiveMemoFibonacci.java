package fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class RecursiveMemoFibonacci extends RecursiveFibonacci {
    Map<Integer, BigInteger> calculatedFibonacci;

    public RecursiveMemoFibonacci() {
        calculatedFibonacci = new HashMap<>();
        calculatedFibonacci.put(0, BigInteger.ONE);
        calculatedFibonacci.put(1, BigInteger.ONE);
    }

    @Override
    public BigInteger calculate(int position) {

        if(!calculatedFibonacci.containsKey(position))
            return calculatedFibonacci.compute(position,(integer, bigInteger) -> super.calculate(position));

        return calculatedFibonacci.get(position);

    }
}
