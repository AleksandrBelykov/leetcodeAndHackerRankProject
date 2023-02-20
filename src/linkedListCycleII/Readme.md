Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. 
Note that pos is not passed as a parameter.
Do not modify the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.

Constraints:
The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.


Follow up: Can you solve it using O(1) (i.e. constant) memory?

------------------------------------------------------

UPD: Thanks Marlen09 for his idea. Python solution was converted to Java.
Approach
We can use the same approach of detecting a cycle in a linked list using two pointers, the slow and the fast pointer, 
where the slow pointer moves one step at a time and the fast pointer moves two steps at a time. When there is a cycle, 
the fast pointer will eventually catch up to the slow pointer. We also know that the distance between the head of the linked list 
and the start of the cycle is the same as the distance between the point where the slow and the fast pointer meet and the start of the cycle. 
Therefore, after detecting the cycle using the slow and the fast pointers, we can move one of the pointers back to the head of the linked list 
and move both pointers one step at a time until they meet again. The meeting point is the start of the cycle.

Complexity
Time complexity:
O(n)
Space complexity:
O(1)