package algorithms.datastructures.arrays;

import java.util.Arrays;
import java.util.Stack;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int carry = 1;
        Stack<Integer> stack = new Stack();
        int sum = 0;
        for(int i=digits.length-1; i>=0; i--) {
            sum = digits[i] + carry;
            if(sum >= 10) {
                stack.push(sum%10);
                carry = 1;
            }
            else {
                stack.push(sum);
                carry = 0;
            }
        }
        if(sum >= 10) {
            stack.push(1);
        }

        int[] arr = new int[stack.size()];
        int i = 0;
        while(stack.size() > 0) {
            arr[i++] = stack.pop();
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr)); // input
        System.out.println(Arrays.toString(plusOne(arr))); // output
    }
}
