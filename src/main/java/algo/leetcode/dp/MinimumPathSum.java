package algo.leetcode.dp;

//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] mem = new int[rows][cols];
        mem[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            mem[i][0] = mem[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < cols; i++) {
            mem[0][i] = mem[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                mem[i][j] = grid[i][j]+Math.min(mem[i-1][j], mem[i][j-1]);
            }
        }
        return mem[rows-1][cols-1];
    }


}
