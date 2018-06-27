# Fibonacci Generator

In this project, we will create three versions of code to compute the Fibonacci number. Given a number greater than or equal to 0, the Fibonacci number for that number is the value at that given number as the position in the series 1, 1, 2, 3, 5, 8, 13, 21,... In other words, the value at a position is equal to the sum of values at previous two positions. The first two positions, 0 and 1, have the values 1 and 1, respectively. The value as position 5, for example, is 8.

The three versions we will implement are:

1. __Iterative solution__. Use a loop to compute the value at a given position.

2. __Recursive solution__. Use a recursion to compute the value at a given position.

3. Use recursive solution with memoization. Memoization uses caching technique to store the value computed already. If the value that was computed is asked for once again, the cached value is returned instead of being computed.

Write the three versions, one at a time, using test-first approach. Also, write a test that compares the speed of the memoized version with the recursive version to verify that one is faster than the other by at least an order of magnitude.