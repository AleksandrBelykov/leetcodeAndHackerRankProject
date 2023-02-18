7. Reverse Integer
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).


Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21


Constraints:
-231 <= x <= 231 - 1

--------------------------------------------------------------------------------------------------------------------------
Solutions:
1. Solution:
Here a StringBuilder is used as a buffer that than gets converted into Long. 
First, if given "int x" is negative, we append '-' to our the StringBuilder and take Math.abs from x.
Thenin a while-loop we add all digits into a listOfDigits (except tailing 0-s), append them one-by-one to our StringBuilder and convert to Long.
Finally we check if our Long value is greater than MaxInteger or smaller than MinInteger. If not - parse it to Integer and return as a result.

2. SolutionNoUseOfLong:
One of constraints of the task is not to store 64-bit integers. In Java it means we cannot use even a long type.
We start almost the same way - in a while loop we extract every each digit (the constraint is a bit different: "x != 0", because here we work both with 
positive and negative numbers).
Then we add it to our reversed number multiplying existing result by 10 and adding a new digit (positive or negative). 
But before doing it we check if there is a potential danger to overflow. For example, for max value it works like this:
If reversed > Integer.MAX_VALUE/10, we will overflow.
If reversed == Integer.MAX_VALUE / 10, we may overflow. Here we should additionally check if our extracted digit is greater than 7.