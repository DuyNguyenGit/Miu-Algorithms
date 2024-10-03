**Apply Master Theorem and determine the time complexity of
fib(n) shown in Lesson 2**

public int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

The recurrence relation for this Fibonacci algorithm is: 
T(n)=T(n−1)+T(n−2)+O(1) 
This recurrence is not in the form required by the Master Theorem because it does not 
divide the problem into smaller subproblems of equal size. Instead, it makes two 
recursive calls with different problem sizes: one for n-1 and one for n-2. 
Therefore, the Master Theorem does not apply to this recurrence because the subproblem 
sizes are not divided by a constant factor (n/b). The Master Theorem only applies to 
recurrences that are of the form 
T(n)=aT(n/b)+O(n^d ), where subproblems are reduced by a constant factor > 1.