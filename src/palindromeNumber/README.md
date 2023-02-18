Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.


Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Constraints:

-231 <= x <= 231 - 1


Follow up: Could you solve it without converting the integer to a string?

--------------------------------------------------------------------------------------------------------------------

Soluution:
I came up with a pretty straightforward solution:
1. To break "int x" into digits (the result is an ArrayList of digits from the last to the first one, but it doesn't matter for this task)
2. To find a median index in our ArrayList.
3. To compare the first and the last digits, then the second and the pre-last, then... We need a loop there. 

In the best case we stop at the first iteration (if "int x" is not a palindrome). 
In the worst we'll go until the median index, exit a while loop (for an odd or even number of digits respectively), and return "true" as a result.
