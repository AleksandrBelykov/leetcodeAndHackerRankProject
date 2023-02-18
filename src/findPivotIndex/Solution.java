package findPivotIndex;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, -1, 0};

        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int result = -1;

        for (int i = 0; i < nums.length; i++){
            int index = i;
            int leftSum;
            int rightSum;

            if (index == 0) {
                leftSum = 0;
            } else {
                leftSum = getSum(nums, 0, index-1);
            }

            if (index == nums.length-1){
                rightSum = 0;
            } else {
                rightSum = getSum(nums, index+1, nums.length-1);
            }

            if (leftSum == rightSum) {
                return index;
            }
        }

        return result;
    }

    private static int getSum(int[] nums, int start, int end){
        int result = nums[start];
        for (int index = start+1; index <= end; index++){
            result += nums[index];
        }
        return result;
    }
}
