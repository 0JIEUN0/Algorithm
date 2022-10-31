[문제 링크](https://leetcode.com/problems/merge-k-sorted-lists/)


## 문제

> LeetCode: 23. Merge k Sorted Lists

정렬되어 있는 0개 이상의 연결 리스트를 정렬된 하나의 리스트로 반환한다.

기본적으로 연결 리스트를 순회해서 작은 값부터 처리해주는 방법(풀이1)과,
우선순위 큐를 사용하는 방법(풀이2)이 있다.

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
```

## Java (풀이 1)
연결 리스트를 순회하여 작은 값부터 연결해주는 방법
- Runtime: 271 ms, faster than 11.73% of Java online submissions
- Memory Usage: 44.1 MB, less than 91.66% of Java online submissions

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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        int minIdx = 0;
        int notNull = 0;
        ListNode p = null;
        ListNode now = null;
        while (notNull < n) {
            notNull = 0;
            int min = Integer.MAX_VALUE; //Math.pow(10, 4);
            for (int i=0; i<n; i++) {
                if (lists[i] == null) notNull++;
                else if (lists[i].val <= min) {
                    min = lists[i].val;
                    minIdx = i;
                }
            }
            if (notNull == n) break;
            if (p == null) {
                p = now = lists[minIdx];
            } else {
                now.next = lists[minIdx];
                now = now.next;
            }
            lists[minIdx] = lists[minIdx].next;
        }
        return p;
    }
}
```


## Java (풀이 2)
풀이 1로 풀어두고, 다른 방법을 찾아보는 과정에서 푼 방법.
우선순위 큐를 사용.
- Runtime: 16 ms, faster than 26.69% of Java online submissions
- Memory Usage: 48.2 MB, less than 10.82% of Java online submissions

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2)->o1.val-o2.val);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode q = null;
        for (int i=0; i<lists.length; i++) {
            q = lists[i];
            while (q != null) {
                pq.add(q);
                q = q.next;
            }
        }
        ListNode p = null;
        while (!pq.isEmpty()) {
            if (p == null) {
                p = pq.poll();
                q = p;
            } else {
                q.next = pq.poll();
                q = q.next;
            }
        }
        if (q != null) q.next = null;
        return p;
    }
}
```

