package algorithms.dp;

import java.util.HashMap;
import java.util.Map;

public class TripleStep {

    static int hop_rec(int n) {
        int count = 0;
        if (n <= 2)
            count = n;
        else if (n == 3)
            count = 4;
        else
            count = hop_rec(n - 1) + hop_rec(n - 2) + hop_rec(n - 3);
        return count;
    }

    static Map<Integer, Integer> memo = new HashMap<>();

    static int hop_memo(int n) {
        if (memo.containsKey(n)) return memo.get(n);
        int ways;
        if (n <= 2) {
            ways = n;
        } else if (n == 3) {
            ways = 4;
        } else {
            ways = hop_memo(n - 1) + hop_memo(n - 2) + hop_memo(n - 3);
        }
        memo.put(n, ways);
        return ways;
    }

    static int hop_bu(int n) {
        int[] memo = new int[n + 1];
        int ways = 0;
        for (int i = 1; i <= n; i++) {
            if (i <= 2) {
                ways = i;
            } else if (i == 3) {
                ways = 4;
            } else {
                ways = memo[i - 1] + memo[i - 2] + memo[i - 3];
            }
            memo[i] = ways;
        }
        return memo[n];
    }


    public static void main(String[] args) {
        System.out.println(hop_memo(36));
        System.out.println(hop_bu(36));
    }
}
