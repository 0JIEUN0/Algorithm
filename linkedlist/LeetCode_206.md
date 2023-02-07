[문제 링크](https://leetcode.com/problems/reverse-linked-list/)

## 문제
> LeetCode 206. Reverse Linked List

간단한 Linked List 문제.


## Python
- circle 을 없애는 것을 잊지 말기 (`head.next = None`)
```python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None: return head

        prev = head
        cur = head.next
        while cur != None:
            tmp = cur.next
            cur.next = prev
            prev = cur
            cur = tmp
        head.next = None
        return prev
```
