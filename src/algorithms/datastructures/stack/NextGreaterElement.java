package algorithms.datastructures.stack;

import java.util.Stack;

/*
https://www.cdn.geeksforgeeks.org/next-greater-element/
 */
public class NextGreaterElement {

    static void nge(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array[0]);
        int next = -1;
        for (int i = 1; i < array.length; i++) {
            next = array[i];
            if (!stack.empty()) {
                int element = stack.pop();
                while (element < next) {
                    System.out.printf("%d --> %d", element, next);

                }
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {4, 5, 2, 25};
        nge(array);
    }
}
