package algorithms.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    /**
     * compute nth fib number
     * its complexity is O(2^n/2)
     *
     * f(n) = 8(f(n-8))
     */
    static int fib_rec(int n) {
        int f;
        if (n <= 1) {
            f = n;
        } else {
            f = fib_rec(n - 1) + fib_rec(n - 2);
        }
        return f;
    }



    static Map<Integer, Integer> memo = new HashMap<>();

    static int fib_memo(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int f;
        if (n <= 1) {
            f = n;
        } else {
            f = fib_memo(n - 1) + fib_memo(n - 2);
        }
        memo.put(n, f);
        return f;
    }

    static int fib_bu(int n) {
        int[] fib = new int[n+1];
        int f;
        for(int i = 0; i <= n; i++) {
            if (i <= 1) {
                f = i;
            } else {
                f = fib[i-1] + fib[i-2];
            }
            fib[i] = f;
        }
        return fib[n];
    }

    static int fib_bu2(int n) {
        int a = 0, b = 1;
        int f = 0;
        for(int i = 0; i <= n; i++) {
            if (i <= 1) {
                f = i;
            } else {
                f = a + b;
            }
            a = b;
            b = f;
        }
        return f;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

//        System.out.println(fib_rec(45));
//        System.out.println(fib_memo(45));
//        System.out.println(fib_bu(45));
        System.out.println(fib_bu2(45));

        System.out.println(System.currentTimeMillis() - start);
    }
}
