package algorithms.datastructures.arrays;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static boolean partitionEqualSubsetSum(int nums[]) {
        int target = 0;
        for (int i=0; i<nums.length; i++) {
            target += nums[i];
        }
        if(target % 2 != 0) {
            return false;
        }
        target = target / 2;
        Arrays.sort(nums);
        int sum = 0;
        int start =0;
        for(; start < nums.length; start++) {
            sum += nums[start];
            if(sum == target) {
                start++;
                break;
            }
        }
        for(; start < nums.length; start++) {
            sum -= nums[start];
        }

        if(sum == 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7};
            System.out.println(partitionEqualSubsetSum(arr));
    }
}
