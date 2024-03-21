package algo.leetcode.dp;

import java.util.*;

public class RodeCutting {

    private static int[] mem = new int[41];

    public static int cutRode(int[] p, int n) {
        if (n == 0) return 0;

        if (mem[n] != 0) return mem[n];

        int q = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            q = Math.max(q, p[i] + cutRode(p, n - i - 1));
            mem[n] = q;
        }
        return q;
    }

    public static int cutRodeBU(int[] p, int n) {
        int[] mem = new int[n + 1];
        mem[0] = 0;

        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 0; i < j; i++) {
                q = Math.max(q, p[i] + mem[j - i - 1]);
            }
            mem[j] = q;
        }
        return mem[n];
    }

    public static Map<Integer, Integer> cutRodeSizes(int[] p, int n) {
        int[] mem = new int[n + 1];
        Map<Integer, Integer> sizes = new HashMap<>();
        mem[0] = 0;

        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 0; i < j; i++) {
                if (q < p[i] + mem[j - i - 1]) {
                    q = p[i] + mem[j - i - 1];
                    sizes.put(j, i + 1);
                }
            }
            mem[j] = q;
        }
        return sizes;
    }

    static List<Integer> getSizes(int[] p, int n){
        List<Integer> values = new ArrayList<>();
        var sizes = cutRodeSizes(p, n);
        while (n > 0) {
            values.add(sizes.get(n));
            n -= sizes.get(n);
        }
        return values;
    }


    public static void main(String[] args) {
        int[] p = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 35, 37, 40, 41, 44, 47, 51, 52, 57, 60, 61, 65, 68, 69, 70, 77, 77, 80, 84, 90, 95, 97, 100, 101, 104, 107, 111, 112, 117, 120};
        System.out.println(cutRode(p, 40));
        System.out.println(cutRodeBU(p, 40));
        System.out.println(getSizes(p, 9));
    }
}
