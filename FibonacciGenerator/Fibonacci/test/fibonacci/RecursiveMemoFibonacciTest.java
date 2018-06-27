package fibonacci;

public class RecursiveMemoFibonacciTest extends FibonacciTest {
    @Override
    public Fibonacci createInstanceOfFibonacci() {
        return new RecursiveMemoFibonacci();
    }
}
