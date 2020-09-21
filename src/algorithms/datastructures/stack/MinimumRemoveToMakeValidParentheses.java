package algorithms.datastructures.stack;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static String minRemoveToMakeValid(String s) {
        int length = s.length();
        Stack<Integer> stack = new Stack<>();
        Stack<Character> chars = new Stack<>();
        // int count = 0;
        for(int i=0; i<length;i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                // count++;
                stack.push(i);
                chars.push(ch);
            }
            else if(ch == ')' && stack.size() > 0 && chars.peek() == '(') {
                stack.pop();
                chars.pop();
            }
            else if(ch == ')') {
                // count--;
                stack.push(i);
                chars.push(ch);
            }
        }
        StringBuilder buff = new StringBuilder(s);
        while(stack.size() > 0) {
            int rc = stack.pop();
            if(rc >= 0) {
                buff.deleteCharAt(rc);
            }
        }
        return buff.toString();
    }

    public static void main(String[] args) {
//        System.out.println(minRemoveToMakeValid("a(b)(c"));
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}
