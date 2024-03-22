package algo.leetcode.arrays;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/description/
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[1] < t){
                int[] popped = stack.pop();
                res[popped[0]] = i - popped[0];
            }
            stack.push(new int[]{i, t});
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        System.out.println(Arrays.toString(res));
    }

}
