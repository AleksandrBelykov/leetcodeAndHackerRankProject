package twoSum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,4,8,19,21, -10};
        int target = 22;

        int[] result = twoSumBrutal(nums, target);
        System.out.println("brutal solution result is "+ Arrays.toString(result));

        int[] result2 = twoSumHash(nums, target);
        System.out.println("hash solution result is "+Arrays.toString(result2));
    }

    //---------------------------------------------------------

    public static int[] twoSumBrutal(int[] nums, int target) {
        int startLoopIndex = 0;
        int firstIndex = 0;
        int lastIndex = Integer.MIN_VALUE;

        while (true) {
            if (lastIndex == Integer.MIN_VALUE) {
                firstIndex = startLoopIndex;
                lastIndex = getOneLoop(startLoopIndex, nums, target);
            } else {
                break;
            }
            startLoopIndex++;
        }

        return new int[]{firstIndex, lastIndex};
    }

    private static int sum(int a, int b){
        int result = a+b;
        return result;
    }

    private static int getOneLoop (int startLoopIndex, int[] nums, int target){
        for (int i = startLoopIndex+1; i < nums.length; i++){
            if(sum(nums[startLoopIndex], nums[i]) == target){
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

    //---------------------------------------------------------

    public static int[] twoSumHash(int[] nums, int target) {
        HashMap<Integer, Integer> mapOfNumsWithIndexes = new HashMap();
        for(int i = 0; i< nums.length; i++){
            Integer secondNumber = target-nums[i];
            if(mapOfNumsWithIndexes.containsKey(secondNumber)){
                return new int[]{i, mapOfNumsWithIndexes.get(secondNumber)};
            } else {
                mapOfNumsWithIndexes.put(nums[i], i);
            }
        }

        return null;
    }

}
