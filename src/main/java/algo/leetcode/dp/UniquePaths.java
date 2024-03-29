package algo.leetcode.dp;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];
        mem[0][0] = 1;
        for (int i = 1; i < m; i++) {
            mem[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            mem[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mem[i][j] = mem[i - 1][j]+mem[i][j - 1];
            }
        }
        return mem[m - 1][n - 1];
    }
}
