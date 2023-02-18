11. Container With Most Water
    Medium

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104

--------------------------------------------------------------------------------------------------------------------

Soluutions.
SolutionStraight:
This is just brutal: 
1. take two maximums, find the result of length*height, remember  the "length" of our container for water and add two maximums into a list (will need it next step).
2. then check: if the length is maximum length ( = height.length-1). If yes that's it, return the result. If not...
3. find another maximum (for this we need to keep a list of all previous maximums) and for each "maximum" that is present in the list do two things:
    a. check if the result is greater than it was before. If yes write it to the variable "result",
    b. check if new length is greater than length before. If yes, write it to the variable "length".
First it comes to be like okay, but the more iterations we have, the worse things go. Time complexity is O(n2) that is not the best practice.

SolutionSophisticated:
(by Stefan Pochmann. Thanks to him I realized how brutal the 1st solution was)
The idea was to manage somehow the indexes that have already been used. Trying to get the solution, I started reading forums and found it written in Python.
We simply go from the maximum length to 0, assuming that if height[i] < height[j], it's impossible to get a container for water greater than the present one for the same height[i].
That means we should go right to another index (i++). The same logics works for index j with the only difference: we should go left (j--).
Every each iteration we compare our variable "result" with the result we get (result = Math.max(result, ...)), and take the max.

Time complexity is O(n). We just iterate until i < j and choose min (or max) between 2 values.
