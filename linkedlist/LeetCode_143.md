[문제 링크](https://leetcode.com/problems/reorder-list/)

## 문제
> LeetCode 143. Reorder List

처음엔 매번 마지막 노드를 찾아서 필요한 위치로 넣어줬는데, 
중간 노드를 찾으면 마지막 노드를 효율적으로 찾을 수 있겠다는 생각에 다른 풀이로도 도전.


## java (풀이 1)
- Runtime 5.1&, Memory 83.85% 로 메모리를 살리고 시간을 버린... (매번 마지막 노드를 찾음)
- 짝수개의 node 를 가지는 경우를 고려하지 않아서 오류가 생겼었음.
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode p = head;
        while (true) {
            ListNode lastNode = findLastNode(p);
            if (p == lastNode) break;

            ListNode tmp = p.next;
            p.next = lastNode;
            lastNode.next = tmp;
            p = tmp;
            
            if (p == null) break;
        }
    }
    public static ListNode findLastNode(ListNode head) {
        if (head.next == null) return head;
        ListNode p = head;
        while (p.next.next != null) {
            p = p.next;
        }
        ListNode lastNode = p.next;
        p.next = null;
        return lastNode;
    }
}
```

## java (풀이 2)
- Runtime 100% (1ms), Memory 92.31%
- 매번 마지막 노드를 찾는 것은 비효율적이므로, 중간 노드를 찾아서 2번의 과정으로 재배열하는 방법.
  - ex) 1->2->3->4->5->6
    1) 중간 노드: 3
    2) 중간 노드 이후 node 들을 reverse: 1->2->3->6->5->4
    3) 문제 요구사항에 맞게 재배열: 1->6->2->5->3->4
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode p1 = head;
        ListNode p2 = head;

        // find the middle of linked list
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next; // slow pointer -> middle of linked list
            p2 = p2.next.next; // fast pointer
        }

        // reverse the half after middle
        ListNode mid = p1;
        ListNode mov = p1.next;
        while (mov.next != null) {
            ListNode curr = mov.next;
            mov.next = curr.next;
            curr.next = mid.next;
            mid.next = curr;
        }

        // reorder
        p1 = head;
        while (mid != p1) {
            ListNode tmp = p1.next;
            ListNode curr = mid.next;
            p1.next = curr;
            mid.next = curr.next;
            curr.next = tmp;
            p1 = tmp;
        }

    }
}
```
