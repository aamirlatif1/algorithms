package algorithms.datastructures.arrays;

import java.util.HashMap;

public class CountDistinctElementsWindowSizeK {
    public static void countWindowDistinct(int[] win, int k) {
        // Base checks
        int length = win.length;
        if(length < k) {
            System.out.println("0");
        }

        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i< length; i++) {
            if(hm.containsKey(win[i])) {
                hm.put(win[i], hm.get(win[i])+1);
            }
            else {
                hm.put(win[i], 1);
            }
            count ++;
            if((count) % k == 0) {
                System.out.println(""+hm.keySet().size());
                if(hm.containsKey(win[i + 1-k])) {
                    int value = hm.get(win[i+1-k]);
                    if(value <= 1) {
                        hm.remove(win[i+1-k]);
                    }
                    else {
                        hm.put(win[i+1-k],  value-1);
                    }
                    count--;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
        int k = 4;
        countWindowDistinct(arr, k);
    }
}
