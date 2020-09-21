package algorithms.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContinouesSubArraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(0, -1);
        }};
        ;
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            } else map.put(runningSum, i);
        }
        return false;


        /*if (nums.length <= 1) {
            return false;
        }
        int minimumCountForNumbersSum = 2;
        int runningSum = 0;
        int kDigitSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            kDigitSum += nums[i];
            if (i - minimumCountForNumbersSum >= 0) {
                kDigitSum -= nums[i - minimumCountForNumbersSum];
                if (runningSum == k || kDigitSum == k) {
                    return true;
                }
            } else if (i + 1 == minimumCountForNumbersSum) {
                if (kDigitSum == k) {
                    return true;
                }
            }
        }
        if (runningSum != 0 && k != 0 && runningSum % k == 0) {
            return true;
        }
        return false;*/

//        if(nums.length <= 0) {
//            return false;
//        }
//        int minimumCountForNumbersSum = k;
//        int runningSum = 0;
//        int kDigitSum = 0;
//        for(int i = 0; i< nums.length; i++) {
//            runningSum += nums[i];
//            if(i >= minimumCountForNumbersSum) {
//                kDigitSum += nums[i];
//                if(kDigitSum == k) {
//                    return true;
//                }
//            }
//        }
//        if(runningSum != 0 && k != 0 && runningSum % k == 0) {
//            return true;
//        }
//        return false;
    }

    public static void main(String[] args) {
//        int[] arr = {0}; // 0
//        int[] arr = {23,2,4,6,7}; //-6
        int[] arr = {0, 0}; //-1
        System.out.println(checkSubarraySum(arr, -1));
    }
}
