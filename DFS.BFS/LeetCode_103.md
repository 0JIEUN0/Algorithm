[문제 링크](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

## 문제
> LeetCode 103: Binary Tree Zigzag Level Order Traversal

BFS 로 풀이.
Deque 를 사용해서 _zigzag_ 를 구현했다.
- `left->right`로 읽어야 하는 경우: deque 에서 왼쪽(first)부터 값을 읽어오고
  왼쪽 자식(`left`)부터 deque 의 뒤에 넣는다.
  (다음번에 `right->left`로 읽어야 하기 때문)
- `right->left`로 읽어야 하는 경우: deque 에서 오른쪽(last)부터 값을 읽어오고
  오른쪽 자식(`right`)부터 deque 의 앞에 넣는다.


## Java
- Runtime: 1 ms, faster than 96.26% of Java online submissions
- Memory Usage: 40.7 MB, less than 96.57% of Java online submissions
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        boolean order = true; // true: left->right, false: right->left
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            
            while (size-- > 0) {
                TreeNode node = null;
                
                if (order) {
                    node = deque.pollFirst();
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                } else {
                    node = deque.pollLast();
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
                
                if (list.size() == level) list.add(level, new ArrayList<>());
                list.get(level).add(node.val);
            }
            level++;
            order = !order;
        }
        return list;
    }
}
```
