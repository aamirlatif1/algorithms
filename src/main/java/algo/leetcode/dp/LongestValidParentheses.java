package algo.leetcode.dp;

import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/description/
public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
                arr[i] = 1;
            } else {
                if (stack.isEmpty()) {
                    arr[i] = 0;
                } else {
                    stack.pop();
                    arr[i] = 1;
                }
            }
        }
        while (!stack.isEmpty()) {
            arr[stack.pop()] = 0;
        }
        int max = 0;
        int count = 0;
        for (int j : arr) {
            if (j == 0) {
                if (count - 1 > max)
                    max = count;
                count = 0;
            } else {
                count++;
            }
        }
        if (count > max)
            max = count;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(())("));
        System.out.println(longestValidParentheses(")()())()()("));
        System.out.println(longestValidParentheses(")("));
        System.out.println(longestValidParentheses(")"));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("(()())"));
        System.out.println(longestValidParentheses("())(()()"));
        System.out.println(longestValidParentheses(""));
    }
}
