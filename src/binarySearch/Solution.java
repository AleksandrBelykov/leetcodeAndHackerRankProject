package binarySearch;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 14;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1,target);
    }

    private static int binarySearch(int[] nums, int from, int to, int target){
        int mid = (from+to)/2;

        if (nums[mid] == target){
            return mid;
        }
        if (from == to || to == -1) {
            return -1;
        }
        if (nums[mid] > target){
            return binarySearch(nums, from, mid-1, target);
        }
        if (nums[mid] < target){
            return binarySearch(nums, mid+1, to, target);
        }

        return -1;
    }
}
