[문제 링크](https://leetcode.com/problems/binary-tree-level-order-traversal/)

## 문제
> LeetCode 102: Binary Tree Level Order Traversal

재귀로 순회해서 풀이.


## Java
- Runtime: 0 ms, faster than 100.00% of Java online submissions
- Memory Usage: 42.1 MB, less than 98.72% of Java online submissions
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) dfs(0, root, list);
        return list;
    }
    public static void dfs(int level, TreeNode node, List<List<Integer>> list) {
        if (list.size() == level) list.add(level, new ArrayList<>());
        list.get(level).add(node.val);
        if (node.left != null) dfs(level+1, node.left, list);
        if (node.right != null) dfs(level+1, node.right, list);
    }
}
```
