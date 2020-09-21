package algorithms.datastructures.arrays;

import java.util.HashMap;

public class CountDistinctElementsByExcludingItsSelf {
    public static void countDistinctExcludingItself(int[] arr) {
        int length = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i< length; i++) {
            if(hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            else {
                hm.put(arr[i], 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
        countDistinctExcludingItself(arr);
    }
}
