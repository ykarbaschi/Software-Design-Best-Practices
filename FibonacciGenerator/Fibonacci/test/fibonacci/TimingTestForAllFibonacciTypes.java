package fibonacci;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TimingTestForAllFibonacciTypes {

     @Test
     public void compareTimingsForCalculatingPosition30() {
       long recursiveTime = computeTime(new RecursiveFibonacci());
       long memoizedTime = computeTime(new RecursiveMemoFibonacci());

       assertTrue(memoizedTime * 10 < recursiveTime);
     }

     private long computeTime(Fibonacci fibonacci) {
       long start = System.nanoTime();
       fibonacci.calculate(40);
       return System.nanoTime() - start;
     }
}
