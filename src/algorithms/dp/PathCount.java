package algorithms.dp;

public class PathCount {

    static int countPath(int m, int n) {
        int p;
        if (m == 1 || n == 1) {
            p = 1;
        } else {
            p = countPath(m - 1, n) + countPath(m, n - 1);
        }
        return p;
    }

    static int countPath_memo(int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        return countPath_m(m, n, memo);
    }

    static int countPath_m(int m, int n, int[][] memo) {
        if (memo[m][n] != 0) return memo[m][n];
        int p;
        if (m == 1 || n == 1) {
            p = 1;
        } else {
            p = countPath(m - 1, n) + countPath(m, n - 1);
        }
        memo[m][n] = p;
        return p;
    }



    static int countPath_hurdle(int m, int n, int[][] he) {
        int[][] memo = new int[m][n];

        int c = 1;
        for (int i = 0; i < m; i++) {
            if(he[0][i] == 1)
                c = 0;
            memo[0][i] = c;
        }
        c = 1;
        for (int i = 0; i < n; i++) {
            if(he[i][0] == 1)
                c = 0;
            memo[i][0] = c;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(he[i][j] == 1)
                    memo[i][j] = 0;
                else
                    memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }
        return memo[m-1][n-1];
    }

    static int countPath_bu(int m, int n) {
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            memo[i][0] = 1;
            memo[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }
        return memo[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(countPath(15, 15));
        System.out.println(countPath_bu(15, 15));
//        System.out.println(countPath_memo(15, 15));
    }
}
