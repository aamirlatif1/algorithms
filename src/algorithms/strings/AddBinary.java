package algorithms.strings;

import java.util.Stack;

public class AddBinary {
    public static String addBinary(String a, String b) {
        // Initialize result
        String result = "";

        // Initialize digit sum
        int s = 0;

        // Traverse both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0) ? a.charAt(i) - '0' : 0);
            s += ((j >= 0) ? b.charAt(j) - '0' : 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result = (char) (s % 2 + '0') + result;

            // Compute carry
            s /= 2;

            // Move to next digits
            i--;
            j--;
        }
        return result;
    }


    public static String addBinary_v(String a, String b) {
        Stack<Integer> stack = new Stack();
        int lengthA = a.length();
        int lengthB = b.length();
        int length = Math.max(lengthA, lengthB);
        int carry = 0, aa = 0, bb = 0;
        int i = lengthA - 1, j = lengthB - 1, sum = 0;
        for (int k = length - 1; k >= 0; k--) {
            if (i >= 0) {
                aa = (int) (a.charAt(i) - '0');
            } else {
                aa = 0;
            }
            i--;

            if (j >= 0) {
                bb = (int) (b.charAt(j) - '0');
            } else {
                bb = 0;
            }
            j--;

            sum = aa + bb + carry;
            if (sum >= 2) {
                stack.push(sum % 2);
                carry = 1;
            } else {
                stack.push(sum);
                carry = 0;
            }
        }

        if (sum >= 2) {
            stack.push(1);
        }
        StringBuilder buff = new StringBuilder();
        while (stack.size() > 0) {
            buff.append(stack.pop());
        }
        return buff.toString();
    }

    public static void main(String[] args) {
//        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }
}
