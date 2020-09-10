package algorithms.dp;

import static java.lang.Math.max;

public class RodCutting {


    static int cutRod_rec(int[]p, int n){
        if(n == 0)
            return 0;
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = max(q, p[i-1]+cutRod_rec(p, n - i));
        }
        return q;
    }

    public static void main(String[] args) {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(cutRod_rec(p, 10));
    }
}
