package algo.leetcode.dp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Fib {

    public static long fib(int n) {
        Map<Integer, Long> mem = new HashMap<>();
        return fibAux(n, mem);
    }

    private static long fibAux(int n, Map<Integer, Long> mem) {
        if (mem.containsKey(n)) return mem.get(n);
        if (n == 1 || n == 2) return 1;
        long value = fibAux(n - 1, mem) + fibAux(n - 2, mem);
        mem.put(n, value);
        return value;
    }

    public static void main(String[] args) {
        System.out.println(fib(100));
    }
}
