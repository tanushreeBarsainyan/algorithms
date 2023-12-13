package src;

import java.util.HashMap;

public class Fibonacci {
    static HashMap<Integer, Integer> computedFib = new HashMap<>();

    public static int fiboRecursion(int n) {
        if (n <= 2) {
            return 1;
        }
        return fiboRecursion(n - 1) + fiboRecursion(n - 2);
    }

    public static int fibRecursionWithMap(int n) {
        computedFib.put(1, 1);
        computedFib.put(2, 1);
        if (n > 2) {
            computedFib.put(n, (fibRecursionWithMap(n - 1) + fibRecursionWithMap(n - 2)));
        }
        return computedFib.get(n);
    }

    public static int fibRecursionWithArray(int n) {
        int[] fibArray = new int[n];
        fibArray[0] = 1;
        fibArray[1] = 1;
        for (int i = 2; i < n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray[n - 1];
    }

    public static int fibRecursionWithDP(int n) {
        int curr = 1;
        int prev = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = curr + prev;
            prev = curr;
            curr = result;
        }
        return curr;
    }
}
