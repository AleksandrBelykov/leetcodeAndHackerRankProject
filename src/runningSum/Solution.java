package runningSum;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9,12};
        System.out.println(Arrays.toString(nums));

        int[] res = runningSum(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] runningSum(int[] nums) {
        int collector = nums[0];
        int[] resultSet = new int[nums.length];
        resultSet[0] = collector;

        for(int i = 1; i < nums.length; i++) {
            collector = collector+nums[i];
            resultSet[i] = collector;
        }
        return resultSet;
    }
}
