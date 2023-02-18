Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?


------------------------------------------------------------------------------------------
Solutions.

Here are given two solutions to the given issue.
1. The first is brutal with O(n2) time complexity and O(1) space complexity: just two loops. 
To make the code clearer to understand (though a bit longer) inner for-loop is in a separate method, while outer loop is a while-loop.
It's possible to solve this issue just using two for-loops without all these additional indexes that is, I believe, a conventional solution.

2. The second is a bit more sophisticated with O(n) time complexity and O(n) space complexity.
All nums that were looked through are written into a HashMap<Integer, Integer>, where 
"key" = num value,
"value" = num position (index) in the given array.
Every each iteration in the loop we check if the result of substraction target-nums[i] is present as a "key" in our HashMap. 
If yes, so our current index is the first index to return, and the "value" of our "key" is second.